/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barraherramientas;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import javax.swing.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestMultiple extends JFrame implements ActionListener,MouseListener{
      public static void main(String[] args) {
       new TestMultiple();
    }
    
    public TestMultiple(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(normal());
        //add(vector());
       BarraHerramienta tes = vector();
       tes.conectarControlador(this);
       add(tes);
    }
    
     public BarraHerramienta vector(){
        /*
        JButton[] botones = new JButton[5];
        for (int i = 0; i < 5; i++) {
           botones[i] = new JButton("Boton " + (i+1));
        }
        */
        String[] botones = {"Hola","Hola 2","Hola 3"};
        ImageIcon[] c = {new ImageIcon("agregar.jpg"),new ImageIcon("agregar.jpg")
                ,new ImageIcon("agregar.jpg")};
       return new BarraHerramienta(c,botones); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
             JButton b = (JButton) ae.getSource();
             String btnSe = ae.getActionCommand();
           if(btnSe.equals("boton 1"))
                JOptionPane.showMessageDialog(this, "Selecciono el btn 1");
            else
                JOptionPane.showMessageDialog(this, "Selecciono el btn " + (b.getActionCommand()));
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }
    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }   

    @Override
    public void mouseEntered(MouseEvent me) {
        JButton b = (JButton) me.getSource();
        b.setOpaque(true);
        b.setBackground(Color.GREEN);
    }

    @Override
    public void mouseExited(MouseEvent me) {
         JButton b = (JButton) me.getSource();
        b.setOpaque(true);
        b.setBackground(Color.blue);
        
    }
}
