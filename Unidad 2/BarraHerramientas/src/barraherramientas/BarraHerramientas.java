/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barraherramientas;

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
       //tes.conectarControlador(this);
       add(tes);
       
    }
    
    public BarraHerramienta sinParametros(){
        BarraHerramienta b = new BarraHerramienta();
        return b;
    }
    
    public BarraHerramienta vector(){
        JButton[] botones = new JButton[10];
        for (int i = 0; i < 10; i++) {
           botones[i] = new JButton("Boton " + (i+1));
        }
       return new BarraHerramienta(botones); // Creado con un arreglo de botones
    }
    
    public BarraHerramienta normal(){
        BarraHerramienta b = new BarraHerramienta(2); // Creado con tamaño de n botones
        JButton b1 = new JButton("Hola 1");
        JButton b2 = new JButton("Hola 2");
        b.agregarBoton(b1);
        b.agregarBoton(b2);
        return b;
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
