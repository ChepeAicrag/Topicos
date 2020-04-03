/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilos_1;

/**
 * 
 * @author Garcia Garcia Jose Angel
 * Para bastante cantidad de hilos
 */
public class HelloRunneable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }
    public static void main(String[] args) {
       new Thread(new HelloRunneable()).start();
    }
}
