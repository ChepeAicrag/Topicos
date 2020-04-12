/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package copiar;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author García García José Ángel
 */
public class DatosMovIzq implements Runnable{
    
    private DatosCopiar datos;
    
    public DatosMovIzq(DatosCopiar d){
        datos = d;
    }

    @Override
    public void run() {
        while (!datos.parar()) {            
            datos.copiari();
            System.out.println("\n D<-I");
            datos.imprimir();
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                Logger.getLogger(DatosMovDer.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    }
}
  
