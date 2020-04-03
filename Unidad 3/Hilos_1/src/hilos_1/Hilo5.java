/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilos_1;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Hilo5 extends Thread{
    private String palabra;
    public Hilo5(String nombre,String s){
        super(nombre);
        palabra = s;
    }
    public void run(){
        //synchronized(getClass()); // Sincronizar lo que está en esta clase
        for (int i = 0; i < 30; i++) {
            System.out.println(palabra + i);
            //getClass().notify();
            try {
                //getClass().wait();
                Thread.sleep(3000);
            } catch (java.lang.InterruptedException  e) {
            }
        }
        // getClass().notify();
    }
    
    public static void main(String[] args) {
        Thread h1 = new Hilo5("h1", "HOLA");
        Thread h2 = new Hilo5("h3", "Bonjour");
        Thread h3 = new Hilo5("h3", "Bye");
        h3.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        h2.start();
        h3.start();
    }
}   
