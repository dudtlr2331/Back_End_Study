package com.exam;

import com.data.Book;

public class BookEx01 {
    public static void main(String[] args) {
        Book book = new Book();

        book.setTitle("book1");
        book.setAuthor("Author1");
        book.setPrice("price1");

        Book book2 = new Book("book2", "author2", "price2");

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getPrice());

        System.out.println(book2.getTitle());
        System.out.println(book2.getAuthor());
        System.out.println(book2.getPrice());
    }
}
