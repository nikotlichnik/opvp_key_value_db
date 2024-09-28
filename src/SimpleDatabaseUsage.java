import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class SimpleDatabaseUsage<K extends Serializable, V extends Serializable>
        implements CrudFunctions<K, V>, SaveLoadFunctions<K, V> {

    private Map<K, V> database;

    public SimpleDatabaseUsage() {
        this.database = new HashMap<>();
    }

    public void put(K key, V value) {
        database.put(key, value);
    }

    public Optional<V> get(K key) {
        return Optional.ofNullable(database.get(key));
    }

    public boolean delete(K key) {
        return database.remove(key) != null;
    }

    public boolean containsKey(K key) {
        return database.containsKey(key);
    }

    public void saveToFile(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(database);
        }
    }

    public void loadFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            database = (Map<K, V>) ois.readObject();
        }
    }
}

