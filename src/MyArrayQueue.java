import java.util.NoSuchElementException;

public class MyLLQueue<E> implements MyQueue<E>{
    /**
     * Retrieves and removes the head of this queue.  This method throws an exception
     * if this queue is empty
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {
        return null;
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
        return null;
    }

    /**
     * Inserts the specified element into this queue
     *
     * @param e the element to add
     */
    @Override
    public void add(E e) {

    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return false;
    }
}
