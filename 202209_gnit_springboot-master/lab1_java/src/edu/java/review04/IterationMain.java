package edu.java.review04;

public class IterationMain {

    public static void main(String[] args) {
        // for 반복문
        // for (초기화 문장; 반복 검사 조건식; 변경문) { ... }
        
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        
        // escape 문자열: "\n" - 줄바꿈, "\t" - 탭, ...
        System.out.println("\n-----\n");

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
        }
        
        System.out.println("\n-----\n");
        
        // 0 이상 10 이하의 짝수들만 출력
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }

        System.out.println("\n-----\n");
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        
        System.out.println("\n-----\n");
        
        // while 반복문
        // while (조건식) { 조건이 참일 때 반복할 문장(들); }
        int n = 0; // 시작 값.
        while (n < 5) {
            System.out.println(n);
            n++;
        }
        
        System.out.println("\n-----\n");
        
        // do-while 반복문
        // do { 반복할 문장들; } while (조건식);
        // do-while 문장이 while 문과 다른 점은 do 블록({}) 안의 내용이 반드시 1번은 실행된다는 점.
        n = 5;
        do {
            System.out.println(n);
            n--;
        } while (n > 0);
        
    }

}
