package edu.java.review15;

public class Calculator {
    
    // 내부 인터페이스 선언
    @FunctionalInterface
    public interface Calculable {
        double calculate(double x, double y);
    }

    // Calculator 클래스의 필드
    private double x;
    private double y;
    
    // Calculator 클래스의 생성자
    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Calculator 클래스의 메서드
    public double calculate(Calculable calc) {
        return calc.calculate(x, y);
    }
    
}
