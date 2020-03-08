/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
