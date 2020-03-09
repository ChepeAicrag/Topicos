/*
 * To change this license header, choose License Headers in Project Properties.
 */

package testcomponente;

import javax.swing.JFrame;
import misComponentes.MiBoton;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class TestComponente2 extends JFrame{
     private MiBoton t;
    public TestComponente2(){
        setVisible(true);
        t = new MiBoton("Hola");
        add(t);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    public static void main(String[] args) {
        new TestComponente2();
    }
   
}
