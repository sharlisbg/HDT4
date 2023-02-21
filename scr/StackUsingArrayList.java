package scr;
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
	
	
	
	/** 
	 * @return int
	 */
	public int count() {
		return miListaInterna.size();
	}

	/** 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return miListaInterna.isEmpty();
	}

	/*
	 * Método para agregar valor
	 */
	public void push(T value) {
		miListaInterna.add(0, value);
	}
	/*
	 * Método para remover valores de la lista en la posición 0
	 */
	public T pull() {
		return miListaInterna.remove(0);
	}

	/*
	 * Método para obtener valor de la lista en la posición 0
	 */
	public T peek() {		
		return miListaInterna.get(0);
	}

}