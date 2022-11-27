package edu.java.review15;

import edu.java.review15.Calculator.Calculable;

public class Lambda2Main {

    public static void main(String[] args) {
        // Calculator 타입 변수 선언, 객체 생성
        Calculator calculator = new Calculator(1, 2);
        
        // Calculable 인터페이스를 구현하는 지역 클래스 선언.
        class Adder implements Calculable {
            @Override
            public double calculate(double x, double y) {
                return x + y;
            }
        }
        
        // Calculable 타입 변수 선언, Adder 타입의 객체 생성
        Calculable adder = new Adder();
        
        // calculator 인스턴스의 메서드(기능)을 사용.
        System.out.println(calculator.calculate(adder));

        // 익명 클래스 객체를 변수에 저장.
        Calculable subtracter = new Calculable() {
            @Override
            public double calculate(double x, double y) {
                return x - y;
            }
        };
        System.out.println(calculator.calculate(subtracter));
        
        // 익명 클래스 객체를 arguement로 전달
        System.out.println(calculator.calculate(new Calculable() {
            @Override
            public double calculate(double x, double y) {
                return x * y;
            }
        }));
        
        // 람다 표현식:
        System.out.println(calculator.calculate((x, y) -> x / y));
        System.out.println(calculator.calculate((x, y) -> (x > y) ? x : y));
    }

}
