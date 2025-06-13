# LibraM📚 (Java – CLI)

A simple **command-line based Library Management System** written in **Java**, designed for educational purposes.  
It supports basic functionality for user management, book inventory, and borrowing/returning books.

---

## ✅ Features

- 👤 **User Roles**
  - **Admin**: Can add books and register new users  
  - **Regular User**: Can view, borrow, and return books

- 🔐 **User Registration and Login**
  - Prevents duplicate usernames  
  - Role-based access control

- 📘 **Book Management**
  - Add, list, borrow, and return books  
  - Prevents borrowing the same book more than once

- 📄 **Console-based UI**
  - Simple and interactive command-line interface

---

## 🚀 How to Run

1. **Compile the code**  
   Open a terminal in the root project directory and run:

   ```bash
   javac library/*.java
   ```

2. **Run the program**

   ```bash
   java library.Main
   ```

---

## 📁 File Structure

```
library/
├── Main.java             # Entry point of the application
├── User.java             # User class
├── Admin.java            # Admin class (inherits User)
├── Book.java             # Book class
├── Library.java          # Handles logic and operations
└── Utils.java            # Helper methods (e.g., input, validation)
```

---

## 📌 Usage

- On startup, choose to:
  - **Login**
  - **Register** (as a regular user or admin)

- After logging in:
  - **Admins** can:
    - Add new books
    - Register new users
  - **All users** can:
    - View the book list
    - Borrow a book
    - Return a borrowed book

---

## 🛠️ Requirements

- Java 8 or higher
- Terminal/Command Prompt

---

## 🎯 Sample Screens

```text
Welcome to Library Management System
1. Login
2. Register
Choose option: 1

Enter username: admin
Enter password: *****

Welcome, admin!
1. Add Book
2. Add User
3. View Books
4. Logout
```

---

## 📌 Notes

- A user cannot borrow the same book twice without returning it.
- Admin is a special user role with extra permissions.
- The system runs entirely on the command line — great for learning core Java.

---

## 🧠 Future Improvements

You can extend this project by adding:

- File-based or database persistence
- Fine-grained permissions
- Overdue tracking and due dates
- Notifications or logs
- A GUI (JavaFX, Swing)
- REST API backend for a web-based version
- Unit testing with JUnit

---

## ⚖️ License

This project is intended **for educational purposes only**.  
Feel free to use and modify it for learning, assignments, or practice.

---

## 🤝 Contributing

Pull requests are welcome! If you'd like to contribute a new feature or fix a bug, feel free to fork the repo and create a pull request.

---

## 📬 Contact

If you have suggestions, feature requests, or feedback, feel free to open an issue or reach out.

---

## ⭐ Star this Project

If you found this helpful or used it in your learning journey, consider giving it a ⭐ on GitHub to show your support!

