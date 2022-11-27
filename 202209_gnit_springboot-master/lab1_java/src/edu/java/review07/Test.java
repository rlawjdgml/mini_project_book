package edu.java.review07;

public class Test {
    private int age;
    private String name;
    
    public Test(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // getter 메서드: private 멤버 변수(필드)의 값을 리턴하는 메서드.
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    // setter 메서드: private 필드의 값을 설정(다른 값으로 변경)하는 메서드.
    public void setAge(int age) {
        this.age = age;
    }
    
}
