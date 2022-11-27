package edu.java.review14;

// Calculator 인터페이스를 구현하는 클래스
public class Adder implements Calculator {

    @Override // 인터페이스가 가지고 있는 추상 메서드 (재정의) 구현.
    public double calculate(double x, double y) {
        return x + y;
    }
    
}
