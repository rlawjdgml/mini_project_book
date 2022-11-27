package com.example.boot2.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.boot2.dto.PostUpdateDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Entity class: 데이터베이스의 테이블과 같은 구조로 설계하는 자바 클래스.
// -> 테이블의 컬럼을 자바 클래스의 필드로 선언.
// -> 기본 생성자, getter 메서드는 반드시 정의.
// -> @Entity 애너테이션 설정.

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity(name = "POSTS") // 클래스의 이름과 DB 테이블의 이름이 다를 경우에 name 속성으로 설정.
public class Post extends BaseTimeEntity {

    @Id // 테이블의 고유키(primary key) -> unique, not null
    @GeneratedValue(strategy = GenerationType.AUTO) // PK 생성 방법
    private Long id; // 글 번호
    
    @Column(length = 1000, nullable = false) // Not Null 제약 조건
    private String title; // 글 제목
    
    @Column(length = 4000, nullable = false)
    private String content; // 글 내용(본문)
    
    private String author; // 글 작성자 아이디
    
    // 엔터티 객체의 제목(title)과 내용(content)을 업데이트 하고, 업데이트된 엔터티를 리턴하는 메서드.
    public Post update(PostUpdateDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        
        return this;
    }
    
}
