package hilos_1;

/**
 *
 * @author García García José Ángel
 */
public class Contador {

    private int c = 0;

    public synchronized void incremento() {
        int micontador = getValor();
        micontador++;
        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
        }
        c = micontador;
    }

    public synchronized void decremento() {
        int micontador = getValor();
        micontador--;
        try {
            Thread.currentThread().sleep(500);
        } catch (Exception e) {
        }
        c = micontador;
    }

    public int getValor() {
        return c;
    }
}
