package edu.java.review03;

public class Conditional2Main {

    public static void main(String[] args) {
        // 분기문: switch-case 구문
        // 해당 케이스 코드부터 break;를 만날 때까지 실행!
        // case는 코드를 분기하기 위한 표식(post-it). 실행 코드가 아님.
        // default는 switch 블록에서 가장 마지막에.
        // switch-case에서 사용 가능한 변수 타입: 정수(byte, short, int, long, char), 문자열(String), enum
        // switch-case에서 실수 타입(float, double) 변수는 사용할 수 없음!
        
        // 1. 문자열을 사용한 switch-case
        String time = "아침";
        switch (time) {
        case "아침":
            System.out.println("breakfast");
            break;
        case "점심":
            System.out.println("lunch");
            break;
        case "저녁":
            System.out.println("dinner");
            break;
        default:
            System.out.println("간식");
        }
        
        // 2. 정수를 사용한 switch-case
        int genderCode = 2;
        switch (genderCode) {
        case 1:
        case 3:
            System.out.println("남성");
            break;
        case 2:
        case 4:
            System.out.println("여성");
            break;
        default:
            System.out.println("모름");
        }

        // 3. enum을 사용한 switch-case
        Weekday day = Weekday.FRI;
        switch (day) {
        case MON:
        case TUE:
        case WED:
        case THU:
            System.out.println("열심히 일하자...");
            break;
        case FRI:
            System.out.println("불금불금...");
            break;
        case SAT:
        case SUN:
            System.out.println("잘 쉬자...");
        }
        
    }

}
