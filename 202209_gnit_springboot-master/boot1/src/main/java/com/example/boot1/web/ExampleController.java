package com.example.boot1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.boot1.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 콘솔에 로그를 출력하기 위한 라이브러리.
//-> @Slf4j 애너테이션(annotation)을 사용하면 log 객체를 사용할 수 있음. 
@Controller // 클래스를 스프링부트 앱의 콘트롤러 객체(클라이언트의 요청 처리하는 객체)로 등록.
public class ExampleController {

    @GetMapping("/ex1") // 요청 주소 "/ex1"의 GET 방식 요청을 처리하는 메서드.
    public String ex1() {
        log.info("ex1() 호출");
        
        return "/example/ex1"; // HTML 파일이 저장된 폴더 위치와 이름.
        //-> 템플릿 엔진(thymeleaf, mustache, ...)을 사용하는 경우에는,
        // src/main/resources/templates 폴더 아래의 (하위 폴더를 포함하는) 파일 이름.
        // 파일 확장자(html, mustache, ...)는 생략.
    }
    
    @GetMapping("/ex2") // 요청 주소 "/ex2"의 GET 방식 요청을 처리하는 메서드.
    // 콘트롤러 메서드의 파라미터를 선언할 때 요청 파라미터(request parameter) 이름과 동일하게 선언하면,
    // DispatcherServlet이 콘트롤러 메서드를 호출할 때 요청 파라미터의 값을 argument로 전달해줌.
    public String ex2(String keyword, Model model) {
        log.info("ex2(keyword={}) 호출", keyword);
        
        // Model: 콘트롤러에서 뷰(view - HTML)에 데이터를 전달할 때 사용하는 객체.
        model.addAttribute("searchKeyword", keyword);
        
        return "/example/ex2";
    }
    
    @GetMapping("/ex3")
    public String ex3(@RequestParam(name = "q", defaultValue = "기본값") String keyword, 
            Model model) {
        // @RequestParam 애너테이션:
        // (1) 요청 파라미터 이름과 메서드 파라미터 이름이 다를 때 사용.
        // (2) 요청 파라미터 값이 없을 때 사용할 기본값(defaultValue)를 설정하기 위해서 사용.
        
        log.info("ex3(keyword={})", keyword);
        
        model.addAttribute("searchKeyword", keyword);
        
        return "/example/ex2";
    }
    
    // GET 요청: 요청 파라미터(request parameter)가 요청 주소(URL)에 포함되어 전달되는 방식.
    // POST 요청: 요청 파라미터가 요청 주소에 보이지 않고, 요청 패킷(HTTP packet)의 body에 포함되어 전달되는 방식.
    
    @PostMapping("/ex4") // POST 방식의 "ex4" 요청 주소를 처리하는 콘트롤러 메서드.
    public String ex4(String userId, String pwd, Model model) {
        log.info("ex4(userId={}, pwd={})", userId, pwd);
        
        model.addAttribute("userId", userId);
        model.addAttribute("pwd", pwd);
        
        return "/example/ex4";
    }
    
    @PostMapping("/ex5")
    public String ex5(UserDto dto, Model model) {
        // DispatcherServlet이 ex5() 메서드를 호출할 때
        // 1. UserDto 클래스의 기본 생성자를 호출해서 객체를 호출.
        // 2. 요청 파라미터 이름에 해당하는 setter 메서드(userId -> setUserId)를 호출.
        // 3. 요청 파라미터 값들로 채워진 UsetDto 객체를 argument로 전달해줌.
        
        log.info("ex5(dto={})", dto);
        
        model.addAttribute("dto", dto);
        
        return "/example/ex4";
    }
    
}
