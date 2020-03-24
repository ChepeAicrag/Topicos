/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barraherramientas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Garcia Garcia Jose Angel
 */
public class BarraHerramientas extends JFrame implements ActionListener{

    public BarraHerramientas(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(normal());
        //add(vector());
       BarraHerramienta tes = vector();
       tes.cambiarDiseñor(new FlowLayout(FlowLayout.CENTER, 0, 0));
       tes.conectarControlador(this);
       add(tes,BorderLayout.SOUTH);      
    }
    
    
    public BarraHerramienta vector(){
        JButton[] botones = new JButton[10];
        for (int i = 0; i < 10; i++) {
           botones[i] = new JButton("Boton " + (i+1));
        }
       return new BarraHerramienta(botones); // Creado con un arreglo de botones
    }
    
    public static void main(String[] args) {
        BarraHerramientas b = new BarraHerramientas();
    }

    public void actionPerformed(ActionEvent ae) {
        JButton b = (JButton) ae.getSource();
        String btnSe = ae.getActionCommand();
           if(btnSe.equals("boton 1"))
                JOptionPane.showMessageDialog(this, "Selecciono el btn 1");
            else
                JOptionPane.showMessageDialog(this, "Selecciono el btn " + (b.getActionCommand()));
    }

   }
