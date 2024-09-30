package src;

public interface TableLevelCrudFunctions {

    void put(String key, String value);

    String get(String key);

    void delete(String key);

    boolean containsKey(String key);
}
