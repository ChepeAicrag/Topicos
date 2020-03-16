/*
 * Proyecto creado con la intención de usar el componente recien creado (Grafico)
 * Se aplica el diseño MVC.
 */

package proyectoaplicado;

import javax.swing.JFrame;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class MVC {
    public static void main(String[] args) {
        Vista v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(v, m);
        v.conectarControlador(c);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
