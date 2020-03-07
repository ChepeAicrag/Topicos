/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoprueba;

import com_grafico.Grafico;
import javax.swing.JFrame;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class prueba extends JFrame{
    public prueba(){
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        String[] tLeyenda = {"Leyenda de barra 1 ","Leyenda de barra 2 ",
                        "Leyenda de barra 3 ","Leyenda de barra 4 "};
        Grafico g = new Grafico("Muestra con 2 valores", tLeyenda);
        add(g);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    
    public static void main(String[] args) {
        prueba b = new prueba();
    }
}
