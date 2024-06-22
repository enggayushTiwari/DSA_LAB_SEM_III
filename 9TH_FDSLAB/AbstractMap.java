import java.util.*;

// abstract class for map
public abstract class AbstractMap<K, V> implements Map<K, V> {

    // returns the number of key-value mappings in this map
    public abstract int size();

    // returns true if this map contains no key-value mappings
    public boolean isEmpty() {
        return size() == 0;
    }

    // returns true if this map contains a mapping for the specified key
    public abstract boolean containsKey(Object key);

    // returns true if this map maps one or more keys to the specified value
    public abstract boolean containsValue(Object value);

    // returns the value to which the specified key is mapped, or null if this map contains no mapping for the key
    public abstract V get(Object key);

    // associates the specified value with the specified key in this map
    public abstract V put(K key, V value);

    // removes the mapping for a key from this map if it is present
    public abstract V remove(Object key);

    // copies all of the mappings from the specified map to this map
    public abstract void putAll(Map<? extends K, ? extends V> m);

    // removes all of the mappings from this map
    public abstract void clear();

    // returns a Set view of the keys contained in this map
    public abstract Set<K> keySet();

    // returns a Collection view of the values contained in this map
    public abstract Collection<V> values();

    // returns a Set view of the mappings contained in this map
    public abstract Set<Map.Entry<K, V>> entrySet();

    // compares the specified object with this map for equality
    public abstract boolean equals(Object o);

    // returns the hash code value for this map
    public abstract int hashCode();

    // nested class for map entries
    protected static class MapEntry<K, V> implements Map.Entry<K, V> {
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
