package Provedor_Consumidor;

import java.util.Random;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class Consumer implements Runnable{
    private Drop drop;
    public Consumer(Drop drop){
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String message = drop.take(); !message.equals("HECHO"); message = drop.take()){
            System.out.format("MENSAJE RECIBIDO : %s%n",message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (Exception e) {
            }
        }
    }
}
