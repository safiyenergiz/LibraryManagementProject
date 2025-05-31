
package libraryproject;


import java.util.Date;

public class Transaction {
    
    private User user;
    private Book book;
    private String transactionType; // "Borrow" or "Return"
    private Date transactionDate;

    public Transaction(User user, Book book, String transactionType) {
        this.user = user;
        this.book = book;
        this.transactionType = transactionType;
        this.transactionDate = new Date();

        // Update book copies based on transaction type
        if (transactionType.equals("Borrow")) {
            if (book.getAvailableCopies() > 0) {
                book.decreaseCopies();
            } else {
                System.out.println("The book is not available!");
            }
        } else if (transactionType.equals("Return")) {
            book.increaseCopies();
        }
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getTransactionDate() {
        return transactionDate.toString();
    }

   
    @Override
    public String toString() {
        return transactionType + " | " + book.getTitle() + " by " + user.getName() + " on " + transactionDate;
    }
}

