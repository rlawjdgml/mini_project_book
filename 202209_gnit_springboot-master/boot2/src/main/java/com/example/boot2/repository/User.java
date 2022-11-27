package com.example.boot2.repository;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드들을 argument로 갖는 생성자.
@Builder // all-args 생성자를 이용한 Builder 패턴 클래스/메서드.
@Getter // 모든 필드들의 getter 메서드
@ToString // toString() override
@Entity(name = "USERS") // DB 테이블 엔터티 - name 속성: 테이블 이름.
public class User implements UserDetails {
    
    @Id // PK
    @GeneratedValue(strategy = GenerationType.AUTO) // PK 생성 방식
    private Long id; // Primary Key(고유키)
    
    @Column(nullable = false, unique = true) // 컬럼 제약조건(constraint): not null, unique
    private String username; // 사용자 아이디
    
    @Column(nullable = false) // not null 제약 조건
    private String password; // 사용자 비밀번호
    
    @Column(nullable = false)
    private String email; // 사용자 이메일

    // UserDetails 인터페이스의 추상 메서드들을 구현.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 사용자 (계정)이 가지고 있는 권한(authority)들의 리스트를 리턴.
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정이 만료되지 않음(non-expired).
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정이 잠기지 않음(non-locked).
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호가 만료되지 않음.
    }

    @Override
    public boolean isEnabled() {
        return true; // 사용가능한 사용자 정보
    }

}
