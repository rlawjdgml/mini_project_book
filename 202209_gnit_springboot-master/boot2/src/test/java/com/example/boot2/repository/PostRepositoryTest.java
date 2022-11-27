package com.example.boot2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest // 스프링 부트 단위 테스트.
public class PostRepositoryTest {
    
    // 의존성 주입(dependency injection), 제어의 역전(Inversion of Control, IoC)
    // 스프링 컨텍스트(spring context)에서 관리되는 객체(bean)들 중에서 
    // 필요한 객체를 변수에 자동으로 할당.
    @Autowired
    private PostRepository postRepo;
    
    @Test // 스프링 단위 테스트 모듈에서 테스트하기 위해서 호출하는 메서드.
    public void test() {
        Assertions.assertNotNull(postRepo);
        //-> postRepo 객체가 null이 아니면 단위 테스트 성공.
        
        // DB 테이블 POSTS에 저장할 엔터티 객체 생성
        Post entity = Post.builder()
                .title("테스트1").content("Spring JPA 테스트").author("admin")
                .build();
        log.info("DB insert 전: {}", entity);
        
        postRepo.save(entity);
        //-> SQL: insert into posts (...) values (?, ...)
        log.info("DB insert 후: {}", entity);
        log.info("DB createdTime: {}", entity.getCreatedTime());
        
        Assertions.assertEquals(1, postRepo.count()); // 테이블의 엔터티 개수(row 개수)
        //-> SQL: select count(*) from posts
        //-> count() 메서드의 리턴 값이 1이면 단위 테스트 성공.
        
        List<Post> list = postRepo.findAll();
        //-> SQL: select * from posts
        for (Post p : list) {
            log.info(p.toString());
        }
    }

}
