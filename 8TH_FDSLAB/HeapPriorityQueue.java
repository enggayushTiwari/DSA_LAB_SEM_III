import java.util.*;

// An implementation of a priority queue using an array-based heap
public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

  // The heap is stored as an array-list of entries
  protected ArrayList<Entry<K,V>> heap = new ArrayList<>();

  // Creates an empty priority queue with the default comparator
  public HeapPriorityQueue() { super(); }

  // Creates an empty priority queue with the given comparator
  public HeapPriorityQueue(Comparator<K> comp) { super(comp); }

  // Returns the index of the parent of the node at index j
  protected int parent(int j) { return (j-1) / 2; }

  // Returns the index of the left child of the node at index j
  protected int left(int j) { return 2*j + 1; }

  // Returns the index of the right child of the node at index j
  protected int right(int j) { return 2*j + 2; }

  // Checks if the node at index j has a left child
  protected boolean hasLeft(int j) { return left(j) < heap.size(); }

  // Checks if the node at index j has a right child
  protected boolean hasRight(int j) { return right(j) < heap.size(); }

  // Swaps the entries at indices i and j of the array-list
  protected void swap(int i, int j) {
    Entry<K,V> temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  // Moves the entry at index j upward to restore the heap property
  protected void upheap(int j) {
    while (j > 0) { // continue until reaching root (or break statement)
      int p = parent(j);
      if (compare(heap.get(j), heap.get(p)) >= 0) break; // heap property verified
      swap(j, p);
      j = p; // continue from the parent's location
    }
  }

  // Moves the entry at index j downward to restore the heap property
  protected void downheap(int j) {
    while (hasLeft(j)) { // continue to bottom (or break statement)
      int leftIndex = left(j);
      int smallChildIndex = leftIndex; // although right may be smaller
      if (hasRight(j)) {
        int rightIndex = right(j);
        if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
          smallChildIndex = rightIndex; // right child is smaller
      }
      if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
        break; // heap property has been restored
      swap(j, smallChildIndex);
      j = smallChildIndex; // continue at position of the child
    }
  }

  // Returns the number of entries in the priority queue
  public int size() { return heap.size(); }

  // Returns (but does not remove) a priority queue entry (k,v) having minimal key
  public Entry<K,V> min() {
    if (heap.isEmpty()) return null;
    return heap.get(0);
  }

  // Inserts a key-value pair and returns the entry created
  public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
    checkKey(key); // auxiliary key-checking method (could throw exception)
    Entry<K,V> newest = new PQEntry<>(key, value);
    heap.add(newest); // add to the end of the list
    upheap(heap.size() - 1); // upheap newly added entry
    return newest;
  }

  // Removes and returns an entry (k,v) having minimal key
  public Entry<K,V> removeMin() {
    if (heap.isEmpty()) return null;
    Entry<K,V> answer = heap.get(0);
    swap(0, heap.size() - 1); // put minimum item at the end
    heap.remove(heap.size() - 1); // and remove it from the list
    downheap(0); // then fix new root
    return answer;
  }
}
