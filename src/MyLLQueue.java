import java.util.NoSuchElementException;

public class MyArrayQueue<E> implements MyQueue<E> {

    private Node<E> head, tail;
    private int size;
    private Exception NoSuchElementException;

    /**
     * Construct an empty liked list
     */
    public MyArrayQueue() {
        size = 0;

        // make dummy node for head and tail
        head = new MyArrayQueue.Node<>(null);
        tail = new MyArrayQueue.Node<>(null);

        // link together head and tail
        head.next = tail;
        tail.prev = head;
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
        if (size() == 0){
            throw new NoSuchElementException();
        }
        Node<E> returnable = head.next;
        head.next = head.next.next;
        head.next.prev = head.next.next.prev;
        return returnable.data;
    }

    /**
     * Retrieves, but does not remove, the head of this queue. This method throws an
     * exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E element(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return head.next.data;
    }

    /**
     * Inserts the specified element into this queue
     *
     * @param e the element to add
     */
    @Override
    public void add(E e) {
        MyArrayQueue.Node<E> toInsert = new MyArrayQueue.Node<>(e);
        // link in to tail and what comes before tail
        toInsert.next = tail;
        toInsert.prev = tail.prev;
        tail.prev = toInsert;
        toInsert.prev.next = toInsert;

        //update size
        size++;
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
        if (size() == 0) {
            return true;
        } else {
             return false;}
    }
    private static class Node<T> {
        // static nested class
        T data;
        MyArrayQueue.Node<T> next, prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
