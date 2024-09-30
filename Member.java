package com.LibraryManagementSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Member {
	private String name;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}


