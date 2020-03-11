/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package misComponentes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class JCInput extends JPanel{
    private JComponent jinput;
    
    public JCInput(){
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Nombre"),c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        add(jinput = new JTextField("Tipo JTextField"),c);
        setVisible(true);
        updateUI();
    }
    
    public JCInput(String nombre, String tipoComponente){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel(nombre),c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        if(tipoComponente.equals("JTextField")){
            add(jinput = new JTextField(nombre),c);
        }else if(tipoComponente.equals("JSpinner")){
            add(jinput = new JSpinner(),c);
        }else if(tipoComponente.equals("JList")){
            add(jinput = new JList(),c);
        }else{
            add(jinput = new JLabel(" tipo indefinido"),c);
        }
        setVisible(true);
        updateUI();
    }
}
