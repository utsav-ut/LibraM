package library;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        User currentUser = null;
        boolean running = true;
        while (running) {
            if (currentUser == null) {
                System.out.println("\n--- Welcome to the Library System ---");
                System.out.println("1. Login");
                System.out.println("2. Create New User");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");
                int preLoginChoice = getIntInput(sc, "");
                switch (preLoginChoice) {
                    case 1:
                        System.out.print("Username: ");
                        String username = sc.nextLine();
                        System.out.print("Password: ");
                        String password = sc.nextLine();
                        currentUser = library.authenticate(username, password);
                        if (currentUser == null) {
                            System.out.println("Invalid credentials. Try again.");
                        } else {
                            System.out.println("Welcome, " + currentUser.getName() + (currentUser.getIsAdmin() ? " (Admin)" : ""));
                        }
                        break;
                    case 2:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Username: ");
                        String newUsername = sc.nextLine();
                        System.out.print("Password: ");
                        String newPassword = sc.nextLine();
                        boolean isAdmin = false;
                        System.out.print("Register as admin? (true/false): ");
                        String adminInput = sc.nextLine();
                        if (adminInput.equalsIgnoreCase("true")) isAdmin = true;
                        library.addUser(name, newUsername, newPassword, isAdmin);
                        break;
                    case 3:
                        running = false;
                        continue;
                    default:
                        System.out.println("Invalid option.");
                        continue;
                }
                if (currentUser == null) continue;
            }
            System.out.println("\n--- Library Management System ---");
            if (currentUser.getIsAdmin()) {
                System.out.println("1. Add Book");
                System.out.println("2. Add User");
            }
            System.out.println("3. List Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    if (!currentUser.getIsAdmin()) {
                        System.out.println("Admin only option.");
                        break;
                    }
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Publisher: ");
                    String publisher = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    System.out.print("Copies: ");
                    int copies = sc.nextInt();
                    sc.nextLine();
                    library.addBook(title, author, publisher, year, copies);
                    break;
                case 2:
                    if (!currentUser.getIsAdmin()) {
                        System.out.println("Admin only option.");
                        break;
                    }
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Username: ");
                    String newUsername = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    System.out.print("Is Admin (true/false): ");
                    boolean isAdmin = sc.nextBoolean();
                    sc.nextLine();
                    library.addUser(name, newUsername, password, isAdmin);
                    break;
                case 3:
                    library.listBooks();
                    break;
                case 4:
                    library.borrowBook(currentUser.getUserName(), getIntInput(sc, "Book ID: "));
                    break;
                case 5:
                    library.returnBook(currentUser.getUserName(), getIntInput(sc, "Book ID: "));
                    break;
                case 6:
                    currentUser = null;
                    System.out.println("Logged out.");
                    break;
                case 7:
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
            System.out.print(prompt);
            try {
                int val = Integer.parseInt(sc.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
