package edu.java.review02;

public class ConditionalMain {

    public static void main(String[] args) {
        // 조건문(conditional statement)
        int number = 12;
        if (number % 2 == 0) { // number를 2로 나눈 나머지가 0이면(짝수이면)
            System.out.println("짝수"); // (1)
        } else { // 그렇지 않으면(홀수이면)
            System.out.println("홀수"); // (2)
        }

        // else 블록은 필수는 아님.
        if (number % 2 == 0) {
            System.out.println("even number");
        }
        System.out.println("if 끝");
        
        // if-else if-else
        number = -5;
        if (number > 0) { // number가 0보다 크다면(양수이면)
            System.out.println("양수");
        } else if (number < 0) { // 그렇지 않고 number가 0보다 작다면(음수이면)
            System.out.println("음수");
        } else { // 그렇지도 않다면
            System.out.println("영");
        }
        
        // 중첩 조건문: if 블록 또는 else 블록 안에 또다른 조건문이 있는 경우.
        if (number > 0) {
            System.out.println("양수");
        } else {
            if (number == 0) {
                System.out.println("영");
            } else {
                System.out.println("음수");
            }
        }
        
        // 삼항 연산자: (조건식) ? 값1 : 값2
        // 조건식을 만족하면 "값1"을 선택, 그렇지 않으면 "값2"를 선택.
        // 1, 3 -> "남성", else -> "여성"
        int code = 4;
        String gender = (code == 1 || code == 3) ? "남성" : "여성";
        System.out.println(gender);
        
    }

}
