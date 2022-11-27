package com.example.boot2.dto;

import com.example.boot2.repository.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO(Data Transfer Object, 데이터 전달 객체)
// 각 계층 사이에서 데이터를 전달할 때 사용하는 객체.
// 메서드의 파라미터 타입 또는 메서드의 리턴 타입으로 사용되는 객체.

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data // getter, setter, toString
public class PostCreateDto {
    // 새 글(Post)를 작성할 때 필요한 데이터
    private String title; // 제목
    private String content; // 내용(본문)
    private String author; // 작성자
    
    // PostDto 객체를 Post 엔터티 객체로 변환하는 메서드.
    public Post toEntity() {
        return Post.builder()
                .title(title).content(content).author(author)
                .build();
    }
}
