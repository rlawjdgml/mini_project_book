package edu.java.review09;

public class Book {
    // 필드
    private String title; // 제목
    private String author; // 저자
    private String description; // 설명
    
    // 생성자
    public Book(String author, String description, String title) {
        this.title = title;
        this.author = author;
        this.description = description;
    }
    
    // 메서드
    @Override
    public String toString() {
        return String.format("Book(title=%s, author=%s, description=%s)", 
                title, author, description);
    }

    // Builder(Factory) 디자인 패턴
    // public static 내부 클래스
    public static class BookBuilder {
        // 외부 클래스의 필드들 중에서 꼭 필요한 필드들을 동일하게 선언.
        private String title;
        private String author;
        private String description;
        
        // private 생성자
        private BookBuilder() {}
        
        // 필드들을 초기화하고 자기자신 타입(BookBuilder)을 리턴하는 메서드
        public BookBuilder title(String title) {
            this.title = title;
            return this; // 생성된 자기자신 타입의 인스턴스를 리턴.
        }
        
        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }
        
        public BookBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        // 외부 클래스 타입의 객체를 리턴하는 메서드 
        public Book build() {
            return new Book(author, description, title);
        }
    } // end class BookBuilder
    
    // public static 내부클래스 타입을 리턴하는 메서드
    public static BookBuilder builder() {
        // 외부 클래스에서는 static 내부 클래스의 생성자를 호출할 수 있음!
        return new BookBuilder(); // new Book.BookBuilder();
    }
    
} // end class Book
