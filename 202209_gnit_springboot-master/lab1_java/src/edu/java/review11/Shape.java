package edu.java.review11;

// 추상 클래스(abstract class)
public abstract class Shape {
    private String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    // 도형의 넓이를 리턴하는 메서드.
    public abstract double area(); // 추상 메서드(abstract method)
    // 도형의 둘레 길이를 리턴하는 메서드.
    public abstract double perimeter(); // 추상 메서드.
    
    public void info() {
        String info = String.format("%s(넓이=%f, 둘레길이=%f)", 
                name, area(), perimeter());
        System.out.println(info);
    }

}
