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
public class DatosCopiar {

    private char[] datosOrigen;
    private char[] datosCopiados;
    private int ili; // indice de lectura izquierdo
    private int ild; // indice de lectura derecho
    private int iei; // indice de escritura izquierdo
    private int ied; // indice de escritura derecha
    private boolean parar = false; 
    
    public DatosCopiar(char[] datos){
        datosOrigen = datos;
        ili = iei = 0;
        ild = ied = datos.length - 1;
        datosCopiados = new char[datos.length];
    }
    
    public synchronized void copiari(){
        // Copia de derecha a izquierda
        if (ili + 1 <= ild && ili < datosOrigen.length && iei + 1 <= ied && !parar) {
            datosCopiados[iei++] = datosOrigen[ili++];
        }else{
            datosCopiados[iei++] = datosOrigen[ili++];
            parar = true;
        }
    }
    
    public synchronized void copiard(){
        // Copia de izquierda a derecha
        if(ild - 1 >= ili && ild > 0 && ied - 1 >= iei && !parar){
            datosCopiados[ied--] = datosOrigen[ild--];
        }else{
            datosCopiados[ied--] = datosOrigen[ild--];
            parar = true;
        }
    }
    
    public synchronized void imprimir(){
        System.out.println("\n Destino ");
        for(char c : datosCopiados)
            System.out.printf(c + ",");
    }
    
    public synchronized void imprimirOriginales(){
        System.out.println("\n Datos Originales ");
        for(char c : datosOrigen)
            System.out.printf(c + ",");
    }
    
    public boolean parar(){
        return parar;
    }
    
    public char[] datosCopiados(){
        return datosCopiados;
    }
}
