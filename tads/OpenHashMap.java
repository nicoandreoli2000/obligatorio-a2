package tads;

public class OpenHashMap<K, V> implements Map<K, V> {
    private Object[] table;
    private int size;

    public OpenHashMap(int expectedSize) {
        table = new Object[expectedSize * 2 - 1];
        size = 0;
    }

    private int findPos(K key) {
        int h = key.hashCode();
        int pos = h % table.length;
        return Math.abs(pos);
    }

    @Override
    public void insert(K key, V value) {
        size++;
        int pos = findPos(key);
        List<Pair<K, V>> list = (List<Pair<K, V>>) table[pos];
        if (list == null) {
            list = new List<Pair<K, V>>();
            table[pos] = list;
        }
        Pair<K, V> pair = new Pair<K, V>(key, value);
        if (list.contains(pair)) {
            size--;
            list.delete(pair);
        }
        list.insert(pair);
    }

    @Override
    public boolean contains(K key) {
        int pos = findPos(key);
        List<Pair<K, V>> list = (List<Pair<K, V>>) table[pos];
        Pair<K, V> pair = new Pair<K, V>(key);
        return list == null ? false : list.contains(pair);
    }

    @Override
    public V get(K key) throws Exception {
        int pos = findPos(key);
        List<Pair<K, V>> list = (List<Pair<K, V>>) table[pos];
        Pair<K, V> pair = new Pair<K, V>(key);
        return list.get(pair).value;
    }

    @Override
    public void delete(K key) {
        if (!contains(key)) {
            return;
        }
        int pos = findPos(key);
        List<Pair<K, V>> list = (List<Pair<K, V>>) table[pos];
        list.delete(new Pair<K, V>(key));
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
