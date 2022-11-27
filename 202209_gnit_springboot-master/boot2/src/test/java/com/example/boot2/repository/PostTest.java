package com.example.boot2.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 콘솔 로그 사용
@SpringBootTest // 스프링부트 애플리케이션 단위 테스트
public class PostTest {
    
    @Test
    public void testPostConstruct() {
        String title = "테스트 제목";
        String content = "테스트 본문";
        String author = "admin";
        
        // Builder(Factory) 패턴으로 객체 생성
        Post entity = Post.builder()
                .title(title).content(content).author(author)
                .build();
        log.info("entity={}", entity);
        
        Assertions.assertNotNull(entity);
        //-> entity가 null이 아니면 테스트 성공, null이면 실패.
        
        Assertions.assertEquals(title, entity.getTitle());
        //-> 기댓값(expected)과 실젯값(actual)이 같으면 테스트 성공, 다르면 실패.
        
        Assertions.assertEquals(content, entity.getContent());
        Assertions.assertEquals(author, entity.getAuthor());
    }

}
