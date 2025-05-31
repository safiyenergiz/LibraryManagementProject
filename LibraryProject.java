
package libraryproject;

import java.util.Scanner;



public class LibraryProject {

    public static void main(String[] args) {
        Library library = new Library(); // Create a library object for manage the LS.
        Scanner scanner = new Scanner(System.in); // for input
        boolean exit = false; // Control the main menu

        
        // Define main menu 
        System.out.println("Welcome to the Library Management System!");

        while (!exit) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add a New Book");
            System.out.println("2. Register a New User");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display All Books");
            System.out.println("6. View Transactions");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            // Get input from user
            String input = scanner.nextLine().trim(); // .trim() : This ensures that any extra spaces before or after the entered email are removed, 
                                                     //so the email value is clean before further processing.
            if (!isNumeric(input)) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                continue; // Return to menu if input is not valid.
            }
            
            // Define choice
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    addNewBook(library, scanner);   
                    break;
                case 2:
                    registerNewUser(library, scanner); 
                    break;
                case 3:
                    borrowBook(library, scanner); 
                    break;
                case 4:
                    returnBook(library, scanner); 
                    break;
                case 5:
                    library.displayAllBooks(); 
                    break;
                case 6:
                    library.displayAllTransactions(); 
                    break;
                case 7:
                    System.out.println("Thank you for using the Library Management System. Have nice a day!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 7.");
            }
        }
    }

    // Method for add a new book to library
    private static void addNewBook(Library library, Scanner scanner) {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();

        int totalCopies = 0;
        while (totalCopies <= 0) {
            System.out.print("Enter Total Copies (positive number): ");
            String input = scanner.nextLine().trim();
            if (isNumeric(input)) {
                totalCopies = Integer.parseInt(input);
                if (totalCopies <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input! Total copies must be a number.");
            }
        }
 
        // Create and add a new book
        Book newBook = new Book(title, author, totalCopies);
        library.addBook(newBook);
        System.out.println("Book '" + title + "' by " + author + " has been added with " + totalCopies + " copies.");
    }

    // Method for register new user
    private static void registerNewUser(Library library, Scanner scanner) {
        System.out.print("Enter User Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter User Email: ");
        String email = scanner.nextLine().trim();

        // Check the email, if already registered 
        if (library.findUserByEmail(email) != null) { 
            System.out.println("A user with this email is already registered.");
            return;
        }

        // Register new user
        User newUser = new User(name, email);
        library.registerUser(newUser);
        System.out.println("User '" + name + "' has been registered successfully.");
    }
 
    // Method for borrow book
    private static void borrowBook(Library library, Scanner scanner) {
        System.out.print("Enter User Email: ");
        String email = scanner.nextLine().trim(); // Get user email
        User user = library.findUserByEmail(email);

        // Check the user
        if (user == null) { 
            System.out.println("User not found! Please register the user first.");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine().trim();
        Book book = library.findBookByTitleAndAuthor(title, author);

        // Check the book
        if (book == null) {
            System.out.println("Book not found in the library.");
            return;
        }

        if (user.borrowBook(book)) {
            library.recordTransaction(new Transaction(user, book, "Borrow"));
            System.out.println("Book '" + title + "' has been borrowed by " + user.getName() + ".");
        } else {
            System.out.println("Cannot borrow the book. No available copies.");
        }
    }

    // Method for return book
    private static void returnBook(Library library, Scanner scanner) {
        System.out.print("Enter User Email: ");
        String email = scanner.nextLine().trim(); // Get user email
        User user = library.findUserByEmail(email);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine().trim();
        Book book = library.findBookByTitleAndAuthor(title, author);

        if (book == null) {
            System.out.println("Book not found in the library.");
            return;
        }

        if (user.returnBook(book)) {
            library.recordTransaction(new Transaction(user, book, "Return"));
            System.out.println("Book '" + title + "' has been returned by " + user.getName() + ".");
        } else {
            System.out.println("This user did not borrow the book.");
        }
    }

    /* To check if a string is numeric; If a user letter, symbol or invalid input is made in a corrupted form, 
    isNumeric is used to prevent the program from giving an error and to display a warning message to the user.
    */
    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}


 

