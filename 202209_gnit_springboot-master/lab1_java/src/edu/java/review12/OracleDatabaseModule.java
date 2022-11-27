package edu.java.review12;

// 인터페이스를 구현하는 클래스 선언(정의)
public class OracleDatabaseModule implements DatabaseModule {

    @Override
    public int insert(String col1, String col2) {
        System.out.println("col1=" + col1 + ", col2=" + col2);
        return 1;
    }

}
