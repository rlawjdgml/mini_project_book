package com.example.boot2.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.boot2.dto.PostCreateDto;
import com.example.boot2.dto.PostReadDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostServiceTest {
    
    // PostSerivce 의존성 주입 - 필드 주입
    @Autowired
    private PostService postService;
    
    @Test
    public void test() {
        // PostService 객체가 null이 아닌 지 확인.
        Assertions.assertNotNull(postService);
        
        // PostCreateDto 객체 생성.
        PostCreateDto dto = PostCreateDto.builder()
                .title("test 1").content("서비스 테스트 1").author("admin")
                .build();
        log.info("dto={}", dto);
        
        // PostService 객체의 create 메서드 호출 -> DB(Repository) 저장
        Long result = postService.create(dto);
        log.info("result = {}", result); //-> DB 테이블에는 1개의 엔터티(행)가 저장.
        
        // PostService 객체의 read 메서드 호출 -> DB(repository)에서 select(검색)
        List<PostReadDto> list = postService.read();
        log.info(list.toString());
        
    }

}
