package edu.java.review06;

public class Employee {
    // 필드(field, 속성 property)
    int empNo; // 사번
    String empName; // 이름
    double salary; // 급여

    // 생성자: 객체를 만드는(생성하는) 함수. 생성자의 이름은 클래스의 이름과 동일.
    // [수식어] 클래스이름([파라미터 선언]) { ... }
    
    // 기본 생성자(default constructor)
    // argument를 갖지 않으면서, 모든 필드들의 값을 그 타입의 기본값으로 초기화하는 생성자.
    // 기본값: 정수 타입=0, 실수 타입=0.0, boolean 타입=false, 참조(클래스) 타입=null(없음).
    // 클래스에서 생성자가 1개도 선언(정의)되어 있지 않으면, 자바 컴파일러가 기본 생성자를 자동으로 만들어 줌.
    // (주의) 다른 생성자를 1개 이상 정의하면, 자바 컴파일러는 기본 생성자를 만들어 주지 않음!
    public Employee() {}
    
    // argument를 갖는 생성자
    // parameter(파라미터): argument를 저장하기 위해서 함수 선언 부분에서 선언하는 변수.
    public Employee(int empNo, String empName, double salary) {
        // this: 메모리에 생성된 객체(인스턴스). 클래스의 멤버(변수, 메서드)를 참조할 때 사용.
        this.empNo = empNo;
        this.empName = empName;
        this.salary = salary;
    }
    
    public Employee(int empNo) {
//        this.empNo = empNo;
//        this.empName = null;
//        this.salary = 0;
        this(empNo, null, 0);
        // this: 클래스에서 정의된 다른 생성자를 호출.
    }
    
    // 생성자 오버로딩(constructor overloading):
    // (같은 이름의) 생성자를 여러개 정의하는 것.
    // 파라미터가 다를 때(파라미터의 개수나 파라미터의 타입이 다를 때)에 생성자를 여러개 정의할 수 있음.
    
    // 메서드(method): 클래스 안에서 정의하는 함수(기능). 객체가 가지는 기능.
    // 메서드 선언(정의) 방법: [수식어] 리턴타입 메서드이름(파라미터 선언) { ... }
    // 리턴 타입: 메서드가 기능 수행 결과로 메서드를 호출한 곳에 반환하는 값의 데이터 타입.
    // argument: 메서드(또는 생성자)를 호출할 때 전달하는 값.
    // parameter: 메서드(또는 생성자)를 정의하는 곳에서, argument를 저장하기 위해서 선언하는 변수.
    
    /**
     * 급여를 인상하고, 그 결과를 리턴.
     * 
     * @param ratio 인상률(10% -> 0.1).
     * @return 인상된 급여.
     */
    public double raiseSalary(double ratio) {
        // 현재 급여를 인상률만큼 증가(감소)시키고, 변경된 급여를 필드에 저장.
        this.salary = this.salary * (1 + ratio);
        
        // 변경된 급여를 리턴(반환)
        return this.salary;
    }
    
    /**
     * 직원의 정보(사번, 이름, 급여)를 콘솔창에 출력.
     */
    // void: 메서드가 리턴하는 값이 없을 때 리턴타입 자리에 사용하는 키워드.
    // (주의): 생성자에서는 void를 쓰면 안 됨!
    public void printEmpInfo() {
        // String.format(): 문자열 템플릿
        //   %d - 정수(digit), %f - 실수(floating number), %s - 문자열(string)
        String info = String.format("사번=%d, 이름=%s, 급여=%.2f", empNo, empName, salary);
        System.out.println(info);
    }
}
