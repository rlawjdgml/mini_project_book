package com.example.boot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity, ID>를 상속하는 인터페이스를 선언.
// -> 스프링 컨텍스트에 Repository 컴포넌트로 등록 - 객체로 생성되고 관리됨.

// Repository component:
// DB 테이블에서 CRUD(Create, Read, Update, Delete) 작업을 할 수 있는 메서드들을 갖고 있는 객체.
// create - insert, read - select

public interface PostRepository extends JpaRepository<Post, Long> {

    // POSTS 테이블의 모든 컬럼을 검색, 검색 결과를 ID 컬럼의 내림차순으로 정렬.
    // select * from POSTS order by ID desc;
    // 인터페이스에서 메서드 이름을 정의할 때, Spring-JPA에서 사용하는 상용구를 이용하면
    // 메서드 body가 구현된 객체가 자동으로 생성됨.
    List<Post> findByOrderByIdDesc();
    
    // 검색 기능에 필요한 메서드
    // (1) 글 제목으로 검색하기:
    // select * from POSTS where lower(TITLE) like lower(검색어) order by ID desc;
    List<Post> findByTitleContainingIgnoreCaseOrderByIdDesc(String keyword);
    
    // (2) 글 내용으로 검색하기:
    List<Post> findByContentContainingIgnoreCaseOrderByIdDesc(String keyword);
    
    // (3) 작성자로 검색하기:
    List<Post> findByAuthorContainingIgnoreCaseOrderByIdDesc(String keyword);
    
}
