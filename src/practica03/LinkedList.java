package practica03;
import Stacks.Stack;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index < (size >> 1)) {
            Node<E> x = header.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = header.prev;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
        Node<E> newElement = new Node<E>(e);

        Node<E> firstElement = header.next;

        newElement.next=firstElement;
        firstElement.prev = newElement;

        newElement.prev =header;
        header.next = newElement;
        size++;

	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		Node<E> newElement = new Node<E>(e);
        Node<E> lastElement = header.prev;

        newElement.prev = lastElement;
        lastElement.next = newElement;

        newElement.next = header;
        header.prev = newElement;

        size++;
		
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
        if(index <0 || index >size()){
            throw new IndexOutOfBoundsException();
        }

        if(index == size()){
            addLast(element);
        }else {

            Node<E> newNode = new Node<E>(element);
            Node<E> current = node(index);
            Node<E> previuosNode = current.prev;

            newNode.prev = previuosNode;
            previuosNode.next = newNode;

            newNode.next = current;
            current.prev = newNode;
            size++;
        }

	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node<E> nodeToRemove = header.next;
        Node<E> newFirstElement = nodeToRemove.next;

        header.next = newFirstElement;
        newFirstElement.prev = header;

        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        size--;

		return nodeToRemove.value;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		Node<E> nodeToRemove = header.prev;
        Node<E> newLastElement = nodeToRemove.prev;

        header.prev = newLastElement;
        newLastElement.next = header;

        nodeToRemove.prev =null;
        nodeToRemove.next = null;

        size--;
		return nodeToRemove.value;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeToRemove = node(index);
        Node<E> previousNode = nodeToRemove.prev;
        Node<E> nextNode = nodeToRemove.next;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        size--;

        return nodeToRemove.value;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub

        int index = indexOf(o);

        if(index >= 0 && index < size()) {
            remove(index);
            return true;
        }

        return false;
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		if(isEmpty()){
            throw new NoSuchElementException();
        }

		return header.next.value;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		if(isEmpty()){
            throw new NoSuchElementException();
        }

		return header.prev.value;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
        if(index<0 || index>= size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = header;
        for(int i=0; i<=index; i++){
            current =current.next;
        }


		return current.value;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
        Node<E> current = header;
        for(int i =0; i < index; i++){
            current = current.next;

        }

        Node<E> newElement = current.next;
        newElement.value = element;

		return newElement.value;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		Node<E> current = header;
        Node<E> nodeToSearch = new Node<E>(e);
        for(int i =0; i <= size();i++){
            if(nodeToSearch.value == current.value){
                return true;
            }
            current = current.next;
        }
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		int index = 0;
        if(o == null) {
            for (Node<E> x = header.next; x != header; x = x.next) {
                if (x.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = header.next; x != header; x = x.next) {
                if (o.equals(x.value)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
	}

    public int lastIndexOf(Object o){
        int i =0;
        if(o == null){
            for(Node<E> x = header.prev; x != header; x = x.prev){
                if(x.value == null){
                    return size() - (i+1);
                }
                i++;
            }
        } else{
            for(Node<E> x = header.prev; x != header; x=x.prev){
                if(o.equals(x.value)){
                    return size() - (i+1);
                }
                i++;
            }
        }
        return -1;
    }

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		header.next = header;
        header.prev = header;
        size=0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
    public Object[] toArray() {
        Object[] returnArray = new Object[size];

        int i = 0;
        for(Node<E> x = header.next; x != header; x = x.next) {
            returnArray[i++] = x.value;
        }

        return returnArray;
    }
	
	public E josephus(int jumps){
		Node<E> current = header.next;
	    int dead =0;
        int index;
        int alive = size-1;
	    while(dead < alive){

            for(int i=0; i<jumps; i++){
                while(current == header ){
                    current = current.next;
                }

	            if(i == (jumps-1)){
                    System.out.println("El valor de: " + current.value+" es eliminado");
                    index = indexOf(current.value);
                    current = current.prev;
                    remove(index);
	                dead++;
                }

                current = current.next;
            }
        }
        return header.next.value;
        
    }
	
	@Override
	public String toString() {
	    if(header.next.value == null){
	        return "[]";
        }

        Node<E> current = header.next;
	    String returnValue = "[" + current.value;

	    while(current.next != header){
	        current = current.next;
	        returnValue += "," + current.value;
        }

        returnValue += "]";
	    return returnValue;
	}


    // Ejercicios de Listas Ligadas

    public int count(E value){
	    int countValue=0;
	    Node<E> current = header.next;
        while(current != header){
            if(current.value.equals(value)){
                countValue++;
            }
            current = current.next;
        }
        return countValue;
    }

    public boolean removeFirstOccurrence(E value){
        Node<E> current = header.next;
        while(current != header){
            if(current.value.equals(value)){
                remove(current.value);
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public boolean removeLastOccurrence(E value){
        Node<E> current = header.prev;
        int i=0;

        while(current != header){
            if(current.value.equals(value)){
                remove(lastIndexOf(current.value));
                return true;
            }
            i++;
            current = current.prev;
        }

        return false;
    }


    public int countValue(E element){
        Node<E> current = header.next;
        int count = 0;
        while (current != header){
            if(current.value == element){
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public void reverseOrder(int first, int last){
        if(first < 0 || last > size){
            throw new IndexOutOfBoundsException();
        }

        Stack<E> stackValue = new Stack<E>();


        Node<E> current = node(first-1);
        Node<E> currentLast = node(last-1).next;

        while (current != currentLast){
            stackValue.push(current.value);
            current = current.next;
        }

        current = node(first-1);

        while(!(stackValue.empty())){
            current.value = stackValue.pop();
            current = current.next;
        }

    }

}