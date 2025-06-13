package library;
import java.util.Scanner;

public class LibraryActionsDemo {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        // Add some sample data
        library.addBook("Java Programming", "John Doe", "TechBooks", 2020, 3);
        library.addBook("Python Basics", "Jane Smith", "CodePress", 2021, 2);
        library.addUser("Alice", "alice", "pass1", false);
        library.addUser("Bob", "bob", "pass2", false);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Library Actions Demo ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. List Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = getIntInput(sc, "");
            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Publisher: ");
                    String publisher = sc.nextLine();
                    int year = getIntInput(sc, "Year: ");
                    int copies = getIntInput(sc, "Copies: ");
                    library.addBook(title, author, publisher, year, copies);
                    break;
                case 2:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Username: ");
                    String username = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    System.out.print("Is Admin (true/false): ");
                    boolean isAdmin = Boolean.parseBoolean(sc.nextLine());
                    library.addUser(name, username, password, isAdmin);
                    break;
                case 3:
                    library.listBooks();
                    break;
                case 4:
                    System.out.print("Username: ");
                    String uname = sc.nextLine();
                    int bid = getIntInput(sc, "Book ID: ");
                    library.borrowBook(uname, bid);
                    break;
                case 5:
                    System.out.print("Username: ");
                    String uname2 = sc.nextLine();
                    int bid2 = getIntInput(sc, "Book ID: ");
                    library.returnBook(uname2, bid2);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
        System.out.println("Goodbye!");
    }

    // Helper to safely get integer input
    private static int getIntInput(Scanner sc, String prompt) {
        while (true) {
            if (!prompt.isEmpty()) System.out.print(prompt);
            try {
                int val = Integer.parseInt(sc.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
