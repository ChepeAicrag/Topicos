package hilos_1;

import java.util.Random;

/**
 * 
 * @author García García Jose Angel
 */
public class Hilo1 implements Runnable{

    @Override
    public void run() {
        Random rdm = new Random();
        int prioridad = rdm.nextInt(10) + 1;
        if(prioridad < 5){
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        }else if(prioridad > 5){
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }else
            Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        System.out.println("Soy el hilo: " + Thread.currentThread().getName() + "con la "
                + "prioridad " + Thread.currentThread().getPriority());
                for (int i = 1; i <= 20; i++) {
                    System.out.println("Hilo : " + Thread.currentThread().getName() + " x: " + i);
        }
    }

}
