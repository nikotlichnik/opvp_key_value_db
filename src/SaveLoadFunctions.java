import java.io.IOException;

public interface SaveLoadFunctions {

    void saveToFile(String filePath) throws IOException;

    void loadFromFile(String filePath) throws IOException, ClassNotFoundException;
}
