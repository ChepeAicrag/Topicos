/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica_09;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ManipulaDatos extends JFrame{
    // Elementos para leer los datos
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
    private JButton insertaPer; //Activa la accion para registrar una persona
    private JButton limpiar; // Activa borrar valores de los campos
    private JButton eliminar; // Activa Elimina registro persona
    private JButton agregaMed; // Toma datos de person para medidas
    private JButton insertaMed; // Inserta registro a la tabla mediciones
    private JButton limpiaMed; // Limpia los campos de mediciones
    private JButton eliminaMed; // Elimina registro de mediciones de la persona seleccionada
    // Declara los atributos que permiten acceder y visualidar los datos de la BD
    private ManejoDatos manejoDatos;
    private ModeloTablaPersona modeloTablaPersona;
    private JTable tablaPersona;
    private ModeloTablaMedidas modeloTablaMedidas;
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
            
    public ManipulaDatos(){
        Container base = getContentPane();
        base.setLayout(new BorderLayout());
        JTabbedPane panelPrincipal = new JTabbedPane();
        JPanel panelPersona = new JPanel();
        JPanel panelMedidas = new JPanel();
        base.add(panelPrincipal);
        panelPrincipal.add(panelPersona);
        panelPrincipal.add(panelMedidas);
        panelPrincipal.setTitleAt(0, "Personas");
        panelPrincipal.setTitleAt(1, "Medidas");
        JPanel datosN = new JPanel();
        JPanel datosC = new JPanel();
        JLabel titulo = new JLabel("Manipulacion de datos de personas");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 18));
        datosN.add(titulo);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        datosC.add(formarCamposPersona(),BorderLayout.WEST);
        panelPersona.add(titulo,BorderLayout.NORTH);
        panelPersona.add(datosC,BorderLayout.CENTER);
        panelPersona.add(formarPanelResultados(),BorderLayout.SOUTH);
        panelMedidas.add(formaCamposMediciones());
    }

    private JPanel formarCamposPersona() {
        SpringLayout s = new SpringLayout();
        JPanel p = new  JPanel(s);
        JLabel etqName = new JLabel("Nombre:");
        nombre = new JTextField(DA_NOMBRE);
        JLabel etqFecha = new JLabel("Fecha Nacimiento : ");
        fechaNac = new JSpinner();
        JLabel etqAños = new JLabel("Años: ");
        JLabel etqSexo = new JLabel("Sexo : ");
        hombre = new JRadioButton("Hombre");
        mujer = new JRadioButton("Mujer");
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
        p.add(hombre);
        s.putConstraint(SpringLayout.NORTH, hombre, 7, SpringLayout.SOUTH, fechaNac);
        s.putConstraint(SpringLayout.WEST, hombre, 12, SpringLayout.EAST, etqSexo);
        p.add(mujer);
        s.putConstraint(SpringLayout.NORTH, mujer, 7, SpringLayout.SOUTH, fechaNac);
        s.putConstraint(SpringLayout.WEST, mujer, 12, SpringLayout.EAST, hombre);
        return p;
    }

    private Component formarPanelResultados() {
        manejoDatos = new ManejoDatos();
        modeloTablaPersona = new ModeloTablaPersona();
        cargarDatosPersona();
        tablaPersona = new JTable(modeloTablaPersona);
        JPanel p = new  JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        insertaPer = new JButton("Agregar registro");
        limpiar = new JButton("Inicia valores");
        eliminar = new JButton("Eliminar Reg. Seleccionado");
        agregaMed = new JButton("Agregar Medidas");
        
        p1.add(insertaPer);
        p1.add(limpiar);
        p1.add(eliminar);
        p1.add(agregaMed);
        p.add(p1,BorderLayout.NORTH);
        p.add(tablaPersona,BorderLayout.SOUTH);
        return p;
    }

    private JPanel formaCamposMediciones() {
        JPanel p = new JPanel();
        return p;
    }

    private String nombrePer;
    private class AdmoAccion implements ActionListener{
     // Clase usada para administracion de acciones 
        @Override
        public void actionPerformed(ActionEvent ae) {
            switch(ae.getActionCommand()){
                case "bInsertar":
                    if (validaNombre || nombre.getText() != "" && !nombre.getText().equals(DA_NOMBRE)) {
                        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
                        String vSexo = "";
                        if(hombre.isSelected())
                            vSexo = hombre.getText();
                        else
                           vSexo = mujer.getText();
                        String datos = "INSERT INTO CHEPE.PERSONA" + "(nombre,fechanac,sexo) values " + 
                                "('" + nombre.getText() + "','" + ff.format(fechaNac.getValue()) + "','" + vSexo + "')";
                        manejoDatos.actualizaDatos(datos);
                        cargarDatosPersona();
                        tablaPersona.updateUI();
                    }
                break;
                case "bEliminar":
                    String de = "";
                    int rs = tablaPersona.getSelectedRow();
                    if(rs > 0){
                    idPerSel = Integer.parseInt((String) tablaPersona.getValueAt(rs, 0));
                    nombrePer = (String) tablaPersona.getValueAt(rs, 1);
                    int confirmado = JOptionPane.showConfirmDialog(null, "Eliminas el registro de" + nombrePer + "?");
                    if(confirmado == JOptionPane.OK_OPTION){
                        de = "DELETE FROM CHEPE.PERSONA WHERE IDPERSONA="+idPerSel;
                        manejoDatos.actualizaDatos(de);
                        cargarDatosPersona();
                        tablaPersona.updateUI();
                    }else
                        tablaPersona.clearSelection();
                }
                    break;
                case "bAgregaMed":
                    rs = tablaPersona.getSelectedRow();
                    if(rs > 0){
                        idPerSel = Integer.parseInt((String) tablaPersona.getValueAt(rs, 0));
                        String seleccionMedPer = "SELECT FROM CHEPE.MEDICIONES WHERE IDPERSONA=" + idPerSel;
                        modeloTablaMedidas.setDatos(manejoDatos.conexionConsultaMediciones(seleccionMedPer));
                        tablaMedidas.updateUI();
                        String nps = (String) modeloTablaPersona.getValueAt(rs, 1);
                        nombrePerSel.setText("----- " + nps + "-----");
                    }
                    break;
                case "bInsertarMed":
                    if(tablaPersona.getSelectedRow() > 0){
                        Calendar fecha = Calendar.getInstance();
                        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
                        Long estauraL = ((Double)estatura.getValue()).longValue() * 100;
                        int idAct = actividad.getSelectedIndex();
                        if(peso.getText() != "" && cintura.getText() != "" && cadera.getText() != ""){
                            Integer pesoE = Integer.parseInt(peso.getText());
                            Integer cinturaE = Integer.parseInt(cintura.getText());
                            Integer caderaE = Integer.parseInt(cadera.getText());
                            System.out.println("Insercion de " + idPerSel + " Estatura " +estauraL);
                            String medidas = "INSERT INTO CHEPE.MEDICIONES" 
                                    + "(fecha,estatura,peso,cintura,cadera,idtipoact,idpersona) values('" 
                                    + fecha + "','" + estauraL + "','" + pesoE + "','" + cinturaE + "','" + caderaE +
                                    "','" + idAct + "','" + idPerSel + "')";
                            manejoDatos.actualizaDatos(medidas);
                            cargarDatosMedidas(idPerSel);
                            tablaPersona.updateUI();
                        }
                    }
                    break;
                case "bLimpiar":
                    peso.setText("");
                    estatura.setToolTipText("");
                    cadera.setText("");
                    cintura.setText("");
                    actividad.setToolTipText("");
                    nombre.setText("");
                    fechaNac.setToolTipText("");
                    hombre.setSelected(false);
                    mujer.setSelected(false);
                    break;
            }
        } 
    }
    
    public void cargarDatosPersona() {
            String ConsultaPersona = "select * from CHEPE.Persona";
            modeloTablaPersona.setDatos(manejoDatos.conexionConsultaPersona(ConsultaPersona));
    }
    
    public void cargarDatosMedidas(int idPers){
        String consultaMedidas = "SELECT FROM CHEPE.MEDICIONES WHERE IDPERSONA=" + idPers;
        modeloTablaMedidas.setDatos(manejoDatos.conexionConsultaMediciones(consultaMedidas));
    }
}
