/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModeloConversor;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */

public class ConversorMonedas {
    private Hashtable<String,Double> tablaConversion = new Hashtable<String,Double>();
    public ConversorMonedas(){
        // Tipo de moneda y equivalencia en pesos
        insertarMoneda("PSM",1.0);
        insertarMoneda("USD", 0.052);
        insertarMoneda("JPV", 5.99);
        insertarMoneda("BIT", 0.000000);
        insertarMoneda("EUR", 0.046);
    }
    
    private void insertarMoneda(String codigo, Double tipoCambio){
        tablaConversion.put(codigo, tipoCambio);
    }
    
    private double obtenerTipoDeCambio(String codigoMoneda){
        return tablaConversion.get(codigoMoneda);
    }
    
    public Double convertir(String codDivOrigen,String codDivDestino,Double importe){
        Double pesos = importe/ obtenerTipoDeCambio(codDivOrigen);
        return pesos * obtenerTipoDeCambio(codDivDestino);
    }
    
    public Enumeration <String> obtenerCodigosDivisas(){
        return tablaConversion.keys();
    }
        
}
