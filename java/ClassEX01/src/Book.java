public class Book {
    String title;
    String author;
    String isbn;
    boolean isBorrowed;

    public Book(String title, String author, String isbn, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = true;
    }

    public void displayBookInfo(){
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("대출 여부: " + isBorrowed);
    }

    public void borrowBook(){
        if (isBorrowed) {
            System.out.println("이미 대출된 도서입니다.");
        } else {
            isBorrowed = true;
            System.out.println("도서가 대출되었습니다.");
        }
    }

    public void returnBook(){
        if (!isBorrowed) {
            System.out.println("대출되지 않은 도서입니다.");
        } else {
            isBorrowed = false;
            System.out.println("도서가 반납되었습니다.");
        }
    }
}