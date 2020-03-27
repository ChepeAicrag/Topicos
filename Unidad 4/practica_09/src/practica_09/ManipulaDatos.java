package practica_09;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * 
 * @author Garcia Garcia Jose Angel
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
        setSize(550,400);
        Container base = getContentPane();
        base.setLayout(new BorderLayout());
        JTabbedPane panelPrincipal = new JTabbedPane();
        JPanel panelPersona = new JPanel(new BorderLayout());
        JPanel panelMedidas = new JPanel(new BorderLayout());
        JPanel datosN = new JPanel();
        SpringLayout s = new SpringLayout();
        JPanel datosC = new JPanel(s);
        JLabel titulo = new JLabel("Manipulacion de datos de personas");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 18));
        datosN.add(titulo);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        JPanel fcp = formarCamposPersona();
        datosC.add(fcp);
        s.putConstraint(SpringLayout.NORTH, fcp, 12, SpringLayout.NORTH, datosC);
        s.putConstraint(SpringLayout.WEST, fcp, 80, SpringLayout.WEST, datosC);
        s.putConstraint(SpringLayout.SOUTH, fcp, -5, SpringLayout.SOUTH, datosC);
        s.putConstraint(SpringLayout.EAST, fcp, -70, SpringLayout.EAST, datosC);
        panelPersona.add(titulo,BorderLayout.NORTH);
        panelPersona.add(datosC,BorderLayout.CENTER);
        panelPersona.add(formarPanelResultados(),BorderLayout.SOUTH);
        panelMedidas.add(formarCamposMedidas(),BorderLayout.CENTER);
        panelMedidas.add(formarPanelMedidas(),BorderLayout.SOUTH);
        base.add(panelPrincipal);
        panelPrincipal.add(panelPersona);
        panelPrincipal.add(panelMedidas);
        panelPrincipal.setTitleAt(0, "Personas");
        panelPrincipal.setTitleAt(1, "Medidas");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private JPanel formarCamposPersona() {
        SpringLayout s = new SpringLayout();
        JPanel p = new  JPanel(s);
        p.setBorder(new TitledBorder("Proporciona los datos"));
        JLabel etqName = new JLabel("Nombre:");
        nombre = new JTextField(DA_NOMBRE,15);
        JLabel etqFecha = new JLabel("Fecha Nacimiento : ");
        Date today = new Date(1999, 00, 01);
        SpinnerModel sp = new SpinnerDateModel(today, null, null, Calendar.MONTH);
        fechaNac = new JSpinner(sp);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaNac, "dd/MM/yy  ");
        fechaNac.setEditor(editor);
        JLabel etqAños = new JLabel("Años: ");
        fechaNac.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
               int edad = calcular((java.util.Date) fechaNac.getValue());
               if(edad >= MIN_EDAD && edad <= MAX_EDAD)
                  etqAños.setText(" Años: " + edad);
               else
                   fechaNac.setValue(new Date(1999, 00, 01));
            }
            public int calcular(java.util.Date fechaNac) {
                Date today = new Date(Calendar.getInstance().getTimeInMillis());
                int years = today.getYear() - fechaNac.getYear();
                int months = today.getMonth() - fechaNac.getMonth();
                int days = today.getDay() - fechaNac.getDay();
                if(months < 0 || (months == 0 && days < 0))
                    years--;
                return years;
            }
        });
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
        insertaPer.setActionCommand("bInsertar");
        insertaPer.addActionListener(new AdmoAccion());
        limpiar = new JButton("Inicia valores");
        limpiar.setActionCommand("bLimpiar");
        limpiar.addActionListener(new AdmoAccion());
        eliminar = new JButton("Eliminar Reg. Seleccionado");
        eliminar.setActionCommand("bEliminar");
        eliminar.addActionListener(new AdmoAccion());
        agregaMed = new JButton("Agregar Medidas");
        agregaMed.setActionCommand("bAgregaMed");
        agregaMed.addActionListener(new AdmoAccion());
        p1.add(insertaPer);
        p1.add(limpiar);
        p1.add(eliminar);
        p1.add(agregaMed);
        p.add(p1,BorderLayout.NORTH);
        p.add(tablaPersona,BorderLayout.SOUTH);
        return p;
    }

    public JPanel formarCamposMedidas(){
        SpringLayout s = new SpringLayout();
        SpringLayout s2 = new SpringLayout();
        SpringLayout s3 = new SpringLayout();
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
        JPanel p3 = new JPanel(s3);
        p3.setBorder(new TitledBorder("Selecciona la actividad"));
        List<Object[]> ob = manejoDatos.conexionConsultaActividad("SELECT * FROM CHEPE.TIPOACTIVIDAD");
        String[] obJcom = new String[ob.size()];
        for(int i = 0; i < obJcom.length; i++)
            obJcom[i] = (String) ob.get(i)[1];
        actividad = new JComboBox(obJcom);
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
        s2.putConstraint(SpringLayout.NORTH, peso, 8, SpringLayout.SOUTH, estatura);
        s2.putConstraint(SpringLayout.WEST, peso, 12, SpringLayout.EAST, etqPeso);
        p2.add(etqCin);
        s2.putConstraint(SpringLayout.NORTH, etqCin, 12, SpringLayout.SOUTH, etqPeso);
        s2.putConstraint(SpringLayout.WEST, etqCin, 12, SpringLayout.WEST, p2);
        p2.add(cintura);
        s2.putConstraint(SpringLayout.NORTH, cintura, 9, SpringLayout.SOUTH, peso);
        s2.putConstraint(SpringLayout.WEST, cintura, 12, SpringLayout.EAST, etqCin);
        p2.add(etqCad);
        s2.putConstraint(SpringLayout.NORTH, etqCad, 12, SpringLayout.SOUTH, etqCin);
        s2.putConstraint(SpringLayout.WEST, etqCad, 12, SpringLayout.WEST, p2);
        p2.add(cadera);
        s2.putConstraint(SpringLayout.NORTH, cadera, 9, SpringLayout.SOUTH, cintura);
        s2.putConstraint(SpringLayout.WEST, cadera, 12, SpringLayout.EAST, etqCad);
        p3.add(actividad);
        s3.putConstraint(SpringLayout.NORTH, actividad, 15, SpringLayout.NORTH, p3);
        s3.putConstraint(SpringLayout.SOUTH, actividad, -80, SpringLayout.SOUTH, p3);
        s3.putConstraint(SpringLayout.WEST, actividad, 15, SpringLayout.WEST, p3);
        s3.putConstraint(SpringLayout.EAST, actividad, -15, SpringLayout.EAST, p3);
        JPanel p4 = new JPanel();
        p4.setBorder(BorderFactory.createTitledBorder(""));
        JLabel etqActividad = new JLabel("-----------------");
        p4.add(etqActividad);
        p.add(p1);
        s.putConstraint(SpringLayout.NORTH, p1, 12, SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST,p1, 0,SpringLayout.WEST,p);
        s.putConstraint(SpringLayout.EAST,p1, 0,SpringLayout.EAST,p);
        p.add(p2);
        s.putConstraint(SpringLayout.NORTH, p2, 10, SpringLayout.SOUTH, p1);
        s.putConstraint(SpringLayout.WEST,p2, 0,SpringLayout.WEST,p);
        s.putConstraint(SpringLayout.EAST,p2, -250,SpringLayout.EAST,p);
        s.putConstraint(SpringLayout.SOUTH, p2, -10, SpringLayout.SOUTH, p);
        p.add(p3);
        s.putConstraint(SpringLayout.NORTH, p3, 10, SpringLayout.SOUTH, p1);
        s.putConstraint(SpringLayout.WEST,p3, 15,SpringLayout.EAST,p2);
        s.putConstraint(SpringLayout.EAST,p3, 0,SpringLayout.EAST,p);
        s.putConstraint(SpringLayout.SOUTH, p3, -100, SpringLayout.SOUTH, p);
        p.add(p4);
        s.putConstraint(SpringLayout.NORTH, p4, 5, SpringLayout.SOUTH, p3);
        s.putConstraint(SpringLayout.WEST,p4, 15,SpringLayout.EAST,p2);
        s.putConstraint(SpringLayout.EAST,p4, 0,SpringLayout.EAST,p);
        s.putConstraint(SpringLayout.SOUTH, p4, -10, SpringLayout.SOUTH, p);
        
        return p;
    }
    private JPanel formarPanelMedidas(){
        SpringLayout prin = new SpringLayout();
        JPanel principal = new JPanel();
        JPanel p_2 = new JPanel(new BorderLayout());
        JPanel p_2_1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        insertaPer = new JButton("Agregar Registro");
        limpiaMed = new JButton("Inicia valores");
        limpiaMed.setActionCommand("bLimpMed");
        limpiaMed.addActionListener(new AdmoAccion());
        eliminar = new JButton("Eliminar Reg. Seleccionado");
        modeloTablaMedidas = new ModeloTablaMedidas();
        if(modeloTablaMedidas.getRowCount() != 0)
        tablaMedidas = new JTable(modeloTablaMedidas);
        else{
        tablaMedidas = new JTable(1,1);
        }
        p_2_1.add(insertaPer);
        p_2_1.add(limpiaMed);
        p_2_1.add(eliminar);
        p_2.add(p_2_1,BorderLayout.NORTH);
        p_2.add(tablaMedidas,BorderLayout.SOUTH);
        return p_2;
    }
    
    private String nombrePer;
    private class AdmoAccion implements ActionListener{
     // Clase usada para administracion de acciones 
        @Override
        public void actionPerformed(ActionEvent ae) {
            String op = ae.getActionCommand(); 
            switch(op){
                case "bInsertar":
                    if (!validaNombre || nombre.getText() != "" && !nombre.getText().equals(DA_NOMBRE)) {
                        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
                        String vSexo = "";
                        if(hombre.isSelected())
                            vSexo = "" + hombre.getText().charAt(0);
                        else
                           vSexo = "" + mujer.getText().charAt(0);
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
                    nombre.setText("");
                    Date today = new Date(Calendar.getInstance().getTimeInMillis());
                    fechaNac = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
                    JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaNac, "dd/MM/yy        ");
                    fechaNac.setEditor(editor);
                    hombre.setSelected(false);
                    mujer.setSelected(false);
                    break;
                case "bLimpMed":
                    peso.setText("");
                    estatura.setToolTipText("");
                    cadera.setText("");
                    cintura.setText("");
                    actividad.setToolTipText("");
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
