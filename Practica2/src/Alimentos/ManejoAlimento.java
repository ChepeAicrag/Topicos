package Alimentos;

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
    private JSlider racTipoAlim[]; // Fija el numero de racionespor tipo de  alimento
    private JLabel kCalTipoAlim[]; // Guarda las kilocalorias por tipo de alimento
    private JPanel pKcalTipoAlim[]; // Paneles para guardar las barras a desplegar
    private JButton verificar;
    private JLabel kilocalorias; // Para mostrar el valor de las kilocalorias
    private final String TIEMPOSDECOMIDA[] = {"Desayuno","Alumerzo","Cena"};
    private JCheckBox eleccionTiempo[];
    private DefaultListModel[] modelosListas;
    private JList tiempos[];
    private JComboBox alimento;
    private JButton aceptar; // para agregar un alimento
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
    //panelPrincipal.addTab("Clasificacion de alimentos",grafico);
    panel.add(panelPrincipal);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
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
		alimentos[13] = new Alimentos("Piña", 1);
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
		JPanel conocer = new JPanel(new BorderLayout()); // Panel general
		JPanel panelSuperior = new JPanel(new BorderLayout()); // Panel para titulos 
		JPanel panelCentro = new JPanel(new GridLayout(1, 4,10,0)); // Panel para deslizador y etiqueta con grupo de alimento
		JPanel panelSur = new JPanel();
		JPanel panelTitulo = new JPanel(new GridLayout(0,1,0,15)); // Para los enc1 y enc2 
		JPanel panelEncabezado = new JPanel(new FlowLayout()); // Para el panelTitulo
		JLabel enc1 = new JLabel("CONOCIMIENTO DE LAS KILOCALORIAS APORTADAS POR RACIONES POR TIPO DE ALIMENTO");
		JLabel enc2 = new JLabel("Elige el numero de las raciones decada tipo de alimento que consideres que debes consumir");
		panelTitulo.add(enc1);
		panelTitulo.add(enc2);
		panelEncabezado.add(panelTitulo); 
		panelSuperior.add(panelEncabezado,BorderLayout.CENTER); // Siempre centrado al panel
		pKcalTipoAlim = new JPanel[Tipo_Alimento.length]; // Atributo
		JPanel pGpoTipoAlim = new JPanel(new GridLayout()); // Sirve para grupar los JSlider y lasJLabel
		racTipoAlim = new JSlider[Tipo_Alimento.length];
		kCalTipoAlim = new JLabel[Tipo_Alimento.length];
		/* Funcionando de forma correcta */
		verificar = new JButton("Verifica proporcion");
		verificar.addActionListener(this);
		kilocalorias = new JLabel("Total de kilocalorais : 0");
		panelSur.add(kilocalorias);
		panelSur.add(verificar);
		//panelSur.add(reAlimentacion);
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
			kCalTipoAlim[ta].setBackground(Color.red);
			kCalTipoAlim[ta].setOpaque(true);
			kCalTipoAlim[ta].setVerticalAlignment(SwingConstants.CENTER);
			kCalTipoAlim[ta].setHorizontalAlignment(SwingConstants.RIGHT);
			/* No entiendo como influye esta parte */
			pKcalTipoAlim[ta].setLayout(new BorderLayout());
			pKcalTipoAlim[ta].setPreferredSize(new Dimension(10, 10));
			pKcalTipoAlim[ta].add(racTipoAlim[ta],BorderLayout.CENTER);
			pDatos.add(tit,BorderLayout.NORTH);
			pDatos.add(racTipoAlim[ta],BorderLayout.WEST);
			pDatos.add(pKcalTipoAlim[ta],BorderLayout.CENTER);
			pGpoTipoAlim.add(pDatos); 
		}
			panelCentro.add(pGpoTipoAlim); // Agregando al panel central 
			conocer.add(panelSur,BorderLayout.SOUTH);
			conocer.add(panelSuperior,BorderLayout.NORTH);
			conocer.add(panelCentro,BorderLayout.CENTER);
			return conocer;

	}
		
	private JPanel panelAlimentos() {
        JPanel pAlimentos = new JPanel();
        pAlimentos.setLayout(new BorderLayout());
        JPanel panelCentro = new JPanel(); // Para la seleccion de alimentos y cauntos
        JPanel panelCheck = new JPanel(); // Para cuadros de verificacion 
        panelCheck.setLayout(new GridLayout(1,0));
        panelCentro.setLayout(new BorderLayout());
        JPanel panelSeleccion = new JPanel(); // Para la seleccionde alimentos
        JLabel titulo = new JLabel("ELECCION DE ALIMENTOS Y ASIGNACION A UN TIEMPO");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        JLabel tAlimento = new JLabel("Elige Alimento ");
//        aceptar = new JButton("Aceptar xd"); // No se está agregando
//        aceptar.addActionListener(this);
        tipoAli = new JLabel("");
        alimento = new JComboBox(alimentos);
        alimento.addItemListener(this);
		tipoAli.setText(Tipo_Alimento[0]); // Se muestra el primero
        JPanel panelTiempos = new JPanel();
        panelTiempos.add(new JPanel());
        panelSeleccion.add(tAlimento);
        panelSeleccion.add(alimento);
        panelSeleccion.add(tipoAli);
        panelCentro.add(panelSeleccion,BorderLayout.NORTH);
        panelCentro.add(creaPanelTiempos(),BorderLayout.SOUTH);
        pAlimentos.add(titulo,BorderLayout.CENTER);
        pAlimentos.add(panelCentro,BorderLayout.SOUTH);
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
		JLabel indicacion = new JLabel("Seleccion");
		indicacion.setHorizontalAlignment(JLabel.CENTER);
		tiemposAlimento.add(indicacion,BorderLayout.NORTH);
		JPanel eleccion = new JPanel();
		aceptar = new JButton("Agregar");
		aceptar.addActionListener(this);
		eleccionTiempo = new JCheckBox[TIEMPOSDECOMIDA.length+1]; // 3 tiempos + "todos"
		numAlimTie = new int[eleccionTiempo.length-1];
		eleccion.setLayout(new GridLayout(0,4));
		for(int t = 0; t < eleccionTiempo.length-1; t++) { // Para evitar "todos" reducimos en -1
			eleccionTiempo[t] = new JCheckBox(TIEMPOSDECOMIDA[t]);
			eleccionTiempo[t].addActionListener(this);
			eleccion.add(eleccionTiempo[t]);
			numAlimTie[t] = 0;
		}
			eleccionTiempo[eleccionTiempo.length-1] = new JCheckBox("En todos"); // Este agrega al de cena 
			eleccion.add(eleccionTiempo[eleccionTiempo.length-1]); // Desayuno aumento de 2 en 2
			eleccion.add(aceptar); // Agregar al final xd
			tiemposAlimento.add(eleccion,BorderLayout.CENTER);
			tiemposAlimento.add(creaListas(),BorderLayout.SOUTH);
			return	tiemposAlimento;
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object prod = ae.getSource();
		if(prod == verificar) {
			String mensaje = "La verdura sin restriccion de cantidad\nLa fruta sin restricciones de cantidadcon variedad de colores\nLos creales deben ser suficientes\nLas legumbres deben ser suficientes combinadas con cereales\nProductos de origen animal deben ser consumidos en poca cantidad ";	
			JOptionPane.showMessageDialog(this, mensaje);
		}if(prod == eleccionTiempo) {
			boolean	seleccion = true;				
			for(int	t=0; t < eleccionTiempo.length; t++) {
				seleccion = eleccionTiempo[t+1].isSelected() &&	eleccionTiempo[t].isSelected();
			eleccionTiempo[eleccionTiempo.length-1].setSelected(seleccion);				
			}
		}if (prod == aceptar) {
			Alimentos aliSel = (Alimentos) alimento.getSelectedItem();
			for (int t = 0; t <eleccionTiempo.length-1; t++) {
				if(eleccionTiempo[t].isSelected()){
					modelosListas[t].addElement(aliSel);
					numAlimTiem[t].setText("Num. Ali.: " + (++numAlimTie[t]));
					//numAlimTie[aliSel.getTipo()]++; // Esta parte está pendiente
				}
			}
			
		}
			
    	
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int totalkc = 0;
		for(int ta = 0; ta < COLORES.length; ta++) {
			//int base = (racTipoAlim[ta].getHeight()-racTipoAlim[ta].getValue()*KCAL_TIPO_ALIM[ta]);
	        //kCalTipoAlim[ta].setBounds(0, base, 60, racTipoAlim[ta].getHeight()*racTipoAlim[ta].getValue()*KCAL_TIPO_ALIM[ta]);//racTipoAlim[ta].getHeight());
			//kCalTipoAlim[ta].setText("" + racTipoAlim[ta].getValue() * KCAL_TIPO_ALIM[ta] + "-KC");
			//totalkc += racTipoAlim[ta].getValue() * KCAL_TIPO_ALIM[ta];
		}
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
