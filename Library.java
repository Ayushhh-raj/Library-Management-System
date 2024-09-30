package com.LibraryManagementSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Library {
	 private List<Book> books;

	    public Library() {
	        books = new ArrayList<>();
	    }

	    public void addBook(Book book) {
	        books.add(book);
	    }

	    public Book findBook(String title) {
	        for (Book book : books) {
	            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
	                return book;
	            }
	        }
	        return null;
	    }

	    public void listBooks() {
	        for (Book book : books) {
	            System.out.println(book);
	        }
	    }
	}


