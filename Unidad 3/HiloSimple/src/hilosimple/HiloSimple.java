/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosimple;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class HiloSimple extends Thread {

    private int cuentaAtras = 5;
    private static int conteoHilos = 0;
    private int numeroHilo = ++conteoHilos;

    public HiloSimple() {
        System.out.println("Creando " + numeroHilo);

    }
    @Override
    public void run() {
        while (true) {
            System.out.println("Hilo "
                    + numeroHilo + " (" + cuentaAtras + ")") ;
if (--cuentaAtras == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new HiloSimple().start();
        }
        System.out.println("Todos los hilos Arrancados");
    }
    

}
