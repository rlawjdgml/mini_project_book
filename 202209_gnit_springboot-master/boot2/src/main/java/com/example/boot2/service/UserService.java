package com.example.boot2.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.boot2.dto.UserSignUpDto;
import com.example.boot2.repository.User;
import com.example.boot2.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화하는 생성자.
@Service // 스프링부트에서 서비스 컴포넌트로 생성하고 관리 - 필요한 곳에 의존성 주입.
public class UserService implements UserDetailsService {
    
    private final UserRepository userRepository; // 생성자에 의한 의존성 주입.

    public Long registerUser(UserSignUpDto dto) {
        log.info("registerUser({})", dto);
        
        // DB의 USERS 테이블에 엔터티를 저장.
        User user =  userRepository.save(dto.toEntity());
        
        return user.getId(); // 테이블에 insert될 때 생성된 id(고유키)를 리턴.
    }

    // UserDetailsService 인터페이스의 추상 메서드를 구현:
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // DB 테이블에 User 엔터티가 존재하면(username이 일치하는 사용자가 있으면) 그 엔터티를 리턴.
        // 엔터티가 없으면(username이 일치하는 사용자가 없으면) null을 리턴하지 말고,
        // UsernameNotFoundException을 발생시켜야 함!
        
        User entity = userRepository.findByUsername(username);
        if (entity != null) {
            return entity;
            // User 타입은 UserDetails의 하위 타입(자식 클래스)이므로 리턴 가능.
        }
        
        throw new UsernameNotFoundException("존재하지 않는 username(" + username + ")");
    }
    
}
