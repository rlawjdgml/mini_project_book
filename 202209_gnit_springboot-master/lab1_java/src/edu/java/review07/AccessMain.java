package edu.java.review07; // 패키지 선언문

// import 문 - 다른 패키지에서 선언된 클래스(인터페이스, enum) 이름을 간단히 사용하려고 할 때.
// 같은 패키지의 클래스들은 import 문 없이 사용 가능.
// JDK의 java.lang 패키지의 클래스들은 import 문 없이 사용할 수 있음.
import edu.java.review06.Employee;

/*
 * 클래스 멤버(필드, 생성자, 메서드)의 접근 수식어(access modifier)
 * (1) private: 선언된 클래스 안에서만 직접 접근(사용)이 가능.
 * (2) (package): 수식어가 없는 경우. 같은 패키지의 클래스들에서 접근(사용)이 가능.
 * (3) protected: 같은 패키지에 있거나 또는 상속하는 클래스들에서 접근(사용)이 가능.
 * (4) public: 어디서든지 접근(사용) 가능.
 * 사용 범위(visibility): private < (package) < protected < public
 * 
 * 클래스의 접근 수식어:
 * (1) public: 어디서나 사용(변수 선언, 객체 생성) 가능.
 * (2) (package): 같은 패키지의 클래스들에서만 사용 가능.
 * public 클래스의 이름은 클래스를 작성하는 java 파일의 이름과 동일해야 함!
 * 1개의 java 파일에는 1개의 public 클래스만 선언할 수 있음.
 * 
 */

class A {}
class B {}

public class AccessMain {

    public static void main(String[] args) {
        // edu.java.review06.Employee 타입 변수 선언, 객체 생성 - import 사용.
        // edu.java.review06.Employee e = new edu.java.review06.Employee();
        Employee emp = new Employee(1, "홍길동", 100);

        // System.out.println(emp.empName);
        //-> 다른 패키지에서 package 범위의 멤버는 다른 패키지의 클래스에서 보이지 않음.
        
        emp.printEmpInfo();
        //-> public으로 선언된 멤버(메서드)는 다른 패키지의 클래스에서 접근(사용) 가능.
        
        // Test 타입 변수 선언, 객체 생성.
        Test test = new Test(16, "abc");
        // System.out.println(test.age); // private 멤버는 다른 클래스에서 접근 불가.
        // test.age = 100; // 값 변경 불가.
        
        // getter 메서드 호출
        System.out.println(test.getAge() + ", " + test.getName());
        
        // setter 메서드 호출
        test.setAge(17);
        System.out.println(test.getAge());
        
    }

}
