import java.io.*;

public class Main {
    public static void main(String[] args) {
        SimpleDatabaseUsage<String, Integer> db = new SimpleDatabaseUsage<>();

        // Perform some basic CRUD operations
        db.put("One", 1);
        db.put("Two", 2);
        db.put("Three", 3);


        // Get value for a key
        db.get("Two").ifPresent(value -> System.out.println("Value for key 'Two': " + value));

        // Check if a key exists
        System.out.println("Contains 'Three'? " + db.containsKey("Three"));  // Output: true

        // Save database to a file
        try {
            db.saveToFile("files/database.db");
            System.out.println("Database saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save the database: " + e.getMessage());
        }
    }
}
