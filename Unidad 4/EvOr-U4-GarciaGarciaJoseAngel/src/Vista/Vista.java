

package Vista;

import Controlador.Controlador;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * 
 * @author García García José Ángel
 */
public class Vista extends JFrame{
    public JLabel etqEmpleados,etqCajas;
    public JComboBox listaEmpleados,listaCajas;
    public JButton abrir,cerrar;
    public JTable tablaCajas;
    public DefaultTableModel dtm;//Modelo de la tabla, el cual es el predeterminado
    private JScrollPane scroll;
    public JTableHeader hTab;
    public Vista(){
        setSize(500,500);
        add(principal());
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public JPanel principal(){
        SpringLayout s = new SpringLayout();
        JPanel p = new JPanel(s);
        etqEmpleados = new JLabel("Empleados Disponibles");
        etqCajas = new JLabel("Cajas disponibles");
        
        listaEmpleados = new JComboBox();
        listaEmpleados.setActionCommand("listaEmpleados");
        listaCajas = new JComboBox();
        scroll = new JScrollPane();
        listaCajas.setActionCommand("listaCajas");
        tablaCajas = new JTable();
        tablaCajas.setVisible(false);
        hTab = tablaCajas.getTableHeader();
        hTab.setVisible(false);
        scroll.setViewportView(tablaCajas);
        abrir = new JButton("Abrir");
        abrir.setActionCommand("abrir");
        cerrar = new JButton("Cerrar");
        cerrar.setActionCommand("cerrar");
        cerrar.setVisible(false);
        p.add(etqEmpleados);
        s.putConstraint(SpringLayout.NORTH,etqEmpleados,12,SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST,etqEmpleados,60,SpringLayout.WEST, p);
        p.add(etqCajas);
        s.putConstraint(SpringLayout.NORTH,etqCajas,12,SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST,etqCajas,120,SpringLayout.EAST, etqEmpleados);
        p.add(listaEmpleados);
        s.putConstraint(SpringLayout.NORTH,listaEmpleados,12,SpringLayout.SOUTH,etqEmpleados);
        s.putConstraint(SpringLayout.WEST,listaEmpleados,100,SpringLayout.WEST, p);
        p.add(listaCajas);
        s.putConstraint(SpringLayout.NORTH,listaCajas,12,SpringLayout.SOUTH,etqCajas);
        s.putConstraint(SpringLayout.WEST,listaCajas,220,SpringLayout.EAST, listaEmpleados);
        p.add(abrir);
        s.putConstraint(SpringLayout.NORTH,abrir,70,SpringLayout.SOUTH,etqCajas);
        s.putConstraint(SpringLayout.WEST,abrir,310,SpringLayout.WEST, p);
        p.add(cerrar);
        s.putConstraint(SpringLayout.NORTH,cerrar,70,SpringLayout.SOUTH,etqCajas);
        s.putConstraint(SpringLayout.WEST,cerrar,12,SpringLayout.EAST,abrir);
        p.add(hTab);
        s.putConstraint(SpringLayout.NORTH,hTab,20,SpringLayout.SOUTH,abrir);
        s.putConstraint(SpringLayout.WEST,hTab,12,SpringLayout.WEST,p);
        s.putConstraint(SpringLayout.EAST,hTab,-12,SpringLayout.EAST,p);
        p.add(tablaCajas);
        s.putConstraint(SpringLayout.NORTH,tablaCajas,0,SpringLayout.SOUTH,hTab);
        s.putConstraint(SpringLayout.WEST,tablaCajas,12,SpringLayout.WEST,p);
        s.putConstraint(SpringLayout.EAST,tablaCajas,-12,SpringLayout.EAST,p);
        s.putConstraint(SpringLayout.SOUTH,tablaCajas,-12,SpringLayout.SOUTH,p);
        
        
        return p;
    }
    public void conectarControlador(Controlador c){
        listaCajas.addActionListener(c);
        listaEmpleados.addActionListener(c);
        abrir.addActionListener(c);
        cerrar.addActionListener(c);
        listaEmpleados.addFocusListener(c);
        listaCajas.addFocusListener(c);
    }

}

