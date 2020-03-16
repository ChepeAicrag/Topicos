/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MVC_Principal;

import Controlador.ControladorBiblioteca;
import Modelo.ModeloBiblioteca;
import Vista.VistaBiblioteca;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class PrincipalBiblioteca {
     public static void main(String[] args) {
        ModeloBiblioteca modelo = new ModeloBiblioteca("dbbiblioteca"); 
        VistaBiblioteca vista  = new VistaBiblioteca();
        ControladorBiblioteca controlador  = new ControladorBiblioteca(vista, modelo);
        vista.conectaControlador(controlador);
        } // cerrar main
}
