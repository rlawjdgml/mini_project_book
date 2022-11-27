package edu.java.review08;

// Singleton(싱글톤) 디자인 패턴:
// 프로그램 전체에서 인스턴스를 오직 하나만 생성할 수 있도록 클래스를 작성하는 방법.

public class SingletonTest {
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Singleton = (1) + (2) + (3)
    // (1) private static 자기자신 타입 필드 -> 프로그램 시작과 동시에 메모리에 생성되어야 할 변수.
    private static SingletonTest instance = null;
    // (2) private 생성자 -> 다른 클래스에서 생성자를 호출하지 못하도록(객체를 생성하지 못하도록).
    private SingletonTest() {}
    // (3) public static 자기자신 타입 리턴하는 메서드 -> 생성자를 대신해서 객체를 오직 하나만 생성해 주는 메서드.
    public static SingletonTest getInstance() {
        if (instance == null) {
            instance = new SingletonTest();
        }
        
        return instance;
    }

}
