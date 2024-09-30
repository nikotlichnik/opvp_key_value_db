package src;

import java.io.IOException;

public interface TableLevelLoadFunctions<K, V> {

    void saveToFile(String filePath) throws IOException;

    void loadFromFile(String filePath) throws IOException, ClassNotFoundException;
}
