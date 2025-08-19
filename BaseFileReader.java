import java.util.List;
import java.util.ArrayList;

// Abstract class - Common functionality for all readers
public abstract class BaseFileReader implements FileReader {
    
    // Common method - implemented here (no need to repeat in child classes)
    protected void printSuccess(int count, String type) {
        System.out.println("✓ Loaded " + count + " books from " + type + " file");
    }
    
    // Common method - error handling
    protected void printError(String message) {
        System.out.println("✗ Error: " + message);
    }
    
    // Abstract method - child classes MUST implement this
    public abstract List<Book> readFile(String filename);
    
    // Abstract method - child classes MUST implement this  
    public abstract String getType();
}
