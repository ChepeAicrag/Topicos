/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testcomponente;

import javax.swing.JFrame;
import misComponentes.Formulario;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestFormulario extends JFrame{
    public TestFormulario(){
        Formulario f = new Formulario();
    }
    
    public static void main(String[] args) {
        new TestFormulario();
    }
}
