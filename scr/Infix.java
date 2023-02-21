package scr;

import java.util.ArrayList;
/*
 * @author: Sharis Barrios
 */

public class Infix {
    
    /** 
     * @param ch
     * @return int
     */
    /*
     * Obtenido desde https://www.tutorialspoint.com/Convert-Infix-to-Postfix-Expression#:~:text=To%20convert%20infix%20expression%20to,maintaining%20the%20precedence%20of%20them. 
     * Nos ayuda a saber que operación que precede a los números
     */
    public static int preced(char ch) {
        if(ch == '+' || ch == '-') {
           return 1;              //Precedence of + or - is 1
        }else if(ch == '*' || ch == '/') {
           return 2;            //Precedence of * or / is 2
        }else if(ch == '^') {
           return 3;            //Precedence of ^ is 3
        }else {
           return 0;
        }
     } 

    /*
     * Clase estatica para crear el método que convierte expresiones infix to postfix
     * Se usa factory ya que esta función tiene relación a nuestra cálculadora
     */
     public static ArrayList<String> ToPostFix(ArrayList<String> cadenas, String type){
        ArrayList<String> PostFix = new ArrayList<String>(); 
        IStack<String> pila = new Factory<String>().getInstance(type); 
        for (int i = 0; i<cadenas.size(); i++){
            String cadena = cadenas.get(i).toString();
            String postFix = ""; 

            char[] expresion = cadena.toCharArray();

            
            //Se van evaluando las opciones para conocer los operandos y saber en que posición y pila colocarlos            
            for (int j = 0; j<expresion.length; j++){
                char caracter = expresion[j]; 
                if(Character.isLetterOrDigit(caracter)){
                    String cadena2 = String.valueOf(caracter);
                    postFix += cadena2; 
                }
                else if(caracter == '('){
                    String cadena2 = String.valueOf(caracter);
                    pila.push(cadena2);
                }
                else if(caracter == '^'){
                    String cadena2 = String.valueOf(caracter);
                    pila.push(cadena2);
                }
                else if(caracter == '+'){
                    String cadena2 = String.valueOf(caracter);
                    pila.push(cadena2);
                }
                else if(caracter == '-'){
                    String cadena2 = String.valueOf(caracter);
                    pila.push(cadena2);
                }
                else if(caracter == '/'){
                    String cadena2 = String.valueOf(caracter);
                    pila.push(cadena2);
                }
                else if(caracter == '*'){
                    String cadena2 = String.valueOf(caracter);
                    pila.push(cadena2);
                }
                else if(caracter == ')'){
                    while(pila.isEmpty() == false && pila.peek().equals("(")==false){
                        String elemento = pila.pull();
                        postFix += elemento; 
                    }
                    pila.pull(); 
                }
                else{
                    Integer valorCaracter = preced(caracter); 
                    char top = pila.peek().charAt(0); 
                    Integer valorTop = preced(top); 
                    while(pila.isEmpty() == false && valorCaracter <= valorTop){
                        String elemento = pila.pull();
                        if(elemento != "("){
                            postFix += elemento; 
                        }
                    }
                }
            }
            while(pila.isEmpty() == false){
                String elemento = pila.pull();
                postFix += elemento; 
            }
            PostFix.add(i, postFix);
        }
        return PostFix; 

    }
    
}
