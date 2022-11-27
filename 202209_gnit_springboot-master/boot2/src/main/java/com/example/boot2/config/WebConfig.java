package com.example.boot2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.boot2.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration // 스프링부트 애플리케이션이 사용하는 환경 설정 객체
public class WebConfig extends WebSecurityConfigurerAdapter {
    
    private final UserService userService;
    
    @Bean // 스프링 프레임워크에서 객체(bean) 생성, 관리 -> 필요한 곳에 의존성 주입.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 비밀번호 암호화 알고리즘.
    }
    
    // 사용자 인증 - 로그인 가능한 사용자 인증에 대한 설정.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // in-memory user store(테스트 용도) 사용.
//        auth.inMemoryAuthentication()
//            .withUser("user1")
//            .password(passwordEncoder().encode("1111"))
//            .roles("USER")
//        .and()
//            .withUser("user2")
//            .password(passwordEncoder().encode("2222"))
//            .roles("USER");
        
        // DB 테이블(USERS)에 저장된 사용자 정보를 이용해서 로그인.
        // (1) User 클래스(entity)가 UserDetails 인터페이스를 구현 -> Role 정의
        // (2) UserReposioty 인터페이스에서 findByUsername 메서드를 선언.
        // (3) UserService 클래스 선언, UserDetailsService 인터페이스를 구현.
        
        auth.userDetailsService(userService) 
            // 인증할 때 필요한 UserDetailsService 객체를 지정 -> findByUsername 메서드 이용.
            .passwordEncoder(passwordEncoder()); 
            // 비밀번호 암호화 알고리즘 지정 - 로그인 시 사용자가 입력한 비밀번호와 DB의 암호화된 비밀번호를 비교하기 위해서.
    }
    
    // HTTP 보안(HttpSecurity) 설정
    // - 인증을 통해서 접근 가능한 페이지 설정 - 로그인 사용자만 접근 가능한 페이지
    // - 인증 없이 접근 가능한 페이지 설정 - 로그인 하지 않아도(익명 사용자) 접근 가능한 페이지
    // - 로그인 설정 - 로그인 페이지(Spring 제공, 브라우저 제공, custom, ...), 소셜 로그인, ...
    // - 로그아웃 설정 - 로그아웃 페이지, 로그아웃 후에 이동할 페이지, ...
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .headers().frameOptions().disable()
        // 여기까지 설정은 (1) h2-console을 사용하기 위해서. (2) Ajax 사용하기 위해서.
        .and()
            .authorizeHttpRequests() // 인증 필요한 요청, 인증 필요 없는 요청을 설정
            .antMatchers("/post/create", "/post/modify/**", "/post/read/**", "/api/post/**")
            .hasRole("USER") // USER 권한을 가진 사용자들만 접근 가능한 페이지(요청 주소)
            .antMatchers("/", "/**")
            .permitAll() // 익명 사용자들도 접근 가능한 페이지(요청 주소)
        .and()
//            .httpBasic() // 브라우저의 기본 로그인 다이얼로그 사용.
            .formLogin(Customizer.withDefaults()) // 스프링에서 제공하는 기본 로그인 UI
            .logout() // 로그아웃 설정 시작
            .logoutSuccessUrl("/") // 로그아웃 이후에 메인 페이지로 이동
        ;
        
    }

}
