package scr;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import java.lang.Exception;

/**
 * @author Sharis Barrios
 *
 */

public class Pruebas {
    Calculator calc = new Calculator();
    ArrayList<String> list = new ArrayList<String>();


    @Test
	public void calculandoConExito() throws Exception {
        // Lista en infix
        list.add("1+2*9");
		// Convertirá y lo calculará como postfix
		int x = calc.Calculate(list, "Lista Simple");
		assertEquals(19, x);
	}

    @Test
	public void calculandoConExito2() throws Exception {
		// Lista en infix
        list.add("1+2*9");
		// Convertirá y lo calculará como postfix
		int x = calc.Calculate(list, "Lista Doble");
		assertEquals(9, x);
	}

	@Test
	public void calculandoConExito3() throws Exception {
        // Lista en infix
        list.add("1+2*9");
		// Convertirá y lo calculará como postfix
		int x = calc.Calculate(list, "Arreglo");
		assertEquals(9, x);
	}

	@Test
	public void calculandoConExito4() throws Exception {
        // Lista en infix
        list.add("1+2*9");
		// Convertirá y lo calculará como postfix
		int x = calc.Calculate(list, "Vector");
		assertEquals(9, x);
	}
    
}
