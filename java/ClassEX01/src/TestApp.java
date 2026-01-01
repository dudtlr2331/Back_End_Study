public class TestApp {
    public static void main(String[] args) {
        Book book = new Book("1", "1", "2", false);

        book.displayBookInfo();
        book.borrowBook();
        book.returnBook();
    }
}
