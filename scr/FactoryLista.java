package scr;
public class FactoryLista<T> {
	
	
	public AbstractList<T> getInstance(String type) {
		
		AbstractList<T> listInstance;
		
		switch (type.toLowerCase()) {
		case "single":{
			listInstance = new SinglyLinkedList<T>();
		}break;
		
		case "double":{
			listInstance = new DoubleLinkedList<T>();
		}break;
		
		default:{
			listInstance = null;
		}
		}
		
		return listInstance;
	}

}