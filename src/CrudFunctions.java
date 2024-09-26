import java.util.Optional;

public interface CrudFunctions<K, V> {
    void put(K key, V value);
    Optional<V> get(K key);
    boolean delete(K key);
    boolean containsKey(K key);
}
