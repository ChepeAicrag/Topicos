/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barraherramientas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Test02 extends JFrame implements MouseListener{
            
    public static void main(String[] args) {
       new Test02();
    }
    
    public Test02(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(normal());
        //add(vector());
       BarraHerramienta tes = vector();
       //tes.conectarControlador(this);
       add(tes);
    }
    
     public BarraHerramienta vector(){
        JButton[] botones = new JButton[5];
        for (int i = 0; i < 5; i++) {
           botones[i] = new JButton("Boton " + (i+1));
        }
       return new BarraHerramienta(botones); // Creado con un arreglo de botones
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "Hola clicked");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "Hola entré a Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "Hola entré a Relased");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "Hola entré a Entered");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "Hola entré a Exited");
    }

}
