package Provedor_Consumidor;

/**
 *
 * @author Garcia Garcia Jose Angel
 */
public class Drop {
    
    // Mensaje enviado del productor al consumidor
    private String message;
    // True si el consumidor debe esperar para que el productor envie el mensaje
    // false si el productor deberia esperar para que el consumidor reciba el mensaje
    private boolean empty = true;
    
    public synchronized String take() {
        // Espera hasta que el mensaje esté disponible
        
        while (empty) {
            try {
                System.out.println("A esperar take");
                wait();
            } catch (Exception e) {
            }
        }
        // cambia el estado
        empty = true;
        System.out.println("Mensaje consumido");
        // Notifica el productor que el estatus ha cambiado
        notifyAll();
        return message;
    }
    public synchronized void put(String message){
        System.out.println(empty);
        
        while (!empty) {            
            try {
                System.out.println("Esperar a take");
                wait();
            } catch (Exception e) {
                System.out.println("Cach");
            }
        }
        empty = false;
        System.out.println("Mensaje colocado");
        this.message = message;
        // Notifica al proveedor que el estatus ha cambiado
        notifyAll();
    }
}
