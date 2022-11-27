package edu.java.review10;

// 회사원은 사람이다. --> 사람: 상위 클래스, 회사원: 하위 클래스.
// extends Object 가 생략되어 있음.
public class Person {
    // 필드
    private String name;
    
    // 생성자
    public Person() {
        System.out.println("Person() 생성자 호출");
    }
    
    public Person(String name) {
        this.name = name;
        System.out.println("Person(name) 생성자 호출");
    }
    
    // 메서드: getter/setter
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // overload: 파라미터가 다를 때 같은 이름으로 여러 개의 다른 메서드 (또는 생성자)들을 정의하는 것.
    // 메서드 override: 상위 클래스에서 정의된 메서드를 하위 클래스에서 재정의.
    // override를 할 때는 상위 클래스의 메서드 이름, 리턴 타입, 파라미터 선언이 모두 일치해야 됨!
    // override를 할 때 가시성(visibility)는 상위 클래스의 가시성과 같거나 더 넓어지면 됨.
    // 가시성: private < (package) < protected < public
    
    @Override // 애너테이션(annotation) - 자바 컴파일러에게 override하는 메서드임을 알려줌.
    public String toString() {
        return String.format("Person(name=%s)", name);
    }
    
}
