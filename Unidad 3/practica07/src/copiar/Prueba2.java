/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package copiar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author García García José Ángel
 */
public class Prueba2 {
    
     public static void main(String[] args) {
        char[] datos = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P',
        'Q','R','S','T','U','V','W'};
        DatosCopiar datosCopiar = new DatosCopiar(datos);
        datosCopiar.imprimirOriginales();
        datosCopiar.imprimir();
        DatosMovIzq movIzq = new DatosMovIzq(datosCopiar);
        DatosMovDer movDer = new DatosMovDer(datosCopiar);
        Thread hilo1 = new Thread(movIzq);
        Thread hilo2 = new Thread(movDer);
         try {
             hilo1.start();
             hilo1.join();
             hilo2.start();
             hilo2.join();
         } catch (InterruptedException ex) {
             Logger.getLogger(Prueba2.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
