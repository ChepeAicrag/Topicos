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
public class Hilo3 extends Thread{
    private String palabra;
    
    public Hilo3(String s){
        palabra = s;
    }
    
    public void run(){
        for (int i = 0; i < 30; i++) {
            System.out.println(palabra);
        }
    }
    
    public static void main(String[] args) {
        Thread h1 = new Hilo3("hola");
        Thread h2 = new Hilo3("mundo");
        Thread h3 = new Hilo3("desde hilo");
        h1.start();
        h2.start();
        h3.start();
    }
}
