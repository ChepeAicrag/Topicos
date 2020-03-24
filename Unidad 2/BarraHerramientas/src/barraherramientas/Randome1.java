/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barraherramientas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Randome1 extends JFrame{
    public static void main(String[] args) {
        new Randome1();
    }
    
    public Randome1(){
        SpringLayout s = new SpringLayout();
        JPanel p = new JPanel(s);
        BarraHerramienta b = new BarraHerramienta(2);
        b.agregarBoton(new JButton("Xd"));
        b.agregarBoton("hola");
        p.add(b);
        
        s.putConstraint(SpringLayout.NORTH, b, 1,SpringLayout.NORTH,p);
        s.putConstraint(SpringLayout.WEST, b, 12,SpringLayout.WEST,p);
        s.putConstraint(SpringLayout.EAST, b,-12, SpringLayout.EAST,p);
        add(p);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
}
