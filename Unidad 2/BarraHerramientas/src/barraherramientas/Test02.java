/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barraherramientas;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        BarraHerramienta tes =normal();
        tes.agregarBoton(new JButton("1"));
        tes.agregarBoton(new JButton("2"));
        tes.agregarBoton(new JButton("3"));
        tes.agregarBoton(new JButton("4"));
        tes.agregarBoton(new JButton("5"));
        tes.agregarBoton(new JButton("6"));
        tes.agregarBoton(new JButton("7"));
        System.out.println(tes.maxBot()); 
        System.out.println(tes.numBot());
        tes.conectarControlador(this);
        add(tes,BorderLayout.EAST);
    }
    
    public BarraHerramienta normal(){
        return new BarraHerramienta(6);
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
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
