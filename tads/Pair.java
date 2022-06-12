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

    public K fst() {
        return key;
    }

    public V snd() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return key.equals(((Pair<K, V>) other).key) && value.equals(((Pair<K, V>) other).value);
    }

    @Override
    public String toString() {
        return "(" + this.key.toString() + "," + this.value.toString() + ")";
    }
}