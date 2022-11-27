package com.example.boot2.dto;

import com.example.boot2.repository.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data // @Getter + @Setter + @ToString + ...
// 회원 가입 폼(form)에서 전송하는 데이터를 저장하기 위한 객체
public class UserSignUpDto {
    
    // 필드 이름을 요청 파라미터 이름과 동일하게 작성하고
    // 기본 생성자와 setter 메서드들을 작성하면,
    // DisapatcherServlet에서 요청 파라미터들을 분석해서 객체를 자동으로 생성해 줌.
    private String username;
    private String password;
    private String email;
    
    // DTO 타입을 Entity 타입으로 변환해서 리턴하는 메서드.
    public User toEntity() {
        return User.builder()
                .username(username).password(password).email(email)
                .build();
    }

}
