package com.example.boot2.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

// 데이터베이스 테이블들이 공통으로 사용하는 시간 정보 컬럼(들)을 정의.
// -> 다른 클래스에서 상속하도록 함.

// JPA(Java Persistence API, 자바 영속성 API)의 auditing 기능을 사용하기 위한 설정:
// auditing 기능: 생성/수정 시간을 자동으로 기록하는 기능.
// 1. BaseTimeEntity 클래스 작성 - @MappedSuperclass, @EntityListeners 설정
// 2. 날짜/시간 필드가 필요한 클래스에서 BaseTimeEntity를 상속.
// 3. JPA auditing 기능을 메인 클래스에서 활성화(enable)시킴 - @EnableJpaAuditing.

@Getter // getter 메서드 자동 생성.
@MappedSuperclass // BaseTimeEntity를 상속하는 하위 클래스들은 생성시간, 수정시간 컬럼을 갖도록 하기 위해서.
@EntityListeners(AuditingEntityListener.class) // 이벤트(insert, update)가 발생할 때 시간 자동 기록.
public class BaseTimeEntity {
    
    @CreatedDate // 엔터티(테이블의 행, row)가 생성되서 테이블에 insert되는 시간을 자동으로 기록.
    private LocalDateTime createdTime; // 생성시간
    
    @LastModifiedDate // 검색한 엔터티의 필드 값들이 변경될 때 시간을 자동으로 기록.
    private LocalDateTime modifiedTime; // 수정시간

}
