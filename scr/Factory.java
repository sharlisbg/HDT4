package scr;
public class Factory<T> {
	
	public IStack<T> getInstance(String type) {
		
		if(type == null){
			return null;
		}

		if(type.equalsIgnoreCase("Lista Simple")){
			return new StackUsingLinkedList<T>();
		}

		if(type.equalsIgnoreCase("Lista Doble")){
			return new StackUsingDoubleLinkedList<T>();
		}

		if(type.equalsIgnoreCase("Arreglo")){
			return new StackUsingArrayList<T>();
		}

		if(type.equalsIgnoreCase("Vector")){
			return new Vector<T>();
		}

		return null;
	}

}