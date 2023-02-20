package scr;

import java.util.Scanner;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("Indique que tipo de lista o pila utilizará");
        System.out.println("Escriba: Vector, ArrayList, Single or Double");
		String entrada = "";
		entrada = in.nextLine();
		
		AbstractList<String> miLista = (new ListFactory<String>()).getInstance(entrada);
		
	}

}
