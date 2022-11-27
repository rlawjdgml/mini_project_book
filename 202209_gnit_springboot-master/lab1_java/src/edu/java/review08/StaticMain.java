package edu.java.review08;

/*
 * static: 멤버(필드, 메서드, 내부 클래스) 선언에서 사용하는 수식어. 지역변수에는 사용할 수 없음.
 *   - 클래스 멤버.
 *   - "클래스이름.멤버" 형식으로 사용.
 *   - 객체가 생성되기 전에 (프로그램 시작 시점에) 메모리에 로딩되는 클래스 멤버.
 *   - 자바 실행 환경(Java Runtime: JRE)이 자바 프로그램을 실행할 때 
 *   클래스 로더(class loader)에 의해서 메모리에 로딩되는 클래스 멤버.
 *   - 프로그램 시작 시점부터 프로그램 종료될 때까지 사용할 수 있는 멤버.
 *   
 * non-static 멤버: static이 아닌 멤버(필드, 메서드, 내부 클래스). 인스턴스 멤버.
 *   - 객체(인스턴스)를 생성한 후에 참조변수를 이용해서 사용하는 멤버.
 */

public class StaticMain {

    public static void main(String[] args) {
        // static 필드/메서드의 예:
        System.out.println(Math.PI); // static 필드(멤버 변수)
        System.out.println(Math.abs(-1)); // static 메서드

        System.out.println(StaticTest.num1); // static field
        StaticTest.num1 = 100;
        StaticTest.printInfo1(); // static method
        
        // 인스턴스 필드/메서드 사용 예:
        // 생성자는 non-static 필드들을 초기화함. static 필드들을 초기화하지 않음!
        StaticTest test = new StaticTest(); // (1) 객체(인스턴스) 생성
        System.out.println(test.num2); // (2) 참조변수(test)를 이용해 변수/메서드 호출.
        test.printInfo2();
        
        StaticTest.num1 = 200;
        test.printInfo2();
        
        StaticTest test2 = new StaticTest();
        test2.printInfo2();
        
        // Singleton 테스트
        SingletonTest singleton1 =  SingletonTest.getInstance();
        System.out.println(singleton1);
        singleton1.setName("캡틴 아메리카");
        
        SingletonTest singleton2 =  SingletonTest.getInstance();
        System.out.println(singleton2);
        System.out.println(singleton2.getName());
        
    }

}
