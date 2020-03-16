/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testcomponente;

import javax.swing.JFrame;
import misComponentes.JCTable;
/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class TestComponente4 extends JFrame{
    public TestComponente4(){
       String[] campos = {"Nombre","Apellido"};
       String[][] datos = {new String[]{"Juan","Marlen"},new String[]{"Garcia","Gutierrez"}};
       JCTable t = new JCTable(campos,datos);
        add(t);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    
    public static void main(String[] args) {
          new TestComponente4();
    }
}
