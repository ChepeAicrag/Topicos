/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorConversor;

import ModeloConversor.ConversorMonedas;
import VistaConversor.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * @author Garcia Garcia Jose Angel
 */
public class ConversorControlador implements ActionListener{
    private Ventana vista;
    private ConversorMonedas modelo;
    
    public ConversorControlador(Ventana v, ConversorMonedas m){
        this.vista = v;
        this.modelo = m;
        vista.setComboDivisas(modelo.obtenerCodigosDivisas());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // obtener los valores para operar
        Double importe = vista.obtenerImporte();
        String codDivisaOrigen = vista.obtenerDivisaOrigen();
        String codDivisaDestino = vista.obtenerDivisaDestino();
        
        // Realiza la conversion
        Double resultado = modelo.convertir(codDivisaOrigen, codDivisaDestino, importe);
        
        // Muestra ek resultado en la etiqueta resultado
        DecimalFormat df = new DecimalFormat("#,###.##");
        vista.actualiazarResultado(df.format(resultado).toString());
    }
    
    
}
