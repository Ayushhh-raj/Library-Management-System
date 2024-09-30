package com.LibraryManagementSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LibraryManagementSystem {
	    private Library library;
	    private List<Member> members;

	    public LibraryManagementSystem() {
	        library = new Library();
	        members = new ArrayList<>();
	    }

	    public void addMember(String name) {
	        members.add(new Member(name));
	    }

	    public void borrowBook(String memberName, String bookTitle) {
	        Member member = findMember(memberName);
	        Book book = library.findBook(bookTitle);
	        if (member != null && book != null) {
	            member.borrowBook(book);
	            System.out.println(memberName + " borrowed " + bookTitle);
	        } else {
	            System.out.println("Book not available or member not found.");
	        }
	    }

	    public void returnBook(String memberName, String bookTitle) {
	        Member member = findMember(memberName);
	        Book book = library.findBook(bookTitle);
	        if (member != null && !book.isAvailable()) {
	            member.returnBook(book);
	            System.out.println(memberName + " returned " + bookTitle);
	        } else {
	            System.out.println("Book was not borrowed by this member.");
	        }
	    }

	    public void listAvailableBooks() {
	        library.listBooks();
	    }

	    private Member findMember(String name) {
	        for (Member member : members) {
	            if (member.getName().equalsIgnoreCase(name)) {
	                return member;
	            }
	        }
	        return null;
	    }

	    public static void main(String[] args) {
	        LibraryManagementSystem system = new LibraryManagementSystem();
	        system.library.addBook(new Book("1984", "George Orwell"));
	        system.library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
	        
	        system.addMember("Alice");
	        system.addMember("Bob");

	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("\nLibrary Management System");
	            System.out.println("1. List Available Books");
	            System.out.println("2. Borrow Book");
	            System.out.println("3. Return Book");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume newline

	            switch (choice) {
	                case 1:
	                    system.listAvailableBooks();
	                    break;
	                case 2:
	                    System.out.print("Enter member name: ");
	                    String memberName = scanner.nextLine();
	                    System.out.print("Enter book title: ");
	                    String bookTitle = scanner.nextLine();
	                    system.borrowBook(memberName, bookTitle);
	                    break;
	                case 3:
	                    System.out.print("Enter member name: ");
	                    memberName = scanner.nextLine();
	                    System.out.print("Enter book title: ");
	                    bookTitle = scanner.nextLine();
	                    system.returnBook(memberName, bookTitle);
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid option, please try again.");
	            }
	        }
	    }
	}


