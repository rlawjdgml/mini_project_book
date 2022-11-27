package com.example.boot1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.boot1.dto.SampleDto1;
import com.example.boot1.dto.SampleDto2;
import com.example.boot1.dto.SampleDto3;
import com.example.boot1.dto.SampleDto4;
import com.example.boot1.dto.SampleDto5;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그를 사용하기 위한 애너테이션
@SpringBootTest // 스프링 부트 애플리케이션 단위 테스트(Unit Test - JUnit)
public class LombokTest {
    
    @Test // 단위 테스트 실행 메서드 - 가시성은 public, 리턴 타입은 void, 파라미터는 선언하지 않음.
    public void testDtoCreate() {
        SampleDto1 dto1 = new SampleDto1();
        log.info("dto1={}", dto1);
        
        SampleDto2 dto2 = new SampleDto2(16, "홍길동");
        log.info("dto2={}", dto2);
        
        SampleDto3 dto3 = new SampleDto3("무명씨");
        log.info("dto3={}", dto3);
        
        SampleDto4 dto4 = new SampleDto4();
        log.info("dto4={}", dto4);
        
        SampleDto5 dto5 = SampleDto5.builder()
                .author("김훈")
                .title("하얼빈")
                .description("역사 소설")
                .build();
        log.info("dto5={}", dto5);
    }

}
