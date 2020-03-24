/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barraherramientas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestMultiple extends JFrame implements ActionListener,MouseListener{
      public static void main(String[] args) {
       new TestMultiple();
    }
    
    public TestMultiple(){
        SpringLayout s = new SpringLayout();
        JPanel p = new JPanel(s);
        BarraHerramienta tes = vector();
        tes.conectarControlador(this);
        setSize(500, 500);
        p.add(tes);
        s.putConstraint(SpringLayout.NORTH, tes, 10,SpringLayout.NORTH,p);
        s.putConstraint(SpringLayout.WEST, tes, 12,SpringLayout.WEST,p);
       s.putConstraint(SpringLayout.EAST, tes,-12, SpringLayout.EAST,p);
        add(p);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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
        b.setBorder(new LineBorder(Color.BLACK, 2));    
    }

    @Override
    public void mouseExited(MouseEvent me) {
         JButton b = (JButton) me.getSource();
        b.setOpaque(true);
        b.setBorder(new LineBorder(Color.yellow, 2));
       
    }
}
