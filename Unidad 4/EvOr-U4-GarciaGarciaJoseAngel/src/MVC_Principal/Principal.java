/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MVC_Principal;

import Controlador.Controlador;
import Modelo.Conexion;
import Vista.Vista;

/**
 * 
 * @author García García José Ángel
 */
public class Principal {
    public static void main(String[] args) {
        Conexion c = new Conexion("dbsupermarket");
        Vista v = new Vista();
        Controlador con = new Controlador(c, v);
        v.conectarControlador(con);
                
    }
}
