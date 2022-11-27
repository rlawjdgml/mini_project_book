package edu.java.review12;

/*
 * Java 버전에 따른 인터페이스 변화:
 * 1. Java 7 버전까지:
 *    (1) public static final 필드(멤버 변수) - 상수
 *    (2) public abstract 메서드 - 리턴 타입, 메서드 이름, 파라미터 선언.
 * 2. Java 8 버전:
 *    (1) public static final 필드(멤버 변수) - 상수
 *    (2) public abstract 메서드 - 리턴 타입, 메서드 이름, 파라미터 선언. body 없는 메서드.
 *    (3) (public) default 메서드 - 본체(body)가 있는 메서드. 객체 생성 후에 사용 가능한 메서드.
 *    (4) (public) static 메서드 - 본체(body)가 있는 메서드. 객체를 생성하지 않아도 사용 가능한 메서드.
 * 3. Java 9 버전 이후:
 *    Java 8 버전까지의 멤버들 + 
 *    private static 메서드 - 본체(body)가 있는 메서드. public static 메서드 안에서만 사용 가능.
 *    
 * 자바에서 클래스는 다중 상속을 지원하지 않음.
 * class SubClass extends Super1, Super2 {} -> 에러.
 * 
 * 인터페이스는 다중 구현을 지원함.
 * class SubClass implements Interface1, Interface2, ... {} -> 가능.
 * 
 */

public interface DatabaseModule {
    int VERSION = 1;
    //-> 인터페이스의 필드는 public static final만 가능하기 때문에, 수식어들을 생략해도 됨.
    
    int insert(String col1, String col2);
    //-> 인터페이스의 메서드는 public abstract여야 하므로, 수식어들을 생략해도 됨.
}
