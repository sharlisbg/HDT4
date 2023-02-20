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
        list.add("1 2 + 4 * 3 +");
		int x = calc.Calculate(list);
		assertEquals(15, x);
	}

    @Test
	public void calculandoConExito2() throws Exception {
        list.add("1 2 + 3 *");
		int x = calc.Calculate(list);
		assertEquals(9, x);
	}
    
}
