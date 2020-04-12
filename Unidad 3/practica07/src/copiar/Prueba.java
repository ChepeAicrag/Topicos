/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package copiar;

/**
 * 
 * @author García García José Ángel
 */
public class Prueba {
    
    public static void main(String[] args) {
        char[] datos = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P',
        'Q','R','S','T','U','V','W'};
        DatosCopiar datosCopiar = new DatosCopiar(datos);
        datosCopiar.imprimirOriginales();
        DatosMovIzq movIzq = new DatosMovIzq(datosCopiar);
        DatosMovDer movDer = new DatosMovDer(datosCopiar);
        Thread hilo1 = new Thread(movIzq);
        Thread hilo2 = new Thread(movDer);
        Thread hilo3 = new Thread(movDer);
        Thread hilo4 = new Thread(movDer);
        Thread hilo5 = new Thread(movDer);
        Thread hilo6 = new Thread(movDer);
        Thread hilo7 = new Thread(movDer);
        Thread hilo8 = new Thread(movDer);
        Thread hilo9 = new Thread(movDer);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();
        hilo9.start();
    }
}
