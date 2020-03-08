/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoaplicado;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class Modelo {
    
    public Modelo(){
    
    }
    
    
    public void mostrar(Vista v){
        v.printf();
    }
    
    
    public void agregarCuadros(Vista v){
            v.agregarOpciones();
            v.bloquearTxt(false);
    }
}
