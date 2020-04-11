/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sin_Sincronia;

/**
 * 
 * @author García García José Ángel
 */
public class PilaS {
    
    private int tope;
    private char[] datos;
    
    public PilaS(int nd){
        datos = new char[nd];
        tope = -1;
    }
    
    public boolean llena(){
        return tope == datos.length-1;
    }
    
    public boolean vacia(){
        return tope < 0;
    }
    
    public void poner(char c){
        if (llena()) {
            System.out.println("Pila llena, intentó colocar " + Thread.currentThread().getName());
        }else{
            tope++;
            datos[tope] = c;
        }
    }
    
    public char quitar(){
        char d = ' ';
        if (vacia()) {
            System.out.println("Pila vacia, intentó retirar " + Thread.currentThread().getName());
        }else{
            d = datos[tope];
            tope--;
        }
        return d;
    }
    
    public char ver(){
        return !vacia() ? datos[tope] : ' ';
    }
    
}
