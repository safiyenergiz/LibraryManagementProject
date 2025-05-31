package libraryproject;

import static libraryproject.Book.decreaseCopies;
import static libraryproject.Book.increaseCopies;

public class Book {

    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    // Constructor
    public Book(String title, String author, int totalCopies) {
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter for available copies
    public int getAvailableCopies() {
        return availableCopies;
    }

    // Method to borrow a book
    public boolean borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            System.out.println("Successfully borrowed: " + title);
            return true;
        } else {
            System.out.println("No available copies left to borrow!");
            return false;
        }
    }

    // Method to return a book
    public boolean returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
            System.out.println("Successfully returned: " + title);
            return true;
        } else {
            System.out.println("All copies are already available. No need to return more!");
            return false;
        }
    }

    // Method to display book details
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Total Copies: " + totalCopies);
        System.out.println("Available Copies: " + availableCopies);
    }

    public static int decreaseCopies() {
        int decreaseCopies = 0;
       return  decreaseCopies;

    }

    public static int increaseCopies() {
        int increaseCopies = 0;
       return increaseCopies;
    }
}