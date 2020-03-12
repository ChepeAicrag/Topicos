/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package misComponentes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class Formulario extends JFrame implements ItemListener{
    private MiBoton agregar;
    private JCInput nombre;
    private JCInput edad;
    private JCInput sexo;
    private JCTable tabla;
    private String[] txtCampos = {"Nombre","Edad","Sexo"};
    private String[] opcSexo = {"H","M"};
    private Integer[] opcEdad;
    private Object[][] datos;
    private String edadDato;
    private String sexoDato;
    public Formulario(){
        setSize(300, 300);
        add(componentes());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
      // Falta implementar
    private void setValsEdad(){
        int p = 0;
        opcEdad = new Integer[84];
        for (int i = 17; i < 101; i++) {
            opcEdad[p] = i;
            p++;
        }
    }
    
        
    
    private JTextField txtName(){
        return ((JTextField)nombre.getDato());
    }
    
    private JComboBox txtEdad(){
        return ((JComboBox)edad.getDato());
    }
    
    private JComboBox txtSexo(){
        return ((JComboBox)sexo.getDato());
    }
    private Container componentes(){
        SpringLayout s = new SpringLayout();
        JPanel p = new JPanel(s);
        nombre = new JCInput("Nombre", "JTextField");
        ((JTextField)nombre.getDato()).setText("...");
        p.add(nombre);
        s.putConstraint(SpringLayout.NORTH, nombre, 12, SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST, nombre, 12, SpringLayout.WEST, p);
        edad = new JCInput("Edad", "JComboBox");
        setValsEdad();
        edad.ModificarJComboBox(opcEdad);
        edad.addItemListener(this);
        // Establecer evento a nuestro componente
        p.add(edad);
        s.putConstraint(SpringLayout.NORTH, edad, 12, SpringLayout.SOUTH, nombre);
        s.putConstraint(SpringLayout.WEST, edad, 12, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, edad, 20, SpringLayout.EAST, p);
        sexo = new JCInput("Sexo", "JComboBox");
        sexo.ModificarJComboBox(opcSexo);
        sexo.addItemListener(this);
        p.add(sexo);
        s.putConstraint(SpringLayout.NORTH, sexo, 12, SpringLayout.SOUTH, edad);
        s.putConstraint(SpringLayout.WEST, sexo, 12, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, sexo, 20, SpringLayout.EAST, p);
        datos = new Object[1][3];
        datos[0][0] = "";
        datos[0][1] = "";
        datos[0][2] = "";
        tabla = new JCTable(txtCampos, datos);
        p.add(tabla);
        tabla.getTabla().setPreferredSize(new Dimension(20, 30));
        s.putConstraint(SpringLayout.NORTH, tabla, 12, SpringLayout.SOUTH, sexo);
        s.putConstraint(SpringLayout.WEST, tabla, 12, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, tabla, 20, SpringLayout.EAST, p);
        agregar = new MiBoton("Agregar");
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s = "";
                s += txtName().getText() + edadDato + sexoDato;
                JOptionPane.showMessageDialog(p, s);
            }
        });
        p.add(agregar);
        s.putConstraint(SpringLayout.NORTH, agregar, 2, SpringLayout.SOUTH, tabla);
        s.putConstraint(SpringLayout.WEST, agregar, 120, SpringLayout.WEST, p);
        
        return p;
    }

    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        JComboBox cs = (JComboBox) ie.getSource();
        if(cs.getActionCommand().equals("Edad"))
        edadDato = "" + opcEdad[cs.getSelectedIndex()];
        else
        sexoDato = opcSexo[cs.getSelectedIndex()];    
    }
    
}
