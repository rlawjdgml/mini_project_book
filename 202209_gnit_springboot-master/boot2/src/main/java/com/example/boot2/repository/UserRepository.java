package com.example.boot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 인터페이스를 상속하는 인터페이스를 선언.
// 스프링부트에서 bean(객체)으로 관리, 기본적인 DB CRUD 작업에 필요한 메서드들도 구현됨.
public interface UserRepository extends JpaRepository<User, Long> {

    // select * from USERS where USERNAME = ? 결과를 리턴하는 메서드.
    User findByUsername(String username);
    
}
