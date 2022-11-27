package edu.java.review01; // 패키지 선언문

public class ReviewMain01 {

    // main 메서드(method): 자바 프로그램의 시작.
    public static void main(String[] args) {
        // 한줄 주석(inline comment): 프로그램 설명
        System.out.println("안녕하세요..."); // 콘솔창 출력
        System.out.println("Ctrl+Space: 코드 추천/자동 완성");
        System.out.println("Ctrl+F11: 프로그램 실행");
        System.out.println("Ctrl+/: 인라인 주석 토글 기능");
        
        // 변수(variable): 데이터를 저장하는 메모리 공간.
        // 변수 선언과 초기화:
        // 타입이름 변수이름 = 값;
        int x = 1;
        System.out.println(x);
        
        // 자바의 데이터 타입
        // 1. 기본 타입(primitive type):
        //    byte, short, int, long, char, float, double, boolean
        // 2. 참조 타입(reference type):
        //    String, System, Math, Random, ...
        
        // 변수 선언 따로, 변수 초기화 따로.
        int y;
//        System.out.println(y); // 컴파일 에러 -> 초기화되지 않은 지역 변수를 사용하려고 했기 때문.
        y = 10;
        System.out.println(y);
        
        // 지역 변수(local variable): 메서드 안에서 선언하는 변수.
        //   선언된 위치에서부터 변수가 속해 있는 블록({})이 끝날 때까지만 사용 가능.
        
        // 연산자(operator)
        // 할당 연산자: =
        // 산술 연산자: +, -, *, /(나눗셈), %(나눈 나머지)
        // 정수/정수=몫, 실수/실수=소수점 이하 계산
        int result = y % 2;
        System.out.println(result);
        System.out.println(y / 2);
        
        // 복합 할당 연산자: +=, -=, *=, /=, %=, ...
        y += 2; // y = y + 2;
        System.out.println(y);
        
        // 증감 연산자: ++, --
        y++;
        System.out.println(y);
        
        // 비교 연산자: ==, !=, >, >=, <, <=
        // 논리 연산자: &&, ||, !
        
    }

}
