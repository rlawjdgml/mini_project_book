package com.example.boot1.dto;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // toString() override
@NoArgsConstructor // 기본 생성자(argument를 갖지 않는 생성자)
public class SampleDto1 {
    
    private int age;
    private String name;
      
}
