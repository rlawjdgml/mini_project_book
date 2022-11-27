package edu.java.review10;

/*
 * 상속(inheritance): 상위 클래스의 멤버들을 확장해서 하위 클래스를 설계하는 방법.
 * 상위 클래스(super class), 부모 클래스(parent class), 기본 클래스(base class) - 사람
 * 하위 클래스(sub class), 자식 클래스(child class), 유도 클래스(derived class) - 회사원, 학생, ...
 * 
 * 자바의 모든 클래스는 Object를 상속함. 자바의 최상위 클래스는 Object.
 * 
 * class 하위클래스이름 extends 상위클래스이름 { ... }
 * 자바의 최상위 클래스인 Object만 상속하는 경우에는 extends Object를 생략함.
 * 
 */

/*
 * final 수식어: 클래스, 멤버(필드, 메서드), 지역 변수를 수식. 최종(마지막) -> 변경할 수 없는.
 * 1) final 지역 변수: 값을 한 번만 초기화할 수 있고, 초기화 이후에는 값을 변경할 수 없는 지역 변수.
 * 2) final field(멤버 변수): 반드시 한 번 초기화를 해야 하고, 초기화한 이후에는 값을 변경할 수 없는 필드.
 *    (1) 멤버 변수를 선언하는 위치에서 초기화
 *    (2) argument를 갖는 생성자에서 초기화
 * 3) final 메서드: 변경할 수 없는 메서드. 재정의(override)할 수 없는 메서드.
 *    상위 클래스에서 정의한 메서드를 하위 클래스에서 재정의할 수 없음.
 * 4) final 클래스: 변경할 수 없는 클래스. 상속할 수 없는 클래스.
 *    하위 클래스를 가질 수 없는 클래스.
 */

class A {
    final public void test1() {} 
}

class B extends A {
//    @Override
//    public void test1() {};
    // final 메서드는 하위 클래스에서 재정의할 수 없음.
}

final class C {}

//class D extends C {}


public class InheritanceMain {
    
    final String s1 = "Java"; // (1) final 멤버 변수 선언 위치에서 초기화.
    final String s2; // (2) final 멤버 변수를 생성자에서 초기화.
    
    public InheritanceMain(String s2) {
        this.s2 = s2; // (2) final 멤버 변수를 생성자에서 초기화.
    }
    
    public static void main(String[] args) {
        final int x = 1;
        // x = 10; -> final 지역 변수는 초기화 이후에는 값을 변경할 수 없음.
        final int y; // final 지역 변수는 선언할 때 반드시 초기화할 필요는 없음.
        
        // Person 타입 변수 선언, 객체 생성
        Person p1 = new Person();
        System.out.println(p1);
        // println(Object o) 메서드는 
        // Object 타입 객체의 toString() 메서드가 리턴하는 문자열을 콘솔창에 출력해줌.
        System.out.println(p1.getName());
        
        Person p2 = new Person("오쌤");
        System.out.println(p2);
        System.out.println(p2.getName());

        System.out.println("\n==========\n");
        
        // BusinessPerson 타입 변수 선언, 객체 생성.
        BusinessPerson p3 = new BusinessPerson();
        System.out.println(p3);
        System.out.println(p3.getName());
        
        System.out.println("\n==========\n");
        
        BusinessPerson p4 = new BusinessPerson("홍길동", "활빈당");
        System.out.println(p4);
        System.out.println(p4.getName());
        System.out.println(p4.getCompany());
        
        // 다형성(polymorphism): 변수가 상위 타입으로 선언되어 있으면,
        // 상위 타입 뿐만 아니라 그 하위 타입의 객체들까지 저장할 수 있는 속성.
        Person p5 = new Person(); // 사람은 사람이다. (O)
        Person p6 = new BusinessPerson(); // 회사원은 사람이다. (O)
//        BusinessPerson p7 = new Person(); // 사람은 회사원이다. (X) -> 컴파일 에러!
        
    }

}
