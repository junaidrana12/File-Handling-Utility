
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

    public class fileHandling {
    // Method to write text to a file
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Content written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read text from a file
    public static void readFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            System.out.println("Content of the file: ");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    // Method to modify a specific line in the file
    public static void modifyFile(String filePath, int lineNumber, String newContent) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            if (lineNumber < 1 || lineNumber > lines.size()) {
                System.err.println("Line number out of range.");
                return;
            }
            lines.set(lineNumber - 1, newContent); // lineNumber is 1-based
            Files.write(Paths.get(filePath), lines);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "example.txt";

        // Writing to the file
        writeToFile(filePath, "Hello, World!\nThis is a sample text file.\nEnjoy coding!");

        // Reading from the file
        readFromFile(filePath);

        // Modifying the second line of the file
        modifyFile(filePath, 2, "This line has been modified.");

        // Reading from the file again to see the changes
        readFromFile(filePath);
    }
}
    
    
   

