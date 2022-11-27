package edu.java.review09;

public class BuilderMain {

    public static void main(String[] args) {
        // 생성자를 직접 사용 -> Book 타입 변수 선언, 객체 생성 
        Book book1 = new Book("test", "test", "test");
        System.out.println(book1.toString());
        
        // Builder(Factory) 패턴을 사용 -> 객체 생성
        Book book2 = Book.builder()
                .description("test")
                .title("test")
                .author("test")
                .build();
        System.out.println(book2.toString());

        Book book3 = new Book("하얼빈", "김훈", "역사소설");
        System.out.println(book3.toString());
        
        Book book4 = Book.builder().title("하얼빈").author("김훈").description("역사소설").build();
        System.out.println(book4.toString());
        
    }

}
