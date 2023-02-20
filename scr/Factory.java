package scr;
public class Factory<T> {
	
	
	public AbstractList<T> getInstance(String type) {
		
		AbstractList<T> listInstance;
		
		switch (type.toLowerCase()) {
		case "Single":{
			listInstance = new SingleLinkedList<T>();
		}break;
		
		case "Double":{
			listInstance = new DoubleLinkedList<T>();
		}break;
		
		default:{
			listInstance = null;
		}
		}
		
		return listInstance;
	}

}