package Stacks;

/**
 * Created by AntonioRang on 9/14/17.
 */
public interface IStack<E> {

    public E push(E e);

    public E pop();

    public E peek();

    public boolean empty();

    public Object[] toArray();

}
