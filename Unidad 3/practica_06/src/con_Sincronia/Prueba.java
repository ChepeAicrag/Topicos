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
public class Prueba {

    public static void main(String[] args) {
        Pila pila = new Pila(10);
        Productor p1 = new Productor(pila);
        Productor p2 = new Productor(pila);
        Thread prodT1 = new Thread(p1, "Hilo_1-productor");
        Thread prodT2 = new Thread(p2, "Hilo_2-productor");
        Thread c1 = new Thread(new Consumidor(pila), "Hilo_1-consumidor");
        Thread c2 = new Thread(new Consumidor(pila), "Hilo_2-consumidor");
        Thread c3 = new Thread(new Consumidor(pila), "Hilo_3-consumidor");
        prodT1.start();
        prodT2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
