/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package misComponentes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class JCTable extends JPanel{
   
    private DefaultTableModel dtm;
    private  final JTable tabla;
    
    public JCTable(){ 
        Object[][] datos = {{"Dato 1","Dato 3"},{"Dato 2","Dato 4"}};
        String[] campos = {"campo 1","campo 2"};
        dtm = new DefaultTableModel(datos,campos);
        tabla = new JTable(dtm);
        tabla.setPreferredSize(new Dimension(50, 20));
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
        updateUI();
    }
    
    public JCTable(String[] txtCampos,Object[][] datos){
        DefaultTableModel dtm = new DefaultTableModel(datos,txtCampos);
        tabla = new JTable(dtm);
        tabla.setPreferredSize(new Dimension(400, 50));
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
        updateUI();
    }
    
    public JTable getTabla(){
        return tabla;
    }
}
