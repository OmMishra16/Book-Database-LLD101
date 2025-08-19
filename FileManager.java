import java.util.List;
import java.util.ArrayList;

// Simple manager class for CSV files
public class FileManager {
    private FileReader reader;
    
    // Constructor
    public FileManager(FileReader reader) {
        this.reader = reader;
    }
    
    // Load books using the reader
    public List<Book> loadBooks(String filename) {
        if (reader != null) {
            return reader.readFile(filename);
        }
        return new ArrayList<>();
    }
    
    // Get current reader type
    public String getCurrentReaderType() {
        return reader != null ? reader.getType() : "None";
    }
}
