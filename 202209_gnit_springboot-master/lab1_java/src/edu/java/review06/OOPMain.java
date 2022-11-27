package edu.java.review06;

/*
 * OOP(Object-Oriented Programming): 객체 지향 프로그래밍
 * 객체(Object): 프로그램에서 만들려고 하는 대상. 속성(데이터)와 기능을 가질 수 있음.
 * 클래스(Class): 객체를 만들기 위해서 프로그래밍 언어로 작성하는 코드.
 *   - 객체를 만들기 위한 설계도
 *   - 필드(field, 속성 property, 멤버 변수) + 생성자(constructor) + 메서드(method)
 *   - 클래스는 데이터 타입. 변수 선언에서 사용.
 * 인스턴스(instance): 클래스를 사용해서 메모리에 생성된 객체.
 * 
 * 클래스 선언(정의):
 * [수식어] class 클래스이름 { ... }
 */

public class OOPMain {

    public static void main(String[] args) {
        // Employee 타입 변수 선언, 객체 생성(생성자 호출: new 클래스이름())
        // 객체가 생성될 때 객체의 속성들이 초기화됨.
        Employee emp1 = new Employee(); // 기본 생성자 호출
        System.out.println(emp1);
        System.out.println("사번: " + emp1.empNo);
        System.out.println("이름: " + emp1.empName);
        System.out.println("급여: " + emp1.salary);
        
        // argument를 갖는 생성자를 사용해서 객체를 생성.
        // argument: 함수(생성자, 메서드)를 호출할 때, 그 함수에게 전달하는 값(들).
        Employee emp2 = new Employee(101, "홍길동", 100);
        System.out.println("사번: " + emp2.empNo);
        System.out.println("이름: " + emp2.empName);
        System.out.println("급여: " + emp2.salary);
        
        Employee emp3 = new Employee(201);
        System.out.println("사번: " + emp3.empNo);
        System.out.println("이름: " + emp3.empName);
        System.out.println("급여: " + emp3.salary);
        
        // emp2(홍길동)의 급여를 10% 인상
        double result = emp2.raiseSalary(0.1);
        System.out.println("인상된 급여 = " + result);
        System.out.println("홍길동 급여 = " + emp2.salary);
        emp2.printEmpInfo();
        
    }

}
