package tads;

public interface Map<K, V> {
    void insert(K key, V value);

    boolean contains(K key);

    V get(K key) throws Exception;

    void delete(K key);

    int size();

    boolean isEmpty();
}
