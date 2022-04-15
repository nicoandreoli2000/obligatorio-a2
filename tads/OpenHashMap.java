package tads;


public class OpenHashMap<K, V> implements Map<K, V> {
    //List<Pair<K,V>>[] table;
    private Object[] table;
    private int size;


    public OpenHashMap(int expectedSize) {
        this.table = new Object[expectedSize * 2 - 1];
        this.size = 0;
    }

    private int findPos(K key) {
        int h = key.hashCode();
        int pos = h % this.table.length;
        return pos;
    }
    

    @Override
    public void insert(K key, V value) {
        this.size++;
        int pos = this.findPos(key);
        List<Pair<K,V>> list = (List<Pair<K,V>>)this.table[pos];
        if (list == null) {
            list = new List<Pair<K,V>>();
            table[pos] = list;
            return;
        }
        Pair<K,V> pair = new Pair<K,V>(key, value);
        if (list.contains(pair)) {
            this.size--;
            list.delete(pair);
        }
        list.insert(pair);
    }

    @Override
    public boolean contains(K key) {
        int pos = this.findPos(key);
        List<Pair<K,V>> list = (List<Pair<K,V>>)this.table[pos];
        return list.contains(new Pair<K,V>(key));
    }

    @Override
    public V get(K key) throws Exception {
        int pos = this.findPos(key);
        List<Pair<K,V>> list = (List<Pair<K,V>>)this.table[pos];
        if(!list.contains(new Pair<K,V>(key))){
            throw new Exception("La tabla no contiene el elemento: " + key.toString());
        }
        return null;
    }

    @Override
    public void delete(K key) {
        if (!this.contains(key)) {
            return;
        }
        int pos = this.findPos(key);
        List<Pair<K,V>> list = (List<Pair<K,V>>)this.table[pos];
        this.size--;
        list.delete(new Pair<K,V>(key));
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
