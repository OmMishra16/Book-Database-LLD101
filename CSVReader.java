import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

// Concrete class - extends abstract class
public class CSVReader extends BaseFileReader {
    
    @Override
    public List<Book> readFile(String filename) {
        List<Book> books = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // Skip header
            
            String line;
            while ((line = br.readLine()) != null) {
                Book book = parseCSVLine(line);
                if (book != null) {
                    books.add(book);
                }
            }
            
            printSuccess(books.size(), getType()); // Using parent method
            
        } catch (Exception e) {
            printError("Cannot read CSV file: " + e.getMessage()); // Using parent method
        }
        
        return books;
    }
    
    @Override
    public String getType() {
        return "CSV";
    }
    
    // Private helper method
    private Book parseCSVLine(String line) {
        try {
            String[] parts = splitCSVLine(line);
            if (parts.length >= 7) {
                String title = cleanField(parts[0]);
                String author = cleanField(parts[1]);
                double rating = Double.parseDouble(parts[2].trim());
                double price = Double.parseDouble(parts[4].trim());
                
                return new Book(title, author, rating, price);
            }
        } catch (Exception e) {
            // Skip bad lines silently for cleaner output
        }
        return null;
    }
    
    // Handle CSV parsing with commas inside quotes
    private String[] splitCSVLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean inQuotes = false;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(currentField.toString());
                currentField = new StringBuilder();
            } else {
                currentField.append(c);
            }
        }
        
        fields.add(currentField.toString());
        return fields.toArray(new String[0]);
    }
    
    // Clean field by removing quotes
    private String cleanField(String field) {
        field = field.trim();
        if (field.startsWith("\"") && field.endsWith("\"")) {
            field = field.substring(1, field.length() - 1);
        }
        return field;
    }
}
