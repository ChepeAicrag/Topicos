

package Provedor_Consumidor;


/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class Principal {
    public static void main(String[] args) {
        Drop drop = new Drop();;
        new Thread(new Produccer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
