import java.util.*;

// abstract class for hash map
public abstract class AbstractHashMap<K, V> {
    
    // nested interface for map entries
public static interface Entry<K, V> {

    // returns the key corresponding to this entry
    K getKey();

    // returns the value corresponding to this entry
    V getValue();

    // replaces the value corresponding to this entry with the specified value
    V setValue(V value);

    // compares the specified object with this entry for equality
    boolean equals(Object o);

    // returns the hash code value for this map entry
    int hashCode();
}

    // instance variables
    protected int n; // number of entries in the hash table
    protected int capacity; // length of the table
    protected int prime; // prime factor
    protected long scale, shift; // the shift and scaling factors

    // constructors
    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        n = 0; // initially empty
        java.util.Random rand = new java.util.Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int cap) {
        this(cap, 109345121); // default prime
    }

    public AbstractHashMap() {
        this(17); // default capacity
    }

    // public methods
    public int size() {
        return n;
    }

    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2) // keep load factor <= 0.5
            resize(2 * capacity - 1); // (or find a nearby prime)
        return answer;
    }

    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    public Iterable<K> keySet() {
        ArrayList<K> buffer = new ArrayList<>();
        for (Entry<K, V> e : entrySet())
            buffer.add(e.getKey());
        return buffer;
    }

    // abstract methods to be implemented by subclasses
    protected abstract void createTable();

    protected abstract V bucketGet(int h, K k);

    protected abstract V bucketPut(int h, K k, V v);

    protected abstract V bucketRemove(int h, K k);

    protected abstract Iterable<Entry<K, V>> entrySet();

    // hash function applying MAD method to default hash code
    protected int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    // resizes the hash table with a new capacity
    protected void resize(int newCap) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
        for (Entry<K, V> e : entrySet())
            buffer.add(e);
        capacity = newCap;
        createTable(); // based on updated capacity
        n = 0; // will be recomputed while reinserting entries
        for (Entry<K, V> e : buffer)
            put(e.getKey(), e.getValue());
    }

    // nested class for hash entries
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K k; // key
        private V v; // value

        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        // public methods of the Entry interface
        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            k = key;
        }

        public V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    }
}
