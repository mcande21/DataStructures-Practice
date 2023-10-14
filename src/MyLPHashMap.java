// Names / emails
// TODO
// TODO

// INSTRUCTIONS
// fill out the methods in the class below

// Do not add, remove, or change any of the class's member variables.
// The num_ghosts counter is *optional*. You might find it helpful, but it
// is not required to pass the project.

// Do not change the Bucket type.

import java.util.ArrayList;

public class MyLPHashMap<K,V> implements MyMap<K,V> {

    protected ArrayList<Bucket> buckets;

    protected int numElements = 0;
    protected int numGhosts = 0; // OPTIONAL: you don't need to use this to pass

    public MyLPHashMap() {
        // TODO: a default constructor (possibly empty).

        // You can use the following to avoid needing to implement rehashing.
        // However, you will only pass the AG test cases ending in _C.
        // To pass the rest, start with at most 20 buckets and implement rehashing.

        //        buckets = new ArrayList<>(10000);
        //        for (int i=0; i < 10000; i++) {
        //            buckets.add(new Bucket());
        //        }
    }

    /**
     * Adds a key,value pair to the HashMap and returns
     * the existing value stored (or null if this is the first insertion)
     * @param key Key to store
     * @param value Value to store
     * @return previous value associated with key, otherwise null
     */
    @Override
    public V put(K key, V value) {
        // TODO
        return null;
    }

    /**
     * Return a value associated with a key (null if the key is not found)
     * @param key key to search
     * @return value associated with key or null
     */
    @Override
    public V get(Object key) {
        // TODO
        return null;
    }

    /**
     * Check if a key exists in the HashMap
     * @param key key to search
     * @return true if the key is found; false otherwise
     */
    @Override
    public boolean containsKey(Object key) {
        // TODO
        return false;
    }

    /**
     * Removes a key-value pair from the HashMap
     * @param key key to search
     * @return the value that was removed or null if not found
     */
    @Override
    public V remove(Object key) {
        // TODO
        return null;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void growAndRehash() {
        // TODO (optional)
    }

    // TODO you can add methods here if you like

    // A bucket's status tells you whether it's filled, empty, or contains a ghost.
    protected enum Status {
        Empty,
        Filled,
        Ghost
    }

    // A bucket has a status, a key, and a value.
    protected class Bucket {
        // Do not modify Bucket
        Status status = Status.Empty;
        K key;
        V val;
    }
}
