package libraryproject;

public class User {

    // User information
    private String name;
    private String email;
    private Book[] borrowedBooks;
    private int borrowedBookCount;

    // Constructor to initialize a User with a name, email, and an empty list of borrowed books
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.borrowedBooks = new Book[3]; // Maximum 3 books can be borrowed at a time
        this.borrowedBookCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to borrow a book
    public boolean borrowBook(Book book) {
        if (borrowedBookCount < 3 && book.getAvailableCopies() > 0) {
            borrowedBooks[borrowedBookCount++] = book;
            book.borrowBook();
            return true;
        } else {
            System.out.println("Cannot borrow more than 3 books or no copies available.");
            return false;
        }
    }

    // Method to return a borrowed book
    public boolean returnBook(Book book) {
        for (int i = 0; i < borrowedBookCount; i++) {
            if (borrowedBooks[i] == book) {
                borrowedBooks[i] = null; // Remove the book
                book.returnBook();
                shiftBorrowedBooks(i); // Reorganize the array
                borrowedBookCount--;
                return true;
            }
        }
        System.out.println("Book not found in borrowed list.");
        return false;
    }

    // Shift books to fill the gap when a book is returned
    private void shiftBorrowedBooks(int index) {
        for (int i = index; i < borrowedBookCount - 1; i++) {
            borrowedBooks[i] = borrowedBooks[i + 1];
        }
        borrowedBooks[borrowedBookCount - 1] = null; // Clear the last slot
    }
}
