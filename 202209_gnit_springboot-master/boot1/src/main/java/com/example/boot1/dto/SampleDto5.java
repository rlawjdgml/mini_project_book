package com.example.boot1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Builder // Builder(Factory) 패턴 코드들을 자동으로 작성.
public class SampleDto5 {
    
    private String title;
    private String author;
    private String description;

}
