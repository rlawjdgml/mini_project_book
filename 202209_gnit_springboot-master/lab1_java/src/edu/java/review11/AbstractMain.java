package edu.java.review11;

/*
 * abstract: 추상적인.
 * 
 * 1. abstract 메서드:
 *    (1) 메서드의 signature(수식어, 리턴타입, 이름, 파라미터 선언)만 선언하고,
 *    본체(body)를 정의하지 않은 메서드. {} 블록이 없음.
 *    (2) 호출할 수 없는 메서드.
 *    (3) 추상 메서드는 반드시 abstract 키워드로 수식해야 하고, 세미콜론(;)으로 문장을 끝내야 함.
 *    (4) 하위 클래스에서 재정의(override)하면서 body를 구현할 목적인 메서드.
 * 2. abstract 클래스:
 *    (1) abstract 수식어가 있는 클래스.
 *    (2) 객체를 생성할 수 없는 클래스.
 *    (3) 클래스에 추상 메서드가 하나라도 있는 경우에는, 그 클래스는 반드시 abstract으로 선언해야 됨.
 * 
 */

public class AbstractMain {

    public static void main(String[] args) {
        // Shape 타입으로 변수 선언, 객체 생성?
        //Shape s = new Shape("동그라미"); -> 추상 클래스는 객체 생성이 불가능.
        
        // Shape 타입 변수 선언, Circle 타입 객체 생성, 저장
        Shape circle = new Circle(1);
        circle.info();
        
        // Shape 타입 변수 선언, Rectangle 타입 객체 생성, 저장
        Shape rect = new Rectangle(3, 4);
        rect.info();

    }

}
