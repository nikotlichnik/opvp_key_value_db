import java.util.HashMap;

public class Table implements ITable {

    private final HashMap<String, String> storage = new HashMap<>();

    @Override
    public void put(String key, String value) {
        storage.put(key, value);
    }

    @Override
    public String get(String key) {
        return storage.get(key);
    }

    @Override
    public void delete(String key) {
        storage.remove(key);
    }

    @Override
    public boolean containsKey(String key) {
        return storage.containsKey(key);
    }
}
