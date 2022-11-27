package com.example.boot2.web;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.boot2.dto.UserSignUpDto;
import com.example.boot2.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
    
    private final UserService userService; // 생성자에 의한 의존성 주입
    private final PasswordEncoder passwordEncoder;
    
    @GetMapping("/user/signup")
    public String signUp() {
        log.info("signUp() GET 호출");
        
        return "user/signup";
    }
    
    // method overload: 메서드의 파라미터 선언이 다르면 같은 이름으로 메서드를 여러개 정의할 수 있음.
    // method override: 하위 클래스에서 상위 클래스의 메서드를 재정의하는 것.
    // - 메서드 이름, 파라미터 선언, 리턴 타입이 같아야 함.
    // - 가시성 수식어(private, protected, public)는 범위가 더 넓어지는 것은 가능.
    
    @PostMapping("/user/signup")
    public String signUp(UserSignUpDto dto) {
        log.info("signUp({}) POST 호출", dto);
        
        // 폼에서 제출된 비밀번호를 암호화.
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        
        // DB USERS 테이블에 회원 정보 insert
        Long id = userService.registerUser(dto);
        log.info("회원 가입 결과 = {}", id);
        
        // TODO: 회원 가입 성공인 경우 필요한 페이지(메인/로그인 페이지)로 이동.
        // 회원 가입 실패한 경우에는 필요한 에러 메시지와 함께 다시 회원 가입 페이지로 이동.
        
        return "redirect:/"; // 메인 페이지로 이동
        // 로그인 페이지: "redirect:/login"
    }

}
