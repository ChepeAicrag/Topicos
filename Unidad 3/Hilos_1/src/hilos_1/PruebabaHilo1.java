package hilos_1;

/**
 * 
 * @author García García José Ángel
 */
public class PruebabaHilo1 {
    public static void main(String[] args) {
        Hilo1 h1 = new Hilo1();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(h1);
            t1.start();
        }
       System.exit(0);
    }
    
}
