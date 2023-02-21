package scr;
import java.util.ArrayList;

/*
 * @author: Ejericio HDT2 y Sharis Barrios
 */
public class Calculator implements IPostFixCalculator<String>{
    // atributos
    private static boolean instance_flag = false; //true if 1 instance
	private static Calculator unicaCalculadora; // nos ayudará a implementar Singleton a la Calculadora
    private IStack<Integer> arraynumeros; // Para crear una instancia de lo que será una lista o un stack o vector

    // metodos
    /** PostfixCalculator es el constructor de la clase  */
    public Calculator() {
        // creamos una instancia de StackUsingArrayList de enteros
        this.instance_flag = true;
    }

    public static Calculator getInstance() {
		if (instance_flag) {
			return unicaCalculadora;
		} else {
			unicaCalculadora = new Calculator();
			return unicaCalculadora;
		}
	}

    /** IsOperator es un metodo que indica si el caracter es un operador o no
     * @param valoraevaluar es un int que representa el codigo ascii del caracter
     * @return un boolean que indica si el caracter es un operador o no
     */
    private boolean IsOperator(int valoraevaluar) {
        boolean isoperator = false;

        // validamos si el entero corresponde al codigo ascii de un operador
        if (valoraevaluar == 42 || valoraevaluar==43 || valoraevaluar==45 || valoraevaluar==47) {
            isoperator = true;
        } else {
            isoperator = false;
        }

        return isoperator;
    }

    /** DivisionbyZero es un metodo que verifica que si el divisor es cero. En ese caso, lanza una excepcion.
     * @param operandoB es el divisor
     * @return void
     * @throws Exception
     */
    private void DivisionbyZero(int operandoB) throws Exception{
        if (operandoB ==0) {
            throw new Exception("Usted esta realizando una division por cero");
        }
    }

    @Override
    public int Calculate(ArrayList<String> infix_expression, String type) throws Exception{
        // recorremos el arraylist de strings
        int retorno = 0;
        boolean huboerror = false;
        arraynumeros = new Factory<Integer>().getInstance(type);
        Infix convertidor;
        ArrayList<String> postfix_expression = Infix.ToPostFix(infix_expression, type);

        for (String string : postfix_expression) {
            // recorremos cada caracter del string
            for (int i = 0; i < string.length(); i++) {
                // obtenemos el caracter en la iesima posicion
                char caracter = string.charAt(i);
                // obtenemos el ascii en la iesima posicion
                int ascii = (int) caracter;

                // usamos el metodo IsOperator para determinar si el caracter es o no operador
                boolean isoperator = this.IsOperator(ascii);

                // validamos que sea un entero, i.e. no es un operador ni espacio en blanco
                if (isoperator==false && ascii!=32) {
                    // convertimos el caracter a entero
                    int numero = Character.getNumericValue(caracter);
                    // agregamos el entero al stack
                    arraynumeros.push(numero);
                } else if(isoperator == true){
                    // validamos que el operador sea una multiplicacion
                    if (ascii==42) {
                        try {
                            // verificamos que existan al menos dos operandos en el stack
                            if(arraynumeros.count()<2){
                                throw new Exception("No hay valores suficientes para realizar la operación");
                            }
                            // hacemos pull para obtener los operandos
                            int operandoB = arraynumeros.pull();
                            int operandoA = arraynumeros.pull();
                            // realizamos la operacion
                            int resultado = operandoA*operandoB;
                            // hacemos push del resultado
                            arraynumeros.push(resultado);
                        } catch (Exception e) {
                            huboerror = true;
                            System.out.println(e.getMessage());
                        }
                    }

                    // validamos que el operador sea una suma 
                    if (ascii == 43) {
                        try {
                            // verificamos que existan al menos dos operandos en el stack
                            if(arraynumeros.count()<2){
                                throw new Exception("No hay valores suficientes para realizar la operación");
                            }
                            // hacemos pull para obtener los operandos
                            int operandoB = arraynumeros.pull();
                            int operandoA = arraynumeros.pull();
                            // realizamos la operacion 
                            int resultado = operandoA+operandoB;
                            // hacemos push del resultado
                            arraynumeros.push(resultado);
                        } catch (Exception e) {
                            huboerror = true;
                            System.out.println(e.getMessage());
                        }
                    }

                    // validamos que el operador sea una resta
                    if (ascii == 45) {
                        // validamos que existan al menos dos operadores en el stack
                        if(arraynumeros.count()<2){
                            throw new Exception("No hay valores suficientes para realizar la operación");
                        }
                        // hacemos pull para obtener los dos operandos
                        int operandoB = arraynumeros.pull();
                        int operandoA = arraynumeros.pull();
                        // realizamos la operacion
                        int resultado = operandoA - operandoB;
                        // hacemos push del resultado
                        arraynumeros.push(resultado);
                    }                    

                    // validamos que el operador sea una division
                    if (ascii == 47) {
                        try {
                            // validamos que existan al menos dos operadores en el stack
                            if(arraynumeros.count()<2){
                                throw new Exception("No hay valores suficientes para realizar la operación");
                            }
                            // hacemos el pull para obtener los dos operandos
                            int operandoB = arraynumeros.pull();
                            int operandoA = arraynumeros.pull();
                            try {
                                // validamos que no exista division por cero
                                this.DivisionbyZero(operandoB);
                                // realizamos la operacion
                                int resultado = operandoA/operandoB;
                                // hacemos el push del resultado
                                arraynumeros.push(resultado);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } catch (Exception e) {
                            huboerror = true;
                            System.out.println(e.getMessage());
                        }

                    }
                }

            }
            // hacemos pull del resultado
            if (huboerror==false) {
                retorno = arraynumeros.pull();
            }else{
                throw new Exception("Ocurrio un error en la operacion");
            }

            // borramos lo que estaba dentro del stack
            for (int j = 0; j < arraynumeros.count(); j++) {
                int borrar = arraynumeros.pull();
            }
        }

        return retorno;
    }

}

