public class Book {
    private String title;
    private String author;
    private double rating;
    private double price;
    
    // Constructor
    public Book(String title, String author, double rating, double price) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.price = price;
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getRating() { return rating; }
    public double getPrice() { return price; }
    
    @Override
    public String toString() {
        return title + " by " + author + " (Rating: " + rating + ", Price: $" + price + ")";
    }
}
