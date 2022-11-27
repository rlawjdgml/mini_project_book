package com.example.boot1.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot1.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // 스프링 애플리케이션에서 REST 콘트롤러 컴포넌트로 관리됨.
// Controller: 메서드의 리턴값(문자열)은 뷰(HTML 템플릿) 파일 이름.
// REST Controller: 메서드의 리턴값은 클라이언트(브라우저)로 직접 전달.
public class ExampleRestController {

    @GetMapping("/rest1")
    public String rest1() {
        log.info("rest1() 호출");
        return "안녕하세요, REST 콘트롤러!";
    }
    
    @GetMapping("/rest2")
    public UserDto rest2() {
        log.info("rest2() 호출");
        
        UserDto user = new UserDto();
        user.setUserId("guest");
        user.setPwd("guest0000");
        
        return user;
    }
    
}
