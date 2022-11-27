package com.example.boot2.dto;

import java.time.LocalDateTime;

import com.example.boot2.repository.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 파라미터로 선언한 생성자
@Builder // Builder 패턴 객체/메서드
@Data // getter, setter, toString
public class PostReadDto {
    // 포스트 검색 결과에 필요한 데이터
    private Long id; // 글 번호
    private String title; // 글 제목
    private String author; // 글 작성자
    private LocalDateTime modifiedTime; // 글 최종 수정 시간

    public static PostReadDto fromEntity(Post entity) {
        return PostReadDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .modifiedTime(entity.getModifiedTime())
                .build();
    }
    
}
