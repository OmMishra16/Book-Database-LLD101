import java.util.List;

// Interface - Contract for reading files
public interface FileReader {
    List<Book> readFile(String filename);
    String getType();
}
