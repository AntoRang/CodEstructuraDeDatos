package Queue;

/**
 * Created by AntonioRang on 9/18/17.
 */
public interface IQueue<E> {

    /**
     * Insert the specified element into this queue
     * @param e the element to add
     */

    public void offer(E e);

    /**
     * Retrieves and removes the head of this queue.
     * This method throws an exception if this queue is empty.
     * @return the head of this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public E remove();

    /**
     * Retrieves, but does not remove, the head of this queue.
     * This method throws an exeception if this queue is empty.
     * @return the head of this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public E element();

    /**
     * Returns false if this collection contains no elements.
     * @return true if this collection contains elements
     */
    public boolean isEmpty();


    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    public void clear();

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */

    public int size();

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
     * The returned array will be safe in that no references to it are maintained by this list.
     * (In other words, this method must allocate a new array).
     * The caller is this free to modify the returned array.
     * This method acts as a bridge between array-based and collection-based APIs.
     * @return an array containing all of the elements in this list in proper sequence
     */
    public Object[] toArray();
}
