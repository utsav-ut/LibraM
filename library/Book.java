package library;

public class Book{
    private final int bookId;
    private final String title;
    private final String author;
    private final String publisher;
    private final int year;
    private int copies;
    private final int totalCopies;


    public Book(int id, String title, String author, String publisher, int year, int copies){
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
        this.totalCopies = copies;

    }
    public int getBookid(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }
    public int getYear(){
        return year;
    }
    public int getCopies(){
        return copies;
    }
    public int getTotalCopies(){
        return totalCopies;
    }



    public void increase(){
        this.copies += 1;
    }
    public void decrease(){
        if (copies > 0) {
            this.copies -= 1;
        }
    }
    


    public String fullDetails(){
        return "Book ID: " + bookId + " | Title : " + title + " | Author: " + author + " | Publisher: " + publisher + " | Year: " + year + " | Copies: " + copies + "/" + totalCopies;
    }
    
    // Add a toString method for easier debugging and display
    @Override
    public String toString() {
        return fullDetails();
    }

}