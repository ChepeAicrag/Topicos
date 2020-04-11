/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package con_Sincronia;

/**
 * 
 * @author García García José Ángel
 */
public class Pila {
    
    private int tope;
    private char[] datos;
    
    public Pila(int nd){
        datos = new char[nd];
        tope = -1;
    }
    
    public boolean llena(){
        return tope == datos.length-1;
    }
    
    public boolean vacia(){
        return tope < 0;
    }
    
    public synchronized void poner(char c){
        if (llena())
            System.out.println("Pila llena, intentó colocar " + Thread.currentThread().getName());
        while(llena())
            try {
                this.wait();
            } catch (InterruptedException e) {}
        tope++;
        datos[tope] = c;
        this.notify();
    }
    
    public synchronized char quitar(){
        char d = ' ';
        if (vacia()) 
            System.out.println("Pila vacia, en espera el hilo " + Thread.currentThread().getName());
        while (vacia())                 
              try {
                   this.wait();
                } catch (InterruptedException e) {}
        d = datos[tope];
        tope--;
        this.notify();
        return d;
    }
    
    public char ver(){
        return !vacia() ? datos[tope] : ' ';
    }

}
