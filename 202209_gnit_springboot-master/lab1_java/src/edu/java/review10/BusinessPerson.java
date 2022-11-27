package edu.java.review10;

// class SubClass extends SuperClass
public class BusinessPerson extends Person {
    // field
    private String company;
    
    // constructor
    // 상속 관계에서의 생성자 실행 순서:
    // 하위 클래스의 생성자가 호출되면, 상위 클래스의 생성자가 먼저 호출/실행됨.
    // 하위 클래스에서 상위 클래스의 생성자를 명시적으로 호출할 때는 super 키워드를 사용함.
    // 하위 클래스에서 상위 클래스의 생성자를 명시적으로 호출하지 않을 때에는,
    // 상위 클래스의 "기본 생성자(argument를 갖지 않는 생성자)"가 암묵적으로 호출됨.
    // 상위 클래스에 기본 생성자가 없으면, 하위 클래스에서는 반드시 명시적으로
    // 상위 클래스의 다른 생성자(argument를 갖는 생성자)를 호출해야만 함.
    // 상위 클래스 생성자(super)를 호출하는 코드는 다른 어떤 코드들 보다 먼저 실행되어야 함!
    
    public BusinessPerson() {
        // super(); // 상위 클래스의 생성자를 명시적으로 호출.
        super("무명"); // 기본 생성자가 아닌 다른 생성자들은 반드시 명시적으로 호출해야 함.
        System.out.println("BusinessPerson() 생성자 호출");
        //super(); -> 이 자리에서 super를 호출할 수는 없음!
    }
    
    public BusinessPerson(String name, String company) {
        super(name);
        this.company = company;
        System.out.println("BusinessPerson(name, company) 생성자 호출");
    }

    // getter/setter
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
    @Override
    public String toString() {
        return String.format("BusinessPerson(name=%s, company=%s)", 
                getName(), company);
    }
    
}
