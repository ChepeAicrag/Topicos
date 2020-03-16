/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcomponente;

import javax.swing.JFrame;
import misComponentes.JCInput;

/**
 *
 */
public class TestComponente extends JFrame{
    private JCInput t;
    
    public TestComponente(){
        setVisible(true);
        t = new JCInput("Hola", "JTextField");
        add(t);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    public static void main(String[] args) {
        new TestComponente();
    }
    
}
