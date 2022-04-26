package tads;

public class Pair<K, V> {
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Pair(K key) {
        this.key = key;
        this.value = null;
    }

    @Override
    public boolean equals(Object other) {
        return this.key.equals(((Pair<K, V>) other).key);
    }
}