package edu.java.review14;

public class LambdaMain {

    public static void main(String[] args) {
        //Calculator calc = new Calculator(); // 인터페이스는 객체 생성 불가능!
        
        // 1. 외부 클래스 사용:
        // (다형성) Calculator 타입 변수 선언, Adder 타입 객체 생성, 저장.
        Calculator adder = new Adder(); // 외부 클래스
        System.out.println(adder.calculate(1, 2));

        // 2. 지역 클래스 사용:
        // 지역 클래스 정의
        class Subtracter implements Calculator {
            @Override
            public double calculate(double x, double y) {
                return x - y;
            }
        }
        
        Calculator subtracter = new Subtracter(); // 지역 클래스 타입 객체 생성
        System.out.println(subtracter.calculate(1, 2));
        
        // 3. 익명 클래스 사용
        // 클래스 정의와 객체 생성을 한 문장으로 작성하는 문법.
        // 생성자 이름은 super 타입의 이름을 사용. class 선언부 없음.
        Calculator multiplier = new Calculator() {
            @Override
            public double calculate(double x, double y) {
                return x * y;
            }
        };
        System.out.println(multiplier.calculate(1, 2));
        
        // 4. 람다 표현식(lambda expression) - 함수 표기법
        Calculator divider = (x, y) -> x / y;
        // (double x, double y) -> { return x / y; }
        System.out.println(divider.calculate(1, 2));
        
        /*
         * 람다 표현식(함수 표기법):
         * 클래스 정의와 객체 생성을 한 문장으로 작성하는 익명 클래스를 간단히 하기 위한 문법.
         * 자바에서의 람다 표현식은 함수형 인터페이스에서만 사용 가능함.
         * 함수형 인터페이스(functional interface): 추상 메서드를 오직 한 개만 갖는 인터페이스.
         * 문법: (파라미터, ...) -> { 메서드가 할 일; }
         * 파라미터 선언에서 파라미터 타입들은 보통 생략.
         * 람다 표현식 body({ ... })에서 문장이 하나 뿐이면, {}를 생략할 수 있음.
         * body에서 하나 뿐인 문장이 return 문인 경우에는 {}와 return 키워드까지 생략함. (파라미터, ...) -> 리턴값;
         * 람다 표현식에서 파라미터가 한 개뿐인 경우에는 ()를 생략할 수 있음.
         * 
         */
        
        // 숫자 2개 중에서 더 큰 수(또는 같은 수)를 리턴하는 Calculator
        // 1. 익명 클래스
        Calculator whoIsGreater = new Calculator() {
            @Override
            public double calculate(double x, double y) {
                double result  = 0;
                if (x > y) {
                    result = x;
                } else {
                    result = y;
                }
                
                return result;
            }
        };
        System.out.println(whoIsGreater.calculate(1, 2));
        
        // 2. 람다 표현식
        Calculator whoIsGreater2 = (x, y) -> {
//            double result = 0;
//            if (x > y) {
//                result = x;
//            } else {
//                result = y;
//            }
//            return result;
            return (x > y) ? x : y;
        };
        System.out.println(whoIsGreater2.calculate(3, 2));
        
        Calculator whoIsGreater3 = (x, y) -> (x > y) ? x : y;
        System.out.println(whoIsGreater3.calculate(10, 20));
    }

}
