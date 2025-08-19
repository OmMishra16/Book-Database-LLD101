import java.util.List;
import java.util.Scanner;

// Main class - CSV only version
public class Driver {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🚀 Simple Book Analysis System (CSV)");
        System.out.println("====================================");
        
        // Step 1: Create CSV reader
        FileReader reader = new CSVReader();
        
        // Step 2: Create manager with CSV reader
        FileManager manager = new FileManager(reader);
        
        // Step 3: Load data
        List<Book> books = loadData(scanner, manager);
        
        if (books.isEmpty()) {
            System.out.println("❌ No data loaded. Goodbye!");
            return;
        }
        
        // Step 4: Main menu
        runMainMenu(scanner, books);
        
        scanner.close();
    }
    
    private static List<Book> loadData(Scanner scanner, FileManager manager) {
        System.out.print("Enter CSV filename: ");
        String filename = scanner.nextLine();
        
        System.out.println("\n📂 Loading CSV file...");
        return manager.loadBooks(filename);
    }
    
    private static void runMainMenu(Scanner scanner, List<Book> books) {
        while (true) {
            showMenu(books.size());
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    handleCountBooks(scanner, books);
                    break;
                case 2:
                    BookAnalyzer.showAllAuthors(books);
                    break;
                case 3:
                    handleShowBooks(scanner, books);
                    break;
                case 4:
                    handleShowByRating(scanner, books);
                    break;
                case 5:
                    handleShowPrices(scanner, books);
                    break;
                case 6:
                    showSampleBooks(books);
                    break;
                case 7:
                    System.out.println("👋 Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void showMenu(int bookCount) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📚 MENU (" + bookCount + " books loaded)");
        System.out.println("=".repeat(40));
        System.out.println("1. Count books by author");
        System.out.println("2. Show all authors");
        System.out.println("3. Show books by author");
        System.out.println("4. Show books by rating");
        System.out.println("5. Show prices by author");
        System.out.println("6. Show sample books");
        System.out.println("7. Exit");
        System.out.print("Choice: ");
    }
    
    // Task 1
    private static void handleCountBooks(Scanner scanner, List<Book> books) {
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        int count = BookAnalyzer.countBooksByAuthor(author, books);
        System.out.println("📊 " + author + " has " + count + " books");
    }
    
    // Task 3
    private static void handleShowBooks(Scanner scanner, List<Book> books) {
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        BookAnalyzer.showBooksByAuthor(author, books);
    }
    
    // Task 4
    private static void handleShowByRating(Scanner scanner, List<Book> books) {
        System.out.print("Enter rating (e.g., 4.7): ");
        double rating = scanner.nextDouble();
        BookAnalyzer.showBooksByRating(rating, books);
    }
    
    // Task 5
    private static void handleShowPrices(Scanner scanner, List<Book> books) {
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        BookAnalyzer.showPricesByAuthor(author, books);
    }
    
    private static void showSampleBooks(List<Book> books) {
        System.out.println("\n📖 Sample Books:");
        int count = Math.min(5, books.size());
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        if (books.size() > 5) {
            System.out.println("... and " + (books.size() - 5) + " more books");
        }
    }
}
