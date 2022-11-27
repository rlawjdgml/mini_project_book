package com.example.boot1.dto;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor 
//-> final 필드들만 argument로 갖는 생성자.
//-> final 필드가 선언되어 있지 않음. -> RequiredArgsConstructor는 만들어질 수 없음.
//-> 기본 생성자가 자동으로 만들어짐.
public class SampleDto4 {
    
    private int age;
    private String name;

}
