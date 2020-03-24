/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barraherramientas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BarraHerramienta2 extends JFrame{
    public static void main(String[] args) {
        new BarraHerramienta2();
    }
    
    public BarraHerramienta2(){
        SpringLayout lm = new SpringLayout();
        JPanel p = new JPanel(lm);
        BarraHerramienta b = new BarraHerramienta();
        p.add(b);
        add(p);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
