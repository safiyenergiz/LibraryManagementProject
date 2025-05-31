
package libraryproject;

class Library {

    private Book[][] shelves;
    private User[] users;
    private Transaction[] transactions;
    private static final int SHELF_CAPACITY = 4;
    private int userCount = 0;
    private int transactionCount = 0;
    private int shelfCount = 10;

    // Constructor to initialize library attributes
    public Library() {
        shelves = new Book[shelfCount][SHELF_CAPACITY];
        users = new User[10];
        transactions = new Transaction[10];
    }

    // Method to add a new book to the library
    public void addBook(Book book) {
        for (int i = 0; i < shelfCount; i++) {
            for (int j = 0; j < SHELF_CAPACITY; j++) {
                if (shelves[i][j] == null) {
                    shelves[i][j] = book;
                    System.out.println("Book added to the shelf.");
                    return;
                }
            }
        }

        // If all shelves are full, create a new shelf and add the book
        resizeShelves();
        shelves[shelfCount - 1][0] = book;
        System.out.println("Added a new shelf for the book.");
    }

    private void resizeShelves() {
        Book[][] newShelves = new Book[shelfCount + 1][SHELF_CAPACITY];
        for (int i = 0; i < shelfCount; i++) {
            newShelves[i] = shelves[i];
        }
        shelves = newShelves;
        shelfCount++;
    }

    // Method to register a new user
    public void registerUser(User user) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getEmail().equals(user.getEmail())) {
                System.out.println("A user with this email already exists.");
                return;
            }
        }
        if (userCount == users.length) {
            resizeUsers();
        }
        users[userCount++] = user;
        System.out.println("User registered successfully.");
    }

    private void resizeUsers() {
        User[] newUsers = new User[users.length + 10];
        System.arraycopy(users, 0, newUsers, 0, users.length);
        users = newUsers;
    }

    // Method to find a user by email
    public User findUserByEmail(String email) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }

    // Method to find a book by title and author
    public Book findBookByTitleAndAuthor(String title, String author) {
        for (int i = 0; i < shelfCount; i++) {
            for (int j = 0; j < SHELF_CAPACITY; j++) {
                Book book = shelves[i][j];
                if (book != null && book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                    return book;
                }
            }
        }
        return null;
    }

    // Method to record a transaction
    public void recordTransaction(Transaction transaction) {
        if (transactionCount == transactions.length) {
            resizeTransactions();
        }
        transactions[transactionCount++] = transaction;
    }

    private void resizeTransactions() {
        Transaction[] newTransactions = new Transaction[transactions.length + 10];
        System.arraycopy(transactions, 0, newTransactions, 0, transactions.length);
        transactions = newTransactions;
    }

    // Method to display all books
    public void displayAllBooks() {
        System.out.println("\nBooks in the library:");
        for (int i = 0; i < shelfCount; i++) {
            for (int j = 0; j < SHELF_CAPACITY; j++) {
                Book book = shelves[i][j];
                if (book != null) {
                    System.out.println(book.getTitle() + " by " + book.getAuthor() + ", Available: " + book.getAvailableCopies());
                }
            }
        }
    }

    // Method to display all transactions
    public void displayAllTransactions() {
        System.out.println("\nTransaction history:");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i]);
        }
    }

    // Method to display all users
    public void displayAllUsers() {
        System.out.println("\nRegistered Users:");
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i]);
        }
    }
}