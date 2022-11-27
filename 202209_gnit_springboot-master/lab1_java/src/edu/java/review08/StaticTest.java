package edu.java.review08;

public class StaticTest {
    // 필드
    static int num1; // static field
    int num2; // non-static fields
    
    // 메서드
    // static method
    public static void printInfo1() {
        System.out.println("--- static method ---");
        System.out.println("num1 = " + num1);
        // System.out.println("num2 = " + num2);
        //-> 컴파일 에러: static 멤버는 static 멤버만 사용 가능.
    }
    
    // non-static method
    public void printInfo2() {
        System.out.println("--- non-static method ---");
        System.out.println("num2 = " + num2); // this.num2
        System.out.println("num1 = " + num1); // StaticTest.num1
        // non-static 멤버는 static/instance 멤버 모두 사용 가능.
    }

}
