/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import practica_09.ManejoDatos;
import practica_09.ModeloTablaPersona;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Prueba extends JFrame{
    
    private JButton insertaPer; //Activa la accion para registrar una persona
    private JButton limpiar; // Activa borrar valores de los campos
    private JButton eliminar; // Activa Elimina registro persona
    private JButton agregaMed; // Toma datos de person para medidas
    private JButton insertaMed; // Inserta registro a la tabla mediciones
    private JButton limpiaMed; // Limpia los campos de mediciones
    private JButton eliminaMed; // Elimina registro de mediciones de la persona seleccionada
    //private ModeloTablaPersona modeloTablaPersona;
    private JTable tablaPersona;
    
        private JTextField nombre;
    private JSpinner fechaNac;
    private JSpinner estatura;
    private JRadioButton hombre;
    private JRadioButton mujer;
    private JTextField peso;
    private JTextField cintura;
    private JTextField cadera;
    private JComboBox actividad;
   // Elementos para el control de acciones
    private ManejoDatos manejoDatos;
    private ModeloTablaPersona modeloTablaPersona;
    private JTable tablaMedidas;
    private int idPerSel; // id de persona seleccionada
    private JLabel nombrePerSel; // Despliega el nombre de persona seleccioanda
    // Declaracion de los datos que permiten contorlar la ediccion y validacion de algunos datos
    private final int MIN_EDAD = 20; // Edad minima
    private final int MAX_EDAD = 65; // Edad maxima
    private final double MIN_ESTATURA = 1.40; // Estatura minima
    private final double MAX_ESTATURA = 1.95; // Estatura maxima
    private final String DA_NOMBRE = "Da tu nombre"; // Titulo predefinido agregar medida en el campo nombre
    private final String DA_PES = "tu peso ?"; // Titulo predeagregaMEdido en el campo peso
    private boolean validaNombre = false; // Indicacion de validacion de su nombre
      
    public static void main(String[] args) {
        new Prueba();
    }
    
    public Prueba(){
        //add(formarCamposPersona());
        //add(formarPanelResultados());
        add(formaCamposMediciones());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private JPanel formaCamposMediciones() {
        SpringLayout s = new SpringLayout();
        SpringLayout s2 = new SpringLayout();
        JPanel p = new JPanel(s); // Principal
        JPanel p1 = new JPanel();
        JLabel etq = new JLabel("Manipulacion de datos de mediciones para :");
        nombrePerSel = new JLabel("xd");
        p1.add(etq,BorderLayout.NORTH);
        p1.add(nombrePerSel,BorderLayout.SOUTH);
        JPanel p2 = new JPanel(s2);
        p2.setBorder(new TitledBorder("Proporciona los datos"));
        JLabel etqEst = new JLabel("Estatura (mts):");
        estatura = new JSpinner(new SpinnerNumberModel(MIN_ESTATURA, MIN_ESTATURA, MAX_ESTATURA, 0.01));
        JLabel etqPeso = new JLabel("Peso (kgs):");
        peso = new JTextField(3);
        JLabel etqCin = new JLabel("Cintura (cms):");
        cintura = new JTextField(3);
        JLabel etqCad = new JLabel("Cadera (cms):");
        cadera = new JTextField(3);
        p2.add(etqEst);
        s2.putConstraint(SpringLayout.NORTH, etqEst, 12, SpringLayout.NORTH, p2);
        s2.putConstraint(SpringLayout.WEST, etqEst, 12, SpringLayout.WEST, p2);
        p2.add(estatura);
        s2.putConstraint(SpringLayout.NORTH, estatura, 12, SpringLayout.NORTH, p2);
        s2.putConstraint(SpringLayout.WEST, estatura, 12, SpringLayout.EAST, etqEst);
        p2.add(etqPeso);
        s2.putConstraint(SpringLayout.NORTH, etqPeso, 12, SpringLayout.SOUTH, etqEst);
        s2.putConstraint(SpringLayout.WEST, etqPeso, 12, SpringLayout.WEST, p2);
        p2.add(peso);
        s2.putConstraint(SpringLayout.NORTH, peso, 12, SpringLayout.SOUTH, estatura);
        s2.putConstraint(SpringLayout.WEST, peso, 12, SpringLayout.EAST, etqPeso);
        p2.add(etqCin);
        s2.putConstraint(SpringLayout.NORTH, etqCin, 12, SpringLayout.SOUTH, etqPeso);
        s2.putConstraint(SpringLayout.WEST, etqCin, 12, SpringLayout.WEST, p2);
        p2.add(cintura);
        s2.putConstraint(SpringLayout.NORTH, cintura, 12, SpringLayout.SOUTH, peso);
        s2.putConstraint(SpringLayout.WEST, cintura, 12, SpringLayout.EAST, etqCin);
        p2.add(etqCad);
        s2.putConstraint(SpringLayout.NORTH, etqCad, 12, SpringLayout.SOUTH, etqCin);
        s2.putConstraint(SpringLayout.WEST, etqCad, 12, SpringLayout.WEST, p2);
        p2.add(cadera);
        s2.putConstraint(SpringLayout.NORTH, cadera, 12, SpringLayout.SOUTH, cintura);
        s2.putConstraint(SpringLayout.WEST, cadera, 12, SpringLayout.EAST, etqCad);
        //List<Object[]> ob = manejoDatos.conexionConsultaActividad("SELECT NOMBRE FROM CHEPE.TIPOACTIVIDAD");
        String ob [] = {"Hola 1","Hola 2","Hola 3"};
        JPanel p3 = new JPanel(new BorderLayout());
        p3.setBorder(new TitledBorder("Selecciona la actividad"));
        actividad = new JComboBox(ob);
        p3.add(actividad,BorderLayout.CENTER);
        JPanel p4 = new JPanel();
        p4.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        JLabel etqActividad = new JLabel("-----------------");
        p4.add(etqActividad);
        p.add(p1);
        s.putConstraint(SpringLayout.NORTH, p1, 12, SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST,p1, 0,SpringLayout.WEST,p);
        s.putConstraint(SpringLayout.EAST,p1, 0,SpringLayout.EAST,p);
        p.add(p2);
        s.putConstraint(SpringLayout.NORTH, p2, 10, SpringLayout.SOUTH, p1);
        s.putConstraint(SpringLayout.WEST,p2, 0,SpringLayout.WEST,p);
        p.add(p3);
        s.putConstraint(SpringLayout.NORTH, p3, 10, SpringLayout.SOUTH, p1);
        s.putConstraint(SpringLayout.WEST,p3, 15,SpringLayout.EAST,p2);
        s.putConstraint(SpringLayout.EAST,p3, 0,SpringLayout.EAST,p);
        p.add(p4);
        s.putConstraint(SpringLayout.NORTH, p4, 5, SpringLayout.SOUTH, p3);
        s.putConstraint(SpringLayout.WEST,p4, 15,SpringLayout.EAST,p2);
        s.putConstraint(SpringLayout.EAST,p4, 0,SpringLayout.EAST,p);
        
        return p;
    }
    
    private JPanel formarPanelResultados() {
        //SpringLayout s = new SpringLayout();
        JPanel p = new  JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        insertaPer = new JButton("Agregar registro");
        limpiar = new JButton("Inicia valores");
        eliminar = new JButton("Eliminar Reg. Seleccionado");
        agregaMed = new JButton("Agregar Medidas");
        tablaPersona = new JTable(12, 5);
        p1.add(insertaPer);
        p1.add(limpiar);
        p1.add(eliminar);
        p1.add(agregaMed);
        p.add(p1,BorderLayout.NORTH);
        p.add(tablaPersona,BorderLayout.SOUTH);
        return p;
    }
    
    
    
     private JPanel formarCamposPersona() {
        SpringLayout s = new SpringLayout();
        JPanel p = new  JPanel(s);
        p.setBorder(BorderFactory.createTitledBorder("Proporciona datos"));
        JLabel etqName = new JLabel("Nombre:");
        JTextField nombre = new JTextField("Da tu nombre",10);
        JLabel etqFecha = new JLabel("Fecha Nacimiento : ");
        Date today = new Date(Calendar.getInstance().getTimeInMillis());
        JSpinner fechaNac = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaNac, "dd/MM/yy");
        fechaNac.setEditor(editor);
        JLabel etqAños = new JLabel("Años: ");
        JLabel etqSexo = new JLabel("Sexo : ");
        JRadioButton h = new JRadioButton("Hombre");
        JRadioButton m = new JRadioButton("Mujer");
        p.add(etqName);
        s.putConstraint(SpringLayout.NORTH, etqName, 12, SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST, etqName, 12, SpringLayout.WEST, p);
        p.add(nombre);
        s.putConstraint(SpringLayout.NORTH, nombre, 12, SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST, nombre, 12, SpringLayout.EAST, etqName);
        p.add(etqFecha);
        s.putConstraint(SpringLayout.NORTH, etqFecha, 12, SpringLayout.SOUTH, etqName);
        s.putConstraint(SpringLayout.WEST, etqFecha, 12, SpringLayout.WEST, p);
        p.add(fechaNac);
        s.putConstraint(SpringLayout.NORTH, fechaNac, 12, SpringLayout.SOUTH, etqName);
        s.putConstraint(SpringLayout.WEST, fechaNac, 12, SpringLayout.EAST, etqFecha);
        p.add(etqAños);
        s.putConstraint(SpringLayout.NORTH, etqAños, 12, SpringLayout.SOUTH, etqName);
        s.putConstraint(SpringLayout.WEST, etqAños, 12, SpringLayout.EAST, fechaNac);
        p.add(etqSexo);
        s.putConstraint(SpringLayout.NORTH, etqSexo, 12, SpringLayout.SOUTH, etqFecha);
        s.putConstraint(SpringLayout.WEST, etqSexo, 12, SpringLayout.WEST, p);
        p.add(h);
        s.putConstraint(SpringLayout.NORTH, h, 7, SpringLayout.SOUTH, fechaNac);
        s.putConstraint(SpringLayout.WEST, h, 12, SpringLayout.EAST, etqSexo);
        p.add(m);
        s.putConstraint(SpringLayout.NORTH, m, 7, SpringLayout.SOUTH, fechaNac);
        s.putConstraint(SpringLayout.WEST, m, 12, SpringLayout.EAST, h);
        return p;
    }
}
