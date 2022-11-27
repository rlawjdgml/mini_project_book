package com.example.boot1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO(Data Transfer Object): 데이터를 전달하기 위해서 사용하는 객체
// - 메서드를 호출할 때 argument로 전달되는 객체.
// - 메서드가 리턴할 때 리턴 값으로 사용되는 객체.
// 특별한 기능(메서드) 없이, 필드/생성자/getter/setter/toString 정도를 갖는 데이터 클래스.
//@NoArgsConstructor // argument가 없는 기본 생성자를 자동으로 만듦.
//@AllArgsConstructor // 모든 필드를 파라미터로 선언한 생성자를 자동으로 만듦.
//@ToString // toString 메서드를 재정의(override).
//@Setter // final이 아닌 모든 필드의 setter 메서드를 자동으로 만듦.
//@Getter // 모든 필드의 getter 메서드를 자동으로 만듦.

@Data // @RequiredArgsConstructor + @Getter + @Setter + @ToString + @EqualsAndHashCode
public class UserDto {

    // 필드 -> 요청 파라미터 이름과 같게 선언!
    private String userId;
    private String pwd;
    
}
