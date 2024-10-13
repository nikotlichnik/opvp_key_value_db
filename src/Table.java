import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Table implements ITable {

    private final Map<String, String> storage = new ConcurrentHashMap<>();

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
