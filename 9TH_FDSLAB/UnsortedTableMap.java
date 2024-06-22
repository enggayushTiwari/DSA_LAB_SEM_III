import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

// class for unsorted map using an array list of entries
public class UnsortedTableMap<K, V> extends AbstractHashMap<K, V> {

    // instance variable
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>(); // underlying storage

    // constructor
    public UnsortedTableMap() {
    }

    // private utility
    // returns the index of an entry with equal key, or -1 if none found
    private int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++)
            // use Objects.equals to handle null keys
            if (Objects.equals(table.get(j).getKey(), key))
                return j;
        return -1; // special value denotes that key was not found
    }

    // public methods
    // returns the number of entries in the map
    @Override
    public int size() {
        return table.size();
    }

    // returns the value associated with the specified key, or null if no such entry exists
    @Override
    public V get(K key) {
        int j = findIndex(key);
        if (j == -1)
            return null; // not found
        return table.get(j).getValue();
    }

    // associates the given value with the given key
    // if an entry with the key was already in the map, this replaced the previous value with the new one and returns the old value
    // otherwise, a new entry is added and null is returned
    @Override
    public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1) {
            // use diamond operator to infer generic type arguments
            table.add(new MapEntry<>(key, value)); // add new entry
            return null;
        } else // key already exists
            return table.get(j).setValue(value); // replaced value is returned
    }

    // removes the entry with the specified key, if present, and returns its value
    // otherwise does nothing and returns null
    @Override
    public V remove(K key) {
        int j = findIndex(key);
        if (j == -1)
            return null; // nothing to remove
        V answer = table.get(j).getValue();
        if (j != table.size() - 1)
            table.set(j, table.get(table.size() - 1)); // relocate last entry to 'hole' created by removal
        table.remove(table.size() - 1); // remove last entry of table
        return answer;
    }

    // returns an iterable collection of all key-value entries of the map
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }

    // support for public entrySet method
    private class EntryIterable implements Iterable<Entry<K, V>> {
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    // support for public entrySet method
    private class EntryIterator implements Iterator<Entry<K, V>> {
        // use an iterator over the table instead of an index variable
        private Iterator<MapEntry<K, V>> iter = table.iterator();

        public boolean hasNext() {
            return iter.hasNext();
        }

        public Entry<K, V> next() {
            return iter.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    }

    // create an empty table having length equal to current capacity
    @Override
    protected void createTable() {
        // create a new array list with the given capacity
        table = new ArrayList<>(capacity);
    }

    // return value associated with key k in bucket with hash value h, or else null
    @Override
    protected V bucketGet(int h, K k) {
        // find the index of the entry with key k
        int j = findIndex(k);
        // if not found, return null
        if (j == -1) return null;
        // otherwise, return the value of the entry
        return table.get(j).getValue();
    }

    // associate key k with value v in bucket with hash value h; return old value
    @Override
    protected V bucketPut(int h, K k, V v) {
        // find the index of the entry with key k
        int j = findIndex(k);
        // if not found, add a new entry and return null
        if (j == -1) {
            table.add(new MapEntry<>(k, v));
            return null;
        }
        // otherwise, replace the value of the entry and return the old value
        return table.get(j).setValue(v);
    }

    // remove entry having key k from bucket with hash value h (if any)
    @Override
    protected V bucketRemove(int h, K k) {
        // find the index of the entry with key k
        int j = findIndex(k);
        // if not found, return null
        if (j == -1) return null;
        // otherwise, remove the entry and return its value
        return table.remove(j).getValue();
    }
}
