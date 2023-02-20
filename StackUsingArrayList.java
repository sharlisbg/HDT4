import java.util.ArrayList;

/**
 * @author MAAG
 *
 */
public class StackUsingArrayList<T> implements IStack<T> {

	private ArrayList<T> miListaInterna;
	
	public StackUsingArrayList() {
		miListaInterna = new ArrayList<T>(); 
	}
	
	
	public int count() {
		return miListaInterna.size();
	}

	
	public boolean isEmpty() {
		return miListaInterna.isEmpty();
	}


	public void push(T value) {
		miListaInterna.add(0, value);
	}

	public T pull() {
		return miListaInterna.remove(0);
	}

	public T peek() {		
		return miListaInterna.get(0);
	}

}