import java.io.*;
import java.util.HashMap;

public class Database implements IDatabase {

    private final HashMap<String, ITable> tables = new HashMap<>();

    @Override
    public void createTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            tables.put(tableName, new Table());
        } else {
            throw new IllegalArgumentException("Table " + tableName + " already exists.");
        }
    }

    @Override
    public void deleteTable(String tableName) {
        tables.remove(tableName);
    }

    @Override
    public boolean containsTable(String tableName) {
        return tables.containsKey(tableName);
    }

    @Override
    public ITable getTable(String tableName) {
        if (tables.containsKey(tableName)) {
            return tables.get(tableName);
        } else {
            throw new IllegalArgumentException("Table " + tableName + " does not exist.");
        }
    }

    @Override
    public void saveToFile(String filePath) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
        }
    }

    @Override
    public void loadFromFile(String filePath) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Database loaded = (Database) ois.readObject();
            this.tables.clear();
            this.tables.putAll(loaded.tables);
        }
    }
}