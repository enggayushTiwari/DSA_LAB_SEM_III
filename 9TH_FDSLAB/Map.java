import java.util.*;

// interface for map
public interface Map<K, V> {

    // returns the number of key-value mappings in this map
    int size();

    // returns true if this map contains no key-value mappings
    boolean isEmpty();

    // returns true if this map contains a mapping for the specified key
    boolean containsKey(Object key);

    // returns true if this map maps one or more keys to the specified value
    boolean containsValue(Object value);

    // returns the value to which the specified key is mapped, or null if this map contains no mapping for the key
    V get(Object key);

    // associates the specified value with the specified key in this map
    V put(K key, V value);

    // removes the mapping for a key from this map if it is present
    V remove(Object key);

    // copies all of the mappings from the specified map to this map
    void putAll(Map<? extends K, ? extends V> m);

    // removes all of the mappings from this map
    void clear();

    // returns a Set view of the keys contained in this map
    Set<K> keySet();

    // returns a Collection view of the values contained in this map
    Collection<V> values();

    // returns a Set view of the mappings contained in this map
    Set<Map.Entry<K, V>> entrySet();

    // compares the specified object with this map for equality
    boolean equals(Object o);

    // returns the hash code value for this map
    int hashCode();

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
}
