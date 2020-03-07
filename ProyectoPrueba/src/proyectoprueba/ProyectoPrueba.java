/*
 * Clase prueba del componente Grafico
 */
package proyectoprueba;

import com_grafico.Grafico;
import javax.swing.JFrame;

/**
 *
 * @author Garcia Garcia Jose Angel
 */
public class ProyectoPrueba extends JFrame{

    public ProyectoPrueba(){
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        String[] tLeyenda = {"Leyenda de barra 1 ","Leyenda de barra 2 ",
                        "Leyenda de barra 3 ","Leyenda de barra 4 ","Leyenda de barra 5 "};
        Grafico g = new Grafico("Muestra con 5 valores", tLeyenda);
        int[] a = {10,30,20,15,18};
        g.setValores(a);
        add(g);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new ProyectoPrueba();
    }
    
}
