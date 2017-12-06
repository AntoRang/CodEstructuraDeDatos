package examenPractico1;

import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	public Object[] top;
	private int size;
	private int initialCapacity = 5;
	private int extraCapacity = 5;
	
	/**
	 * Creates a new ArrayList instance with the default initial capacity.
	 */
	public ArrayList() {
		top = new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance so that it 
	 * can hold at least extraCapacity elements more.
	 * This method allocates a new array with greater capacity than the
	 * current one (top.length + extraCapacity) and copies all elements
	 * from top to the newly allocated array. The reference top is then
	 * updated to point to the new array. 
	 * @param extraCapacity increase the capacity of this ArrayList by this amount
	 */
	private void reserveExtraCapacity(int extraCapacity) {
		Object[] arrayList = new Object[top.length];
		for(int i= 0; i < top.length; i++) {
			arrayList[i] = top[i];
		}
		top = new Object[top.length + extraCapacity];
		
		for(int j =0; j<arrayList.length; j++) {
			top[j] = arrayList[j];
		}
		
	}
	
	/**
	 * Increases the capacity of this list if its size equals the length of the array
	 * where the data is stored. This method calls reserveExtraCapacity when (size() >= top.length).
	 * reserveExtraCapacity is called using the instance variable extraCapacity.
	 */
	private void ensureCapacity() {
		
		if( size >= top.length) {
			Object[] arrayList = new Object[top.length];
			for(int i= 0; i < top.length; i++) {
				arrayList[i] = top[i];
			}
			top = new Object[size + extraCapacity];
			for(int j=0; j<arrayList.length; j++) {
				top[j] = arrayList[j];
			}
			
		}
	}
	
	/**
	 * Shifts elements in the array (top) to the right, starting at the given position.
	 * @param index the position in which the shift will begin
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	private void shiftContentsRight(int index) {
		if(index < 0 || index >size()) {
			throw new IndexOutOfBoundsException();
		}
		
		for(int i = size-1; i >= index; i--) {
			
			top[i+1] = top[i];
			if(i == index) {
				top[i] = null;
			}
			
		}
	}
	
	@Override
	public void addFirst(E e) {
		ensureCapacity();
		
		shiftContentsRight(0);
		top[0] = e;
		size++;
		
	}

	@Override
	public void addLast(E e) {
		ensureCapacity();
		
		shiftContentsRight(size);
		
		top[size] = e;
		size++;
	}

	@Override
	public void add(int index, E element) {
		
		ensureCapacity();
		shiftContentsRight(index);
		top[index] = element;
		size++;
		
	}

    @Override
    public E getFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        @SuppressWarnings("Unchecked")
        E firstElement = (E)top[0];

        return firstElement;
    }


    @Override
    public E getLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        @SuppressWarnings("Unchecked")
        E lastElement = (E)top[size-1];
        return lastElement;
    }


    @Override
    public E get(int index) {

        if(index <0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        E elementAtIndex = (E)top[index];

        return elementAtIndex;

    }

    @Override
    public E set(int index, E element) {
        if(index <0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        E previousElement = (E) top[index];
        top[index] = element;
        return previousElement;
    }

	@Override
	public void clear() {
		top = new Object[initialCapacity];
		size= 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if(size == 0) {
			return "[]";
		}
		
		String returnString= "[" + top[0];
		if(size ==1) {
			return returnString + "]";
		}
		
		for(int i =1; i< size; i++) {
			returnString += ", " + top[i];
		}
		
		returnString += "]";
		
		return returnString;
	}
}
