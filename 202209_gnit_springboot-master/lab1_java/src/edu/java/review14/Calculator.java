package edu.java.review14;

@FunctionalInterface // 자바 컴파일러가 함수형 인터페이스인 지를 검사.
public interface Calculator {
    
    // public abstract 생략
    double calculate(double x, double y);

}
