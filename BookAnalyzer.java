import java.util.List;
import java.util.Set;
import java.util.HashSet;

// Static utility class - all methods are static
public class BookAnalyzer {
    
    // Task 1: Count books by author
    public static int countBooksByAuthor(String authorName, List<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        return count;
    }
    
    // Task 2: Show all unique authors
    public static void showAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        
        System.out.println("\n📚 All Authors:");
        int i = 1;
        for (String author : authors) {
            System.out.println(i + ". " + author);
            i++;
        }
        System.out.println("Total: " + authors.size() + " authors");
    }
    
    // Task 3: Show books by specific author
    public static void showBooksByAuthor(String authorName, List<Book> books) {
        System.out.println("\n📖 Books by " + authorName + ":");
        int count = 0;
        
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
                System.out.println(count + ". " + book.getTitle());
            }
        }
        
        if (count == 0) {
            System.out.println("❌ No books found for " + authorName);
        } else {
            System.out.println("Found " + count + " books");
        }
    }
    
    // Task 4: Show books by rating
    public static void showBooksByRating(double targetRating, List<Book> books) {
        System.out.println("\n⭐ Books with rating " + targetRating + ":");
        int count = 0;
        
        for (Book book : books) {
            if (Math.abs(book.getRating() - targetRating) < 0.1) {
                count++;
                System.out.println(count + ". " + book.getTitle() + " by " + book.getAuthor());
            }
        }
        
        if (count == 0) {
            System.out.println(" No books found with rating " + targetRating);
        } else {
            System.out.println("Found " + count + " books");
        }
    }
    
    // Task 5: Show books and prices by author
    public static void showPricesByAuthor(String authorName, List<Book> books) {
        System.out.println("\n Books and Prices by " + authorName + ":");
        int count = 0;
        double totalPrice = 0;
        
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
                System.out.println(count + ". " + book.getTitle() + " - $" + book.getPrice());
                totalPrice += book.getPrice();
            }
        }
        
        if (count == 0) {
            System.out.println(" No books found for " + authorName);
        } else {
            System.out.println("Total: " + count + " books, $" + totalPrice);
        }
    }
}
