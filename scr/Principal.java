package scr;

/**
 * Principal
 * @author: Ejercicio hecho en HDT 2 y Sharis Barrios
 */

 import java.util.ArrayList;
 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.util.Scanner;
 
 public class Principal {
     public static void main(String[] args) {
         // creamos una instancia de calculadora
         Calculator calculadora = new Calculator();
 
         // creamos un arraylist de string donde se va a guardar lo que se lea del archivo de texto
         ArrayList<String> lectura = new ArrayList<String>();
         // creamos un arraylist de string donde se van a guardar las expresiones con simbolos validos
         ArrayList<String> expresionesvalidas = new ArrayList<String>();
         // creamos un arraylist que servira para pasar de parametro al metodo calculate
         ArrayList<String> parametro = new ArrayList<String>();
 
         Scanner in = new Scanner(System.in);
 
         // leemos el archivo usando BufferedReader
         try {
             BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
             String line;
             while ((line = reader.readLine())!= null) {
                 lectura.add(line);
             }
             reader.close();
         }catch (Exception e){
             e.printStackTrace();
         }
 
         // depuramos el array de lectura y pasamos unicamente las expresiones validas al array de expresiones validas
         // recorremos cada String del array lectura
         for (String string : lectura) {
             // declaramos un boolean que va a indicar si se agrega o no el string al array expresionesvalidas
             boolean continua = true;
             // recorremos cada string caracter por caracter
             for (int i = 0; i < string.length(); i++) {
                 // convertimos el iesimo dato del string a caracter
                 char caracter = string.charAt(i);
                 // obtenemos el codigo ascii del caracter
                 int codigoascii = (int) caracter;
                 // determinamos si el codigo ascii corresponde a un simbolo valido, i.e. a un numero u operador o espacio en blanco
                 if ((48<=codigoascii && codigoascii<=57) || codigoascii==32 || codigoascii==43 || codigoascii==42 || codigoascii==45 || codigoascii==47) {
                     continua = true;
                 } else {
                     // si el ascii de algun caracter de la expresion no es valido, sabemos que la expresion no es valida
                     // por ende no tiene sentido seguir evaluando la expresion y hacemos un break
                     continua = false;
                     break;
                 }
 
                  // si el codigo ascii de algun caracter de la expresion no es valido, no tiene sentido seguir evaluando el resto de caracteres
                 // por ende salimos del ciclo
                 if (continua == false) {
                     break;
                 }
             }
 
             // si todos los caracteres del string son validos, entonces la expresion es valida y la guardaremos en el array expresionesvalidas
             if (continua==true) {
                 expresionesvalidas.add(string);
             }
 
         }
 
         // desplegamos al usuario todas las expresiones validas 
         System.out.println("Ingrese el numero de la expresion que desea evaluar");
         int contador = 1;
         for (String string : expresionesvalidas) {
             System.out.println(contador + ". " + string);
             contador +=1 ;
         }
         int respuesta = in.nextInt();
 
         // seleccionamos la posicion en la que se encuentra la expresion que desea evaluar el usuario y la guardamos en el arraylist parametro
         parametro.add(expresionesvalidas.get(respuesta-1));
		 

		//Se despliega que pila se quiere usar para calcular las operaciones infix to postfix
		 System.out.println("¿Qué implementación de pila quiere utilizar?: Arreglo, Lista Simple, Lista Doble, Vector");
		 System.out.println("Ingrese opción escribiendo la palabra");
		 String opcionStack = in.nextLine();
		 
 
         // pasamos el array llamado parametro como parametro del metodo Calculate de la clase calculadora
         try {
             System.out.println("La respuesta a la operacion es " + calculadora.Calculate(parametro, opcionStack));
         } catch (Exception e) {
             System.out.println(e.getMessage());
         } 
 
     }
     
 }
 
