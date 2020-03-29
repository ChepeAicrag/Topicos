package practica_09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Garcia Garcia Jose Angel
 */
public class ManipulaDatos extends JFrame {

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

    public ManipulaDatos() {
        setSize(560, 400);
        Container base = getContentPane();
        base.setLayout(new BorderLayout());
        base.add(principal());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private JTabbedPane principal() {
        JTabbedPane panelPrincipal = new JTabbedPane();
        SpringLayout sM = new SpringLayout();
        SpringLayout s = new SpringLayout();
        JPanel panelPersona = new JPanel(s);
        JPanel panelMedidas = new JPanel(sM);

        //JPanel datosC = new JPanel(s);
        JLabel titulo = new JLabel("Manipulacion de datos de personas");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 18));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelPersona.add(titulo);
        s.putConstraint(SpringLayout.NORTH, titulo, 0, SpringLayout.NORTH, panelPersona);
        s.putConstraint(SpringLayout.WEST, titulo, 70, SpringLayout.WEST, panelPersona);
        s.putConstraint(SpringLayout.EAST, titulo, -70, SpringLayout.EAST, panelPersona);
        JPanel fcp = formarCamposPersona();
        panelPersona.add(fcp);
        s.putConstraint(SpringLayout.NORTH, fcp, 10, SpringLayout.SOUTH, titulo);
        s.putConstraint(SpringLayout.WEST, fcp, 80, SpringLayout.WEST, panelPersona);
        s.putConstraint(SpringLayout.SOUTH, fcp, -160, SpringLayout.SOUTH, panelPersona);
        s.putConstraint(SpringLayout.EAST, fcp, -70, SpringLayout.EAST, panelPersona);
        JPanel frP = formarPanelResultados();
        panelPersona.add(frP);
        s.putConstraint(SpringLayout.NORTH, frP, 8, SpringLayout.SOUTH, fcp);
        s.putConstraint(SpringLayout.WEST, frP, 5, SpringLayout.WEST, panelPersona);
        s.putConstraint(SpringLayout.SOUTH, frP, 0, SpringLayout.SOUTH, panelPersona);
        s.putConstraint(SpringLayout.EAST, frP, -5, SpringLayout.EAST, panelPersona);
        JPanel fCM = formarCamposMedidas();
        JPanel fPM = formarPanelMedidas();
        panelMedidas.add(fCM);
        sM.putConstraint(SpringLayout.NORTH, fCM, 0, SpringLayout.NORTH, panelMedidas);
        sM.putConstraint(SpringLayout.WEST, fCM, 0, SpringLayout.WEST, panelMedidas);
        sM.putConstraint(SpringLayout.EAST, fCM, 0, SpringLayout.EAST, panelMedidas);
        sM.putConstraint(SpringLayout.SOUTH, fCM, -150, SpringLayout.SOUTH, panelMedidas);
        panelMedidas.add(fPM);
        sM.putConstraint(SpringLayout.NORTH, fPM, 5, SpringLayout.SOUTH, fCM);
        sM.putConstraint(SpringLayout.WEST, fPM, 0, SpringLayout.WEST, panelMedidas);
        sM.putConstraint(SpringLayout.EAST, fPM, 0, SpringLayout.EAST, panelMedidas);
        sM.putConstraint(SpringLayout.SOUTH, fPM, 0, SpringLayout.SOUTH, panelMedidas);
        panelPrincipal.add(panelPersona);
        panelPrincipal.add(panelMedidas);
        panelPrincipal.setTitleAt(0, "Personas");
        panelPrincipal.setTitleAt(1, "Medidas");
        return panelPrincipal;
    }

    private JPanel formarCamposPersona() {
        SpringLayout s = new SpringLayout();
        JPanel p = new JPanel(s);
        p.setBorder(new TitledBorder("Proporciona los datos"));
        JLabel etqName = new JLabel("Nombre:");
        nombre = new JTextField(DA_NOMBRE, 15);
        JLabel etqFecha = new JLabel("Fecha Nacimiento : ");
        Date today = new Date(1999, 00, 01);
        SpinnerModel sp = new SpinnerDateModel(today, null, null, Calendar.MONTH);
        fechaNac = new JSpinner(sp);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaNac, "dd/MM/yy  ");
        fechaNac.setEditor(editor);
        JLabel etqAños = new JLabel("Años: " + 20);
        fechaNac.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                int edad = calcular((java.util.Date) fechaNac.getValue());
                if (edad >= MIN_EDAD && edad <= MAX_EDAD) {
                    etqAños.setText(" Años: " + edad);
                } else {
                    fechaNac.setValue(new Date(1999, 00, 01));
                }
            }

            public int calcular(java.util.Date fechaNac) {
                Date today = new Date(Calendar.getInstance().getTimeInMillis());
                int years = today.getYear() - fechaNac.getYear();
                int months = today.getMonth() - fechaNac.getMonth();
                int days = today.getDay() - fechaNac.getDay();
                if (months < 0 || (months == 0 && days < 0)) {
                    years--;
                }
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
        s.putConstraint(SpringLayout.WEST, nombre, 75, SpringLayout.EAST, etqName);
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

    private JPanel formarPanelResultados() {
        manejoDatos = new ManejoDatos();
        modeloTablaPersona = new ModeloTablaPersona();
        cargarDatosPersona();
        tablaPersona = new JTable(modeloTablaPersona);
        JTableHeader hTab = tablaPersona.getTableHeader();
        SpringLayout s = new SpringLayout();
        JPanel p = new JPanel(s);
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        AdmoAccion action = new AdmoAccion();
        insertaPer = new JButton("Agregar registro");
        insertaPer.setActionCommand("bInsertar");
        insertaPer.addActionListener(action);
        limpiar = new JButton("Inicia valores");
        limpiar.setActionCommand("bLimpiar");
        limpiar.addActionListener(action);
        eliminar = new JButton("Eliminar Reg. Sel.");
        eliminar.setActionCommand("bEliminar");
        eliminar.addActionListener(action);
        agregaMed = new JButton("Agregar Medidas");
        agregaMed.setActionCommand("bAgregaMed");
        agregaMed.addActionListener(action);
        p1.add(insertaPer);
        p1.add(limpiar);
        p1.add(eliminar);
        p1.add(agregaMed);
        p.add(p1);
        s.putConstraint(SpringLayout.NORTH, p1, 0, SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST, p1, 9, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, p1, -9, SpringLayout.EAST, p);
        p.add(hTab);
        s.putConstraint(SpringLayout.NORTH, hTab, 5, SpringLayout.SOUTH, p1);
        s.putConstraint(SpringLayout.WEST, hTab, 10, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, hTab, -10, SpringLayout.EAST, p);
        p.add(tablaPersona);
        s.putConstraint(SpringLayout.NORTH, tablaPersona, 0, SpringLayout.SOUTH,hTab );
        s.putConstraint(SpringLayout.WEST, tablaPersona, 10, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, tablaPersona, -10, SpringLayout.EAST, p);
        s.putConstraint(SpringLayout.SOUTH, tablaPersona, 0, SpringLayout.SOUTH, p);
        return p;
    }

    public JPanel formarCamposMedidas() {
        SpringLayout s = new SpringLayout();
        SpringLayout s2 = new SpringLayout();
        SpringLayout s3 = new SpringLayout();
        JPanel p = new JPanel(s); // Principal
        JPanel p1 = new JPanel(new BorderLayout());
        JLabel etq = new JLabel(String.format("%95s", "Manipulacion de datos de mediciones para :"));
        nombrePerSel = new JLabel(String.format("%90s", ""));
        p1.add(etq, BorderLayout.NORTH);
        p1.add(nombrePerSel, BorderLayout.SOUTH);
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
        String[] desActi = new String[ob.size()];
        for (int i = 0; i < ob.size(); i++) {
            obJcom[i] = (String) ob.get(i)[1];
            desActi[i] = (String) ob.get(i)[2];
        }
        actividad = new JComboBox(obJcom);
        p2.add(etqEst);
        s2.putConstraint(SpringLayout.NORTH, etqEst, 12, SpringLayout.NORTH, p2);
        s2.putConstraint(SpringLayout.WEST, etqEst, 12, SpringLayout.WEST, p2);
        p2.add(estatura);
        s2.putConstraint(SpringLayout.NORTH, estatura, 10, SpringLayout.NORTH, p2);
        s2.putConstraint(SpringLayout.WEST, estatura, 8, SpringLayout.EAST, etqEst);
        p2.add(etqPeso);
        s2.putConstraint(SpringLayout.NORTH, etqPeso, 12, SpringLayout.SOUTH, etqEst);
        s2.putConstraint(SpringLayout.WEST, etqPeso, 12, SpringLayout.WEST, p2);
        p2.add(peso);
        s2.putConstraint(SpringLayout.NORTH, peso, 7, SpringLayout.SOUTH, estatura);
        s2.putConstraint(SpringLayout.WEST, peso, 28, SpringLayout.EAST, etqPeso);
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
        s3.putConstraint(SpringLayout.NORTH, actividad, 5, SpringLayout.NORTH, p3);
        s3.putConstraint(SpringLayout.SOUTH, actividad, -15, SpringLayout.SOUTH, p3);
        s3.putConstraint(SpringLayout.WEST, actividad, 50, SpringLayout.WEST, p3);
        s3.putConstraint(SpringLayout.EAST, actividad, -50, SpringLayout.EAST, p3);
        JPanel p4 = new JPanel(new BorderLayout());
        p4.setBorder(BorderFactory.createTitledBorder(""));
        JLabel etqActividad = new JLabel(desActi[0]);
        ImageIcon icon_1 = new ImageIcon(getClass().getResource("/imagenes/sedentarismo.jpg"));
        ImageIcon icon = new ImageIcon(icon_1.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
        JLabel img = new JLabel(icon);
        p4.add(img, BorderLayout.CENTER);
        p4.updateUI();
        actividad.addActionListener(new ActionListener() {
            JLabel img2, img3, img4, img5;

            @Override
            public void actionPerformed(ActionEvent ae) {
                int pos = actividad.getSelectedIndex();
                etqActividad.setText(desActi[pos]);
                try {
                    p4.remove(img);
                    p4.remove(img2);
                    p4.remove(img3);
                    p4.remove(img4);
                    p4.remove(img5);
                } catch (Exception e) {
                    p4.removeAll();
                    p4.add(etqActividad, BorderLayout.NORTH);
                } finally {
                    switch (pos) {
                        case 0:
                            ImageIcon icon_2 = new ImageIcon(getClass().getResource("/imagenes/sedentarismo.jpg"));
                            ImageIcon icon2 = new ImageIcon(icon_2.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
                            img2 = new JLabel(icon2);
                            p4.add(img2, BorderLayout.CENTER);
                            break;
                        case 1:
                            icon_2 = new ImageIcon(getClass().getResource("/imagenes/lige_activa.jpeg"));
                            icon2 = new ImageIcon(icon_2.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
                            img3 = new JLabel(icon2);
                            p4.add(img3, BorderLayout.CENTER);
                            break;
                        case 2:
                            icon_2 = new ImageIcon(getClass().getResource("/imagenes/mode_activa.jpg"));
                            icon2 = new ImageIcon(icon_2.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
                            img4 = new JLabel(icon2);
                            p4.add(img4, BorderLayout.CENTER);
                            break;
                        case 3:
                            icon_2 = new ImageIcon(getClass().getResource("/imagenes/muy_activa.jpg"));
                            icon2 = new ImageIcon(icon_2.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
                            img5 = new JLabel(icon2);
                            p4.add(img5, BorderLayout.CENTER);
                            break;
                    }
                    p4.updateUI();
                }
            }
        });
        p4.add(etqActividad, BorderLayout.NORTH);
        p.add(p1);
        s.putConstraint(SpringLayout.NORTH, p1, 0, SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST, p1, 0, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, p1, 0, SpringLayout.EAST, p);
        p.add(p2);
        s.putConstraint(SpringLayout.NORTH, p2, 10, SpringLayout.SOUTH, p1);
        s.putConstraint(SpringLayout.WEST, p2, 30, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, p2, -340, SpringLayout.EAST, p);
        s.putConstraint(SpringLayout.SOUTH, p2, 0, SpringLayout.SOUTH, p);
        p.add(p3);
        s.putConstraint(SpringLayout.NORTH, p3, 10, SpringLayout.SOUTH, p1);
        s.putConstraint(SpringLayout.WEST, p3, 15, SpringLayout.EAST, p2);
        s.putConstraint(SpringLayout.EAST, p3, -40, SpringLayout.EAST, p);
        s.putConstraint(SpringLayout.SOUTH, p3, -90, SpringLayout.SOUTH, p);
        p.add(p4);
        s.putConstraint(SpringLayout.NORTH, p4, 1, SpringLayout.SOUTH, p3);
        s.putConstraint(SpringLayout.WEST, p4, 15, SpringLayout.EAST, p2);
        s.putConstraint(SpringLayout.EAST, p4, -40, SpringLayout.EAST, p);
        s.putConstraint(SpringLayout.SOUTH, p4, 0, SpringLayout.SOUTH, p);

        return p;
    }

    private JPanel formarPanelMedidas() {
        SpringLayout s = new SpringLayout();
        JPanel p = new JPanel(s);
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        insertaMed = new JButton("Agregar Registro");
        insertaMed.setActionCommand("bInsertarMed");
        insertaMed.addActionListener(new AdmoAccion());
        limpiaMed = new JButton("Inicia valores");
        limpiaMed.setActionCommand("bLimpMed");
        limpiaMed.addActionListener(new AdmoAccion());
        eliminaMed = new JButton("Eliminar Reg. Seleccionado");
        eliminaMed.setActionCommand("bEliminarMed");
        eliminaMed.addActionListener(new AdmoAccion());
        modeloTablaMedidas = new ModeloTablaMedidas();
        tablaMedidas = new JTable(modeloTablaMedidas);
        JTableHeader hTab = tablaMedidas.getTableHeader();
        p1.add(insertaMed);
        p1.add(limpiaMed);
        p1.add(eliminaMed);
        p.add(p1);
        s.putConstraint(SpringLayout.NORTH, p1, 0, SpringLayout.NORTH, p);
        s.putConstraint(SpringLayout.WEST, p1, 10, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, p1, -10, SpringLayout.EAST, p);
        p.add(hTab);
        s.putConstraint(SpringLayout.NORTH, hTab, 5, SpringLayout.SOUTH, p1);
        s.putConstraint(SpringLayout.WEST, hTab, 10, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, hTab, -10, SpringLayout.EAST, p);
        p.add(tablaMedidas);
        s.putConstraint(SpringLayout.NORTH, tablaMedidas, 0, SpringLayout.SOUTH,hTab );
        s.putConstraint(SpringLayout.WEST, tablaMedidas, 10, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.EAST, tablaMedidas, -10, SpringLayout.EAST, p);
        s.putConstraint(SpringLayout.SOUTH, tablaMedidas, 0, SpringLayout.SOUTH, p);
        return p;
    }

    private String nombrePer;

    private class AdmoAccion implements ActionListener {
        // Clase usada para administracion de acciones 

        @Override
        public void actionPerformed(ActionEvent ae) {
            String op = ae.getActionCommand();
            switch (op) {
                case "bInsertar":
                    if (nombre.getText() != "" && !nombre.getText().equals(DA_NOMBRE)) {
                        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
                        String vSexo = "";
                        if (hombre.isSelected()) {
                            vSexo = "" + hombre.getText().charAt(0);
                        } else {
                            vSexo = "" + mujer.getText().charAt(0);
                        }
                        String datos = "INSERT INTO CHEPE.PERSONA" + "(nombre,fechanac,sexo) values "
                                + "('" + nombre.getText() + "','" + ff.format(fechaNac.getValue()) + "','" + vSexo + "')";
                        manejoDatos.actualizaDatos(datos);
                        cargarDatosPersona();
                        tablaPersona.updateUI();
                    }
                    break;
                case "bEliminar":
                    String de = "";
                    int rs = tablaPersona.getSelectedRow();
                    if (rs >= 0) {
                        idPerSel = Integer.parseInt((String) tablaPersona.getValueAt(rs, 0));
                        nombrePer = (String) tablaPersona.getValueAt(rs, 1);
                        int confirmado = JOptionPane.showConfirmDialog(null, "Eliminas el registro de" + nombrePer + "?");
                        if (confirmado == JOptionPane.OK_OPTION) {
                            de = "DELETE FROM CHEPE.PERSONA WHERE IDPERSONA=" + idPerSel;
                            manejoDatos.actualizaDatos(de);
                            cargarDatosPersona();
                            tablaPersona.updateUI();
                        } else {
                            tablaPersona.clearSelection();
                        }
                    }
                    break;

                case "bEliminarMed":
                    de = "";
                    rs = tablaPersona.getSelectedRow();
                    if (rs >= 0) {
                        idPerSel = Integer.parseInt((String) tablaPersona.getValueAt(rs, 0));
                        nombrePer = (String) tablaPersona.getValueAt(rs, 1);
                        int idMed = Integer.parseInt((String) tablaMedidas.getValueAt(tablaMedidas.getSelectedRow(), 0));
                        int confirmado = JOptionPane.showConfirmDialog(null, "Eliminas el registro de" + nombrePer + "?");
                        if (confirmado == JOptionPane.OK_OPTION) {
                            de = "DELETE FROM CHEPE.MEDICIONES WHERE IDMEDIDAS=" + idMed;
                            manejoDatos.actualizaDatos(de);
                            cargarDatosMedidas(idPerSel);
                            tablaMedidas.updateUI();
                        } else {
                            tablaMedidas.updateUI();
                        }
                    }
                    break;

                case "bAgregaMed":
                    rs = tablaPersona.getSelectedRow();
                    if (rs >= 0) {
                        idPerSel = Integer.parseInt((String) tablaPersona.getValueAt(rs, 0));
                        String seleccionMedPer = "SELECT * FROM CHEPE.MEDICIONES WHERE IDPERSONA=" + idPerSel;
                        modeloTablaMedidas.setDatos(manejoDatos.conexionConsultaMediciones(seleccionMedPer));
                        tablaMedidas.updateUI();
                        String nps = (String) modeloTablaPersona.getValueAt(rs, 1);
                        nombrePerSel.setText(String.format("%90s", "----- " + nps + "-----"));
                    }
                    break;
                case "bInsertarMed":
                    if (tablaPersona.getSelectedRow() >= 0) {
                        Calendar fecha = Calendar.getInstance();
                        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
                        Long estauraL = ((Double) estatura.getValue()).longValue() * 100;
                        int idAct = actividad.getSelectedIndex() + 1;
                        if (!peso.getText().isEmpty() && !cintura.getText().isEmpty() && !cadera.getText().isEmpty()) {
                            double pesoE = Double.parseDouble(peso.getText());
                            int cinturaE = Integer.parseInt(cintura.getText());
                            int caderaE = Integer.parseInt(cadera.getText());
                            System.out.println("Insercion de " + idPerSel + " Estatura " + estauraL);
                            String medidas = "INSERT INTO CHEPE.MEDICIONES"
                                    + "(fecha,estatura,peso,cintura,cadera,idtipoact,idpersona) values('"
                                    + ff.format(fecha.getTime()) + "'," + estauraL + "," + pesoE + "," + cinturaE + "," + caderaE
                                    + "," + idAct + "," + idPerSel + ")";
                            manejoDatos.actualizaDatos(medidas);
                            cargarDatosMedidas(idPerSel);
                            tablaMedidas.updateUI();
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

    public void cargarDatosMedidas(int idPers) {
        String consultaMedidas = "SELECT * FROM CHEPE.MEDICIONES WHERE IDPERSONA=" + idPers;
        modeloTablaMedidas.setDatos(manejoDatos.conexionConsultaMediciones(consultaMedidas));
    }
}
