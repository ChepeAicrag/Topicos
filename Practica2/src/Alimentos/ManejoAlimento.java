package Alimentos;
/*
 * @author Garc�a Garc�a Jos� �ngel
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ManejoAlimento extends JFrame implements ActionListener,ChangeListener,ItemListener{
	private  Alimentos alimentos[];
	private final Color COLORES[] = {Color.GREEN, Color.YELLOW, Color.ORANGE, Color.WHITE, Color.MAGENTA};
    private final String Tipo_Alimento[] = {"Verduras","Frutas","Cereales","Leguminosas","Origen Animal"};
    private final int KCAL_TIPO_ALIM[] = {25,60,70,120,40};
    private JSlider racTipoAlim[]; 
    private JLabel kCalTipoAlim[];
    private JPanel pKcalTipoAlim[];
    private JButton verificar;
    private JLabel kilocalorias;
    private final String TIEMPOSDECOMIDA[] = {"Desayuno","Alumerzo","Cena"};
    private JCheckBox eleccionTiempo[];
    private DefaultListModel[] modelosListas;
    private JList tiempos[];
    private JComboBox alimento;
    private JButton aceptar; 
    private JLabel tipoAli;
    JLabel[] numAlimTiem;
    private int[] numAlimTie;
    
    public ManejoAlimento() {
	super("Practica 2");
	Container panel = getContentPane();
    JTabbedPane panelPrincipal = new JTabbedPane();
    alimentos = cargarDatos();
    panelPrincipal.addTab("Conociendo alimentos", panelConociendo());
    panelPrincipal.addTab("Eleccion de alimentos", panelAlimentos());
    panel.add(panelPrincipal);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    this.setResizable(false);
    this.setSize(new Dimension(600, 330));
    this.setLocationRelativeTo(null);
    }
	
	private Alimentos[] cargarDatos() {
		alimentos = new Alimentos[22];
		alimentos[0] = new Alimentos("Zanahoria", 0);
		alimentos[1] = new Alimentos("Lechuga", 0);
		alimentos[2] = new Alimentos("Espinaca", 0);
		alimentos[3] = new Alimentos("Acelgas", 0);
		alimentos[4] = new Alimentos("Tomate", 0);
		alimentos[5] = new Alimentos("Platano", 1);
		alimentos[6] = new Alimentos("Naranja", 1);
		alimentos[7] = new Alimentos("Pepino", 1);
		alimentos[8] = new Alimentos("Manzana", 1);
		alimentos[9] = new Alimentos("Pera", 1);
		alimentos[10] = new Alimentos("Sandia", 1);
		alimentos[11] = new Alimentos("Mango", 1);
		alimentos[12] = new Alimentos("Cereza", 1);
		alimentos[13] = new Alimentos("Pi�a", 1);
		alimentos[14] = new Alimentos("Pollo", 4);
		alimentos[15] = new Alimentos("Arroz", 2);
		alimentos[16] = new Alimentos("Uva", 1);
		alimentos[17] = new Alimentos("Ciruela", 1);
		alimentos[18] = new Alimentos("Coco", 1);
		alimentos[19] = new Alimentos("Mandarina", 1);
		alimentos[20] = new Alimentos("Toronja", 1);
		alimentos[21] = new Alimentos("Frijoles", 3);
	    return alimentos;
	}

	private JPanel panelConociendo() {
		JPanel conocer = new JPanel(new BorderLayout()); 
		JPanel panelSuperior = new JPanel(new BorderLayout());  
		JPanel panelCentro = new JPanel(new GridLayout(1, 4,10,0)); 
		JPanel panelSur = new JPanel();
		JPanel panelTitulo = new JPanel(new GridLayout(0,1,0,15));
		JPanel panelEncabezado = new JPanel(new FlowLayout()); 
		JLabel enc1 = new JLabel("CONOCIMIENTO DE LAS KILOCALORIAS APORTADAS POR RACIONES POR TIPO DE ALIMENTO");
		JLabel enc2 = new JLabel("Elige el numero de las raciones decada tipo de alimento que consideres que debes consumir");
		panelTitulo.add(enc1);
		panelTitulo.add(enc2);
		panelEncabezado.add(panelTitulo); 
		panelSuperior.add(panelEncabezado,BorderLayout.CENTER); 
		pKcalTipoAlim = new JPanel[Tipo_Alimento.length]; 
		JPanel pGpoTipoAlim = new JPanel(new GridLayout()); 
		racTipoAlim = new JSlider[Tipo_Alimento.length];
		kCalTipoAlim = new JLabel[Tipo_Alimento.length];
		verificar = new JButton("Verifica proporcion");
		verificar.addActionListener(this);
		kilocalorias = new JLabel("Total de kilocalorais : 0");
		panelSur.add(kilocalorias);
		panelSur.add(verificar);
		for(int ta = 0; ta < Tipo_Alimento.length;ta++) {
			JPanel pDatos = new JPanel(new BorderLayout());
			JLabel tit = new JLabel(Tipo_Alimento[ta]);
			tit.setHorizontalAlignment(SwingConstants.CENTER);
			pKcalTipoAlim[ta] = new JPanel();
			racTipoAlim[ta] = new JSlider();
			racTipoAlim[ta].addChangeListener(this);
			racTipoAlim[ta].setOrientation(JSlider.VERTICAL);
			racTipoAlim[ta].setPaintTicks(true);
			racTipoAlim[ta].setPaintLabels(true);
			racTipoAlim[ta].setMinimum(0);
			racTipoAlim[ta].setMaximum(10);
			racTipoAlim[ta].setValue(1);
			racTipoAlim[ta].setMajorTickSpacing(2);
			racTipoAlim[ta].setMinorTickSpacing(1);
			kCalTipoAlim[ta] = new JLabel(Tipo_Alimento[ta]);
			kCalTipoAlim[ta].setBackground(COLORES[ta]);
			kCalTipoAlim[ta].setOpaque(true);
			kCalTipoAlim[ta].setVerticalAlignment(SwingConstants.NORTH);
			kCalTipoAlim[ta].setHorizontalAlignment(SwingConstants.CENTER);
			pKcalTipoAlim[ta].setLayout(null);
			pKcalTipoAlim[ta].setPreferredSize(new Dimension(60, 0));
			pKcalTipoAlim[ta].add(kCalTipoAlim[ta]);
			pDatos.add(tit,BorderLayout.NORTH);
			pDatos.add(racTipoAlim[ta],BorderLayout.WEST);
			pDatos.add(pKcalTipoAlim[ta],BorderLayout.CENTER);
			pGpoTipoAlim.add(pDatos); 
		}
			panelCentro.add(pGpoTipoAlim);  
			conocer.add(panelSur,BorderLayout.SOUTH);
			conocer.add(panelSuperior,BorderLayout.NORTH);
			conocer.add(panelCentro,BorderLayout.CENTER);
			return conocer;

	}
		
	private JPanel panelAlimentos() {
        JPanel pAlimentos = new JPanel();
        pAlimentos.setLayout(new BorderLayout());
        JPanel panelCentro = new JPanel(); 
        JPanel panelCheck = new JPanel(); 
        panelCheck.setLayout(new GridLayout(1,0));
        panelCentro.setLayout(new BorderLayout());
        JPanel panelSeleccion = new JPanel(); 
        JLabel titulo = new JLabel("ELECCION DE ALIMENTOS Y ASIGNACION A UN TIEMPO");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        JLabel tAlimento = new JLabel("Elige Alimento ");
        tipoAli = new JLabel("");
        alimento = new JComboBox(alimentos);
        alimento.addItemListener(this);
		tipoAli.setText(Tipo_Alimento[0]); 
        JPanel panelTiempos = new JPanel();
        panelTiempos.add(new JPanel());
        panelSeleccion.add(tAlimento);
        panelSeleccion.add(alimento);
        panelSeleccion.add(tipoAli);
        panelCentro.add(panelSeleccion,BorderLayout.NORTH);
        panelCentro.add(creaPanelTiempos(),BorderLayout.CENTER);
        pAlimentos.add(titulo,BorderLayout.NORTH);
        pAlimentos.add(panelCentro,BorderLayout.CENTER);
        return pAlimentos;
	}
	
	private JPanel creaListas() {
		JPanel pListas = new JPanel();
		JPanel listas = new JPanel();
		JPanel numAlim = new JPanel();
		tiempos = new JList[TIEMPOSDECOMIDA.length];
		numAlimTiem = new JLabel[TIEMPOSDECOMIDA.length];
		modelosListas = new DefaultListModel[TIEMPOSDECOMIDA.length];
		GridLayout dList = new GridLayout(0,TIEMPOSDECOMIDA.length+1,5,0);
		pListas.setLayout(new BorderLayout());
		listas.setLayout(dList);
		numAlim.setLayout(dList);
		for (int t = 0; t < TIEMPOSDECOMIDA.length; t++) {
			modelosListas[t] = new DefaultListModel();
			tiempos[t] = new JList(modelosListas[t]);
			listas.add(new JScrollPane(tiempos[t]));
		}
		for	(int t = 0;	t < TIEMPOSDECOMIDA.length;	t++){
		     numAlimTiem[t]=  new JLabel();					
			 numAlim.add(numAlimTiem[t]);
		}
		pListas.add(listas,BorderLayout.NORTH);
		pListas.add(numAlim,BorderLayout.SOUTH);
		
		return	pListas;	
}
		

	public JPanel creaPanelTiempos() {
		JPanel tiemposAlimento = new JPanel();
		tiemposAlimento.setLayout(new BorderLayout());
		JLabel indicacion = new JLabel("Selecciona el tiempo cuado deseas consumirlo");
		indicacion.setHorizontalAlignment(JLabel.CENTER);
		tiemposAlimento.add(indicacion,BorderLayout.NORTH);
		JPanel eleccion = new JPanel();
		aceptar = new JButton("Agregar");
		aceptar.addActionListener(this);
		eleccionTiempo = new JCheckBox[TIEMPOSDECOMIDA.length+1]; 
		numAlimTie = new int[eleccionTiempo.length-1];
		eleccion.setLayout(new GridLayout(0, 4));
		for(int t = 0; t < eleccionTiempo.length-1; t++) { 
			eleccionTiempo[t] = new JCheckBox(TIEMPOSDECOMIDA[t]);
			eleccionTiempo[t].addActionListener(this);
			eleccion.add(eleccionTiempo[t]);
			numAlimTie[t] = 0;
		}
			eleccionTiempo[eleccionTiempo.length-1] = new JCheckBox("En todos");  
			eleccion.add(eleccionTiempo[eleccionTiempo.length-1]); 
			eleccionTiempo[eleccionTiempo.length-1].addActionListener(this);
	        aceptar.setBounds(445,93, 80, 20);
			tiemposAlimento.add(aceptar);
			tiemposAlimento.add(eleccion,BorderLayout.CENTER);
			tiemposAlimento.add(creaListas(),BorderLayout.SOUTH);
			return	tiemposAlimento;
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object prod = ae.getSource();
		if(prod == verificar) {
			String mensaje = "La verdura sin restriccion de cantidad\nLa fruta sin restricciones de cantidadcon variedad de colores\n"
					+ "Los creales deben ser suficientes\nLas legumbres deben ser suficientes combinadas con cereales\n"
					+ "Productos de origen animal deben ser consumidos en poca cantidad ";	
			JOptionPane.showMessageDialog(this, mensaje);
		}if(prod == eleccionTiempo[0] || prod == eleccionTiempo[1]	|| prod == eleccionTiempo[2] || prod == eleccionTiempo[3]) {
			boolean seleccion = true;
			for (int i = 0; i < eleccionTiempo.length; i++) {
				if(prod == eleccionTiempo[3]) {
					eleccionTiempo[i].setSelected(true);
				}
				seleccion = seleccion && eleccionTiempo[i].isSelected();
				eleccionTiempo[eleccionTiempo.length-1].setSelected(seleccion);
			}
		}if (prod == aceptar) {
			Alimentos aliSel = (Alimentos) alimento.getSelectedItem();
			for (int t = 0; t <eleccionTiempo.length-1; t++) { 
				if(eleccionTiempo[t].isSelected() && !modelosListas[t].contains(aliSel)){
					modelosListas[t].addElement(aliSel);
					numAlimTiem[t].setText("Num. Ali.: " + (++numAlimTie[t]));
				}
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int totalkc = 0;
		try {
		for(int ta = 0; ta < COLORES.length; ta++) {
			int h = (int)(0.5*(racTipoAlim[ta].getValue()*KCAL_TIPO_ALIM[ta]));
            int base = racTipoAlim[ta].getHeight()-racTipoAlim[ta].getValue()*KCAL_TIPO_ALIM[ta] + h; 
            kCalTipoAlim[ta].setBounds(0, base,60,h);
            kCalTipoAlim[ta].setText(""+racTipoAlim[ta].getValue()*KCAL_TIPO_ALIM[ta]+"KC");
            totalkc += racTipoAlim[ta].getValue()*KCAL_TIPO_ALIM[ta];
			}
		}catch(Exception ex) {}
		kilocalorias.setText("TotalKC : "+ totalkc + " ");
		this.repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox aliSel = (JComboBox) e.getSource();
		int t = ((Alimentos)aliSel.getSelectedItem()).getTipo();
			tipoAli.setText(Tipo_Alimento[t]);
	}
}	
