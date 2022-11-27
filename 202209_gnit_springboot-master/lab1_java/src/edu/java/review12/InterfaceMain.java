package edu.java.review12;

public class InterfaceMain {

    public static void main(String[] args) {
        System.out.println(DatabaseModule.VERSION); // static
//        DatabaseModule.VERSION = 2; //-> 에러 발생: final이기 때문에.
        
        OracleDatabaseModule db = new OracleDatabaseModule();
        int result = db.insert("abc", "가나다라");
        System.out.println("result=" + result);
    }

}
