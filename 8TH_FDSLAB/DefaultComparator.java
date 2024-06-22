import java.util.*;

// A generic comparator that uses the natural ordering of the keys 
public class DefaultComparator<K> implements Comparator<K> { 
    // Compares two keys using their natural ordering 
    public int compare(K a, K b) throws ClassCastException { 
        return ((Comparable<K>) a).compareTo(b); // cast a to Comparable 
        }
    }