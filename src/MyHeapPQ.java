import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

// worked with bost James and Kristen so including them on this Lab!!

public class MyHeapPQ<E extends Comparable<? super E>>
        implements MyQueue<E> {

    // private member data
    private ArrayList<E> data;
    private int size;

    public MyHeapPQ() {
        // normal Constructor
        this.data = new ArrayList<E>();
    }

    public MyHeapPQ(Collection<E> other) {
        // Kev calls this a copy instructor
        this.data = new ArrayList<E>(other.size());
        // adds all the data and update size
        data.addAll(other);
        size = other.size();
        // runs backward through all the internal nodes (1/2 the size) and fix down as it runs backwards
        for (int j = data.size()/2; j >= 0; j--) {
            fixDown(j);
        }
    }

    /**
     * Move a low priority item down in the heap, starting
     * from index k
     * @param k the index in the heap to start from
     */
    private void fixDown(int k) {
        // set the left and right children
        int left = (2*k) +1;
        while (left < data.size()){
            // max of the children is default left
            int max = left;
            int right = left+1;
            // this means theres a right child, max defaults to right
            if (right < data.size() && data.get(left).compareTo(data.get(right)) < 0){
                max = right;
            }
            if (data.get(k).compareTo(data.get(max)) < 0){
                // true if k needs to be switched with max
                E tmp = data.get(k);
                data.set(k, data.get(max));
                data.set(max, tmp);
                k = max;
                left = (2*k)+1;
            } else {
                break;
            }
        }
    }

    /**
     * Move a higher priority item up in the heap from index k
     * @param k the index in the heap to start from
     */
    private void fixUp(int k) {
        // fix up fix up fix up
        while (k > 0) {
            int pindex = (k-1)/2;
            E child = data.get(k);
            E parent = data.get(pindex);
            // meaning if the child is larger than parent, two will swap
            if (child.compareTo(parent) > 0) {
                E tmp = data.get(k);
                data.set(k, parent);
                data.set(pindex, tmp);
                k = pindex;
            } else {
                break;
            }
        }
    }

    /**
     * Retrieves and removes the head of this queue.  This method throws an exception
     * if this queue is empty
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {
        if (isEmpty())
            throw new NoSuchElementException();
        // setting the head and tail
        E head = data.get(0);
        E tail = data.get(size()-1);
        // swapping to easily remove
        data.set(0, tail);
        data.set(size()-1, head);
        size--;
        E remove = data.remove(data.size()-1);
        // resetting the heap
        fixDown(0);
        return remove;
    }

    /**
     * Retrieves, but does not remove, the head of this queue. This method throws an
     * exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E element() {
        if (isEmpty())
            throw new NoSuchElementException();

        return data.get(0);
    }

    /**
     * Inserts the specified element into this queue
     *
     * @param e the element to add
     */
    @Override
    public void add(E e) {
        // self explanatory
        size++;
        data.add(e);
        fixUp(size-1);
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
