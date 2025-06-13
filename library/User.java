package library;
import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer> borrowedBooks=new ArrayList<>();


    public User(int id, String name, String username, String password, boolean isAdmin){
        this.userId = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;


    }
    public int getUserId(){
        return userId;
    }
    public String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public boolean getIsAdmin(){
        return isAdmin;
    }
    public String getName(){
        return name;
    }
    public void borrowBook(int bookId) {
        if (!borrowedBooks.contains(bookId)) {
            borrowedBooks.add(bookId);
        }
    }
    public void returnBook(int bookId) {
        borrowedBooks.remove(Integer.valueOf(bookId));
    }
    public boolean hasBorrowed(int bookId) {
        return borrowedBooks.contains(bookId);
    }
    
    // Optionally, add a method to change password securely in the future
    // Optionally, add a method to print user details (for admin)
}