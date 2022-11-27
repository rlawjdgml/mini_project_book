package edu.java.review13;

import edu.java.review13.Outer.Inner;
import edu.java.review13.Outer.Nested;

/*
 * 자바에서 변수를 선언할 수 있는 위치:
 *   1. 필드(멤버 변수)
 *      (1) static 아닌 필드(인스턴스 필드) - 객체를 생성한 후에 사용 가능. 인스턴스로 참조해서 사용.
 *      (2) static 필드 - 프로그램 시작 시에 메모리에 로딩된 변수. 클래스 이름으로 참조해서 사용.
 *   2. 지역 변수: 메서드 안에서 선언하는 변수.
 * 
 * 자바에서 내부 클래스(또는 인터페이스)를 선언(정의)할 수 있는 위치:
 *   1. 멤버 내부 클래스: 필드를 선언하는 위치에서 선언(정의)하는 클래스.
 *      (1) static 아닌 내부 클래스 - 외부 클래스 타입의 객체가 생성되어야 사용할 수 있는 클래스.
 *      (2) static 내부 클래스 - 외부 클래스 타입의 객체 생성 여부와 상관없이 사용할 수 있는 클래스.
 *      멤버 내부 클래스에서는 private, (package), protected, public이 모두 가능.
 *   2. 지역 (내부) 클래스(local class): 메서드 안에서 선언(정의)하는 클래스.
 *   3. 익명 클래스(anonymous class): 이름이 없는 내부 클래스.
 *   (주의) 내부 인터페이스는 public static으로만 선언 가능. 보통 public static은 생략.
 * 
 */

public class NestedMain {
    // 필드
    int a;
    static int b;

    public static void main(String[] args) {
        int x = 1; // 지역 변수. 파라미터(parameter)도 지역 변수.
        
        // static 변수 사용: 클래스 이름을 사용.
        NestedMain.b = 100;
        System.out.println(NestedMain.b);
        
        // 인스턴스 변수 사용: 인스턴스를 사용.
        NestedMain app = new NestedMain();
        app.a = 200;
        System.out.println(app.a);

        // Outer 타입의 변수 선언, 객체 생성
        Outer out = new Outer();
        System.out.println(out.x);
        
        // Outer.Inner 타입의 변수 선언, 객체 생성 - non-static
        Outer.Inner in1 = out.new Inner(); // 외부 클래스 타입의 인스턴스를 사용해서 생성자를 호출.
        // import문 사용한 경우:
        Inner in2 = out.new Inner();
        
        // Outer.Nested 타입의 변수 선언, 객체 생성 - static
        Outer.Nested nest1 = new Outer.Nested();
        // import문 사용한 경우:
        Nested nest2 = new Nested();
        
        // 지역 클래스: 메서드 안에서 선언하는 클래스.
        class LocalCls {
            
        }
        
        LocalCls local = new LocalCls();
        
    } // end method main()

} // end class NestedMain
