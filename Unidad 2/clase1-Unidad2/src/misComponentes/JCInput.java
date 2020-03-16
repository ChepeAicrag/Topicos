/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package misComponentes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class JCInput extends JPanel implements ItemListener{
    private JComponent jinput;
    private String tipo;
    private GridBagConstraints c;
    private ItemListener i;
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
        super();
        this.tipo = tipoComponente;
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
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
        }else if(tipoComponente.equals("JComboBox")){
            add(jinput = new JComboBox(),c); 
        }else{
            add(jinput = new JLabel(" tipo indefinido"),c);
        }
        setVisible(true);
        updateUI();
    }
    
    
    
    public void ModificarJComboBox(Object[]vals){
        if(!tipo.equals("JComboBox"))
            return;
        JComboBox j = (JComboBox) jinput;
        for (int i = 0; i < vals.length; i++) {
            j.addItem(vals[i]);
        }
        
    }
     // Retorna el tipo de componente del lado derecho
    public String getTipo(){
        return tipo;
    }        
    // Retorna el componente completo
    public JComponent getDato(){
        return jinput;
    }
    
    // Retorno del layaout que tiene
    public GridBagConstraints getLayoutTabla(){
        return c;
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        
    }
    
   public void addItemListener(ItemListener i){
       this.i = i;
   }

   
}
