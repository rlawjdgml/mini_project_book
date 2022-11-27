package com.example.boot2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.boot2.dto.PostCreateDto;
import com.example.boot2.dto.PostReadDto;
import com.example.boot2.dto.PostUpdateDto;
import com.example.boot2.repository.Post;
import com.example.boot2.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final로 선언된 필드를 파라미터로 갖는 생성자.
@Service
//-> 스프링 컨텍스트에서 Service 컴포넌트 객체로 생성되고, 관리됨 -> 필요로 하는 클래스에 주입.
public class PostService {
    
    // Service 계층의 클래스는 Repository 계층의 클래스를 사용
    // -> 의존성 주입: (1) 필드 주입, (2) 생성자 주입 - final field + 생성자
    // @Autowired private PostRepository postRepository; // 필드 주입
    private final PostRepository postRepository; // 생성자 주입
    
    public Long create(PostCreateDto dto) {
        log.info("create({})", dto);
        
        // PostCreateDto 객체를 Post 엔터티 객체로 변환
        Post entity = dto.toEntity();
        log.info("DB save 전 entity = {}", entity);
        
        postRepository.save(entity); // DB posts 테이블에 엔터티를 저장(insert SQL).
        log.info("DB save 후 id = {}", entity.getId());
        
        return entity.getId(); // DB 테이블에 insert된 글(Post)의 글 번호를 리턴.
    }

    @Transactional(readOnly = true) // 검색한 엔터티를 변경하지 않음. 읽기 전용 검색.
    //-> Spring-JPA에서 검색 속도가 빨라짐.
    public List<PostReadDto> read() {
        log.info("read()");
        
        List<Post> list = postRepository.findByOrderByIdDesc();
        log.info("# of list = {}", list.size());
        
        return list.stream() // Stream 객체 생성(List의 원소인 Post 객체들이 하나씩 지나가는 통로)
                .map(PostReadDto::fromEntity) // Post 객체를 PostReadDto 타입으로 매핑
                .toList(); // 결과들을 List로 묶어줌.
    }

    @Transactional(readOnly = true) // 읽기 전용 검색
    public Post read(Long id) {
        log.info("read(id={})", id);
        
        return postRepository.findById(id).orElseThrow();
    }

    public Long delete(Long id) {
        log.info("delete(id={})", id);
        
        postRepository.deleteById(id); // DB 테이블에서 일치하는 id를 찾아서 row 삭제.
        
        return id; // 삭제한 포스트 글 번호를 리턴.
    }

    @Transactional // readOnly 속성의 기본값 = false -> 엔터티를 변경할 수 있음.
    public Post update(Long id, PostUpdateDto dto) {
        log.info("update(id={}, dto={})", id, dto);
        
        // 포스트 글 번호(id)로 DB에서 검색
        Post entity = postRepository.findById(id).orElseThrow();
        log.info("업데이트 전 entity = {}", entity);
        
        // DB에서 검색한 엔터티를 변경
        entity.update(dto);
        log.info("업데이트 후 entity = {}", entity);
        
        // 메서드 이름 앞에 @Transactional 애너테이션을 사용한 경우,
        // postRepository.save(entity) 메서드를 호출하지 않아도,
        // 트랜잭션이 끝나는 시점(메서드가 종료되는 시점)에 DB 저장이 자동으로 이루어짐.

        // postRepository.save(entity) 메서드의 기능:
        // (1) DB에 저장되지 않은 엔터티인 경우, insert SQL
        // (2) DB에 저장된 엔터티인 경우, update SQL
        
        return entity; // 업데이트가 완료된 엔터니 객체를 리턴.
    }

    @Transactional(readOnly = true)
    public List<PostReadDto> search(String type, String keyword) {
        log.info("search(type={}, keyword={})", type, keyword);
        
        // postRepository 검색 메서드
        List<Post> result = null;
        switch (type) {
        case "t": // 제목 검색
            result = postRepository.findByTitleContainingIgnoreCaseOrderByIdDesc(keyword);
            break;
        case "c": // 내용 검색
            result = postRepository.findByContentContainingIgnoreCaseOrderByIdDesc(keyword);
            break;
        case "a": // 작성자 검색
            result = postRepository.findByAuthorContainingIgnoreCaseOrderByIdDesc(keyword);
            break;
        default:
            result = new ArrayList<>();
        }
        
        return result.stream()
                .map(PostReadDto::fromEntity)
                .toList();
    }
    
}
