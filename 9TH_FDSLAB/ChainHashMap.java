import java.util.*;


// concrete subclass for hash map using separate chaining
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    // a fixed capacity array of UnsortedTableMap that serve as buckets
    private UnsortedTableMap<K, V>[] table; // initialized within createTable

    // provide same constructors as base class
    public ChainHashMap(int cap, int p) {
        super(cap, p);
    }

    public ChainHashMap(int cap) {
        super(cap);
    }

    public ChainHashMap() {
        super();
    }

    // create an empty table having length equal to current capacity
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    // return value associated with key k in bucket with hash value h, or else null
    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null)
            return null;
        return bucket.get(k);
    }

    // associate key k with value v in bucket with hash value h; return old value
    protected V bucketPut(int h, K k, V v) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null)
            bucket = table[h] = new UnsortedTableMap<>();
        int oldSize = bucket.size();
        V answer = bucket.put(k, v);
        n += (bucket.size() - oldSize); // size may have increased
        return answer;
    }

    // remove entry having key k from bucket with hash value h (if any)
    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null)
            return null;
        int oldSize = bucket.size();
        V answer = bucket.remove(k);
        n -= (oldSize - bucket.size()); // size may have decreased
        return answer;
    }

    // return an iterable collection of all key-value entries of the map
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++)
            if (table[h] != null)
                for (AbstractHashMap.Entry<K, V> entry : table[h].entrySet())
                    buffer.add((AbstractHashMap.Entry<K, V>) entry);
        return buffer;
    }

    public boolean isEmpty() {
        return false;
    }
}
