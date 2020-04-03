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
public class HiloContador extends Thread{
    private static Contador c1 = new Contador();
    public void run(){
        for (int i = 0; i < 20; i++) {
            if(Thread.currentThread().equals("h1"))
                c1.incremento();
            else
                c1.decremento();
            System.out.println(Thread.currentThread().getName() + " c: " + c1.getValor());
        }
    }
    public static void main(String[] args) {
        Thread h1 = new HiloContador();
        h1.setName("h1");
        Thread h2 = new HiloContador();
        h2.setName("h2");
        Thread h3 = new HiloContador();
        h3.setName("h3");
        h1.start();
        h2.start();
        h3.start();
    }
}
