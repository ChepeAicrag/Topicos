/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilos_1;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class Hilo3_2 implements Runnable{
    
    private String palabra;
    
    public Hilo3_2(String s){
        palabra = s;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(palabra);
        }
    }
    
    public static void main(String[] args) {
        Thread h1 = new Thread(new Hilo3_2("Hola"));
        Thread h2 = new Thread(new Hilo3_2("mundo"));
        Thread h3 = new Thread(new Hilo3_2("desde hilo"));
        h1.start();
        h2.start();
        h3.start();
    }
}
