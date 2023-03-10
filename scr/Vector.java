package scr;

/**
 * @author: Libro Java Structures
 *  Método para crear un vector con la interfaz IStack
 */

public class Vector<T> implements IStack<T> {
    private Node<T> top;
	int count;
	
	public Vector() {
		top = null;
		count = 0;
	}
	
	@Override
	public int count() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count() == 0;
	}

	@Override
	public void push(T value) {
		Node<T> newNode = new Node<T>(value);
		
		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
		
		count++;
	}

	@Override
	public T pull() {
		
		if (isEmpty()) {
			return null;
		} else {
			Node<T> temp = top;
			top = top.getNext();
			count--;
			
			return temp.getValue();
		}
		
	}

	@Override
	public T peek() {
		
		if (isEmpty()) {
			return null;
		} else {
			return top.getValue();
		}
		
	}
}
