package library;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private int nextBookId = 1;
    private int nextUserId = 1;

    public void addBook(String title, String author, String publisher, int year, int copies) {
        Book book = new Book(nextBookId++, title, author, publisher, year, copies);
        books.add(book);
        System.out.println("Book added: " + book.fullDetails());
    }

    // Prevent duplicate usernames
    public boolean usernameExists(String username) {
        for (User u : users) {
            if (u.getUserName().equals(username)) return true;
        }
        return false;
    }

    // Authenticate user
    public User authenticate(String username, String password) {
        for (User u : users) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    // Add user with duplicate check
    public void addUser(String name, String username, String password, boolean isAdmin) {
        if (usernameExists(username)) {
            System.out.println("Username already exists. Please choose another.");
            return;
        }
        User user = new User(nextUserId++, name, username, password, isAdmin);
        users.add(user);
        System.out.println("User added: " + username);
    }

    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getBookid() == id) return b;
        }
        return null;
    }

    public User findUserByUsername(String username) {
        for (User u : users) {
            if (u.getUserName().equals(username)) return u;
        }
        return null;
    }

    public void listBooks() {
        for (Book b : books) {
            System.out.println(b.fullDetails());
        }
    }

    // Improved borrowBook with checks
    public void borrowBook(String username, int bookId) {
        User user = findUserByUsername(username);
        Book book = findBookById(bookId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.getCopies() <= 0) {
            System.out.println("No copies available.");
            return;
        }
        if (user.hasBorrowed(bookId)) {
            System.out.println("You have already borrowed this book.");
            return;
        }
        book.decrease();
        user.borrowBook(bookId);
        System.out.println("Book borrowed successfully.");
    }

    // Improved returnBook with checks
    public void returnBook(String username, int bookId) {
        User user = findUserByUsername(username);
        Book book = findBookById(bookId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!user.hasBorrowed(bookId)) {
            System.out.println("You have not borrowed this book.");
            return;
        }
        book.increase();
        user.returnBook(bookId);
        System.out.println("Book returned successfully.");
    }
}
