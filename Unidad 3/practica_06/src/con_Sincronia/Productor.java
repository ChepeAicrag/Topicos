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
public class Productor implements Runnable {

    private Pila pila;
    private static int numProd = 0;
    private int numP;

    public Productor(Pila p) {
        pila = p;
        numP = ++numProd;
    }

    @Override
    public void run() {
        char c;
        for (int i = 0; i < 20; i++) {
            c = (char) (Math.random() * 26 + 65);
            pila.poner(c);
            System.out.println(" Productor " + numP + " agregó " + c + " en hilo " + Thread.currentThread().getName());
            try {
                Thread.sleep((int) (Math.random() * 777));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
