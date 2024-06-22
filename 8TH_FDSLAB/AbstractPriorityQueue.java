import java.util.*;

// An abstract base class for a priority queue 
public abstract class AbstractPriorityQueue<K,V> {

// A nested class to represent a key-value pair 
protected static class PQEntry<K,V> implements Entry<K,V> { 
    private K k; // key 
    private V v; // value

public PQEntry(K key, V value) {
  k = key;
  v = value;
}

// Methods of the Entry interface
public K getKey() { 
    return k; 
    }
public V getValue() { 
    return v; 
    }

// Utilities not exposed as part of the Entry interface
protected void setKey(K key) { 
    k = key; 
    }
protected void setValue(V value) { 
    v = value; 
    }
}

// Instance variable for an abstract priority queue 
private Comparator<K> comp; // comparator defining the ordering of keys

// Creates an empty priority queue using the natural ordering of its keys 
protected AbstractPriorityQueue() { 
    this(new DefaultComparator<K>()); 
    }

// Creates an empty priority queue using the given comparator to order keys 
protected AbstractPriorityQueue(Comparator<K> c) { 
    comp = c;
    }

// Method for comparing two entries according to key 
protected int compare(Entry<K,V> a, Entry<K,V> b) { 
    return comp.compare(a.getKey(), b.getKey());
    }

// Determines whether a key is valid 
protected boolean checkKey(K key) throws IllegalArgumentException { 
            return (comp.compare(key,key) == 0); // see if key can be compared to itself 
    }

// Tests whether the priority queue is empty 
public boolean isEmpty() { 
    return size() == 0; 
    }

// Abstract methods that must be implemented by subclasses 
public abstract int size(); 
public abstract Entry<K,V> min(); 
public abstract Entry<K,V> insert(K key, V value) throws IllegalArgumentException; 
public abstract Entry<K,V> removeMin(); 
    }