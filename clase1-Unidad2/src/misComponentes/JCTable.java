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
    public JCTable(String[] txtCampos,Object[][] datos){
        DefaultTableModel dtm = new DefaultTableModel(datos,txtCampos);
        final JTable tabla = new JTable(dtm);
        tabla.setPreferredSize(new Dimension(400, 50));
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
        updateUI();
    }
}
