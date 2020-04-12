/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con_Sincronia;

/**
 * @author Sanchez Lopez Laura Yessenia
 * @author García García José Ángel
 */
public class Consumidor implements Runnable {

    private Pila pila;
    private static int numCons = 0;
    private int numC;

    public Consumidor(Pila p) {
        pila = p;
        numC = ++numCons;
    }

    @Override
    public void run() {
        char c;
        for (int i = 0; i < 20; i++) {
            c = pila.quitar();
            System.out.println("Hilo: " + Thread.currentThread().getName() + " Consumidor " + numC + " : " + c);
            try {
                Thread.sleep((int) (Math.random() * 777));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
