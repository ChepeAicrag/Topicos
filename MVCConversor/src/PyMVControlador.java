
import ControladorConversor.ConversorControlador;
import ModeloConversor.ConversorMonedas;
import VistaConversor.Ventana;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Jose Angel Garcia Garcia
 */
public class PyMVControlador {
    public static void main(String[] args) {
        
        // Propiedades
        ConversorMonedas modelo = new ConversorMonedas();
        Ventana vista = new Ventana();
        ConversorControlador controlador = new ConversorControlador(vista,modelo);
        
        // Metodos
        vista.conectarControaldor(controlador);
        vista.arrancar();
    }
}
