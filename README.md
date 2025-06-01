📚 Library Management System

A Java-based Library Management System designed to manage books, users, and borrowing transactions. This console application allows users to borrow and return books while administrators can add books, users, and view all transactions.

🚀 Features
	•	📖 Add and list books
	•	👤 Register and list users
	•	🔄 Borrow and return books
	•	📋 Track all transactions
	•	🔍 Simple console-based user interface

🧠 How It Works

The system is structured with five main classes:
	•	Book.java – Represents a book with title, author, ID, and availability.
	•	User.java – Holds user details such as name and ID.
	•	Transaction.java – Records book borrow/return events with date/time.
	•	Library.java – Manages collections of books, users, and transactions.
	•	LibraryProject.java – Main program that runs the console-based interface.

🛠 Technologies Used
	•	Java (JDK 8+)
	•	NetBeans IDE (or any Java IDE)
	•	No external libraries or database required

📂 Project Structure

LibraryManagement/
├── Book.java
├── User.java
├── Transaction.java
├── Library.java
└── LibraryProject.java

▶️ How to Run
	1.	Open the project in NetBeans or your preferred Java IDE.
	2.	Compile all .java files.
	3.	Run LibraryProject.java (this contains the main() method).

🧪 Sample Operations
	•	Add books and users through the menu.
	•	Borrow a book using user and book IDs.
	•	Return books.
	•	View all users, books, and transaction logs from the console.

💡 Future Improvements
	•	GUI interface (Swing or JavaFX)
	•	Persistent storage using files or a database
	•	Due date and overdue fine calculation
	•	Role-based login (Admin vs. User)



