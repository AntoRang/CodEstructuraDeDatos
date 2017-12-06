package Queue;

import practica03.LinkedList;

import java.util.NoSuchElementException;

/**
 * Created by AntonioRang on 9/18/17.
 */
public class Queue<E> implements IQueue<E> {


    private LinkedList<E> queue;

    public Queue(){
        queue = new LinkedList<E>();
    }

    @Override
    public void offer(E e) {
        queue.addFirst(e);
    }

    @Override
    public E remove() {
        if(queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeLast();
    }

    @Override
    public E element() {
        if(queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    public void removeAll(E item){

        Queue<E> queueValues = new Queue<E>();

        while(size() != 0){
            queueValues.offer(remove());
        }

        E valueToRemove = queueValues.remove();;

        while(queueValues.size() != 0){

            if(! valueToRemove.equals(item)){
                offer(valueToRemove);
                valueToRemove = queueValues.remove();
            }else{
                valueToRemove = queueValues.remove();
                if(! valueToRemove.equals(item)){
                    offer(valueToRemove);
                }

            }

        }
    }
}
