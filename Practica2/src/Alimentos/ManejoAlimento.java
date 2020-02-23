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
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ManejoAlimento extends JFrame implements ActionListener,ChangeListener{
	private  Alimentos alimentos[];
	private final Color COLORES[] = {Color.GREEN, Color.YELLOW, Color.ORANGE, Color.WHITE, Color.MAGENTA};
    private final String Tipo_Alimento[] = {"Verduras","Frutas","Cereales","Leguminosas","Origen Animal"};
    private final int KCAL_TIPO_ALIM[] = {25,60,70,120,40};
    private JSlider racTipoAlim[]; // Fija el numero de racionespor tipo de  alimento
    private JLabel kCalTipoAlim[]; // Guarda las kilocalorias por tipo de alimento
    private JPanel pKcalTipoAlim[]; // Paneles para guardar las barras a desplegar
    private JButton verificar;
    private JLabel kilocalorias; // Para mostrar el valor de las kilocalorias
	public ManejoAlimento() {
	super("Practica 2");
	Container panel = getContentPane();
    JTabbedPane panelPrincipal = new JTabbedPane();
    panelPrincipal.addTab("Conociendo alimentos", panelConociendo());
    panelPrincipal.addTab("Eleccion de alimentos", panelAlimentos());
    //panelPrincipal.addTab("Clasificacion de alimentos",grafico);
    panel.add(panelPrincipal);
    alimentos = cargarDatos();
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
		alimentos[4] = new Alimentos("Tomate", 1);
		alimentos[5] = new Alimentos("Platano", 1);
		alimentos[6] = new Alimentos("Naranja", 1);
		alimentos[7] = new Alimentos("Pepino", 1);
		alimentos[8] = new Alimentos("Manzana", 2);
		alimentos[9] = new Alimentos("Pera", 2);
		alimentos[10] = new Alimentos("Sandia", 2);
		alimentos[11] = new Alimentos("Mango", 3);
		alimentos[12] = new Alimentos("Cereza", 3);
		alimentos[13] = new Alimentos("Piña", 3);
		alimentos[14] = new Alimentos("Camote", 4);
		alimentos[15] = new Alimentos("Papa", 4);
		alimentos[16] = new Alimentos("Uva", 4);
		alimentos[17] = new Alimentos("Ciruela", 5);
		alimentos[18] = new Alimentos("Coco", 5);
		alimentos[19] = new Alimentos("Mandarina", 6);
		alimentos[20] = new Alimentos("Toronja", 7);
		alimentos[21] = new Alimentos("Papaya", 8);
		
		// 6.	Diseño	de	la	presentación principal del	panel	“Elección	de	elementos”
	
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
		
		for(int ta = 0; ta < KCAL_TIPO_ALIM.length;ta++) {
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
			kCalTipoAlim[ta].setBackground(Color.black);
			kCalTipoAlim[ta].setOpaque(false);
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
			panelCentro.add(pGpoTipoAlim); // Agregando al panel central 
		}
			conocer.add(panelSur,BorderLayout.SOUTH);
			conocer.add(panelSuperior,BorderLayout.NORTH);
			conocer.add(panelCentro,BorderLayout.CENTER);
			return conocer;

	}
		
	private JPanel panelAlimentos() {
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object prod = ae.getSource();
		if(prod == verificar) {
			String mensaje = "La verdura sin restriccion de cantidad\nLa fruta sin restricciones de cantidadcon variedad de colores\nLos creales deben ser suficientes\nLas legumbres deben ser suficientes combinadas con cereales\nProductos de origen animal deben ser consumidos en poca cantidad ";	
			JOptionPane.showMessageDialog(this, mensaje);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int totalkc = 0;
		for(int ta = 0; ta < COLORES.length; ta++) {
		//	int base = (racTipoAlim[ta].getHeight()-racTipoAlim[ta].getValue()*KCAL_TIPO_ALIM[ta]) * racTipoAlim[ta].getHeight()/racTipoAlim[ta].getHeight();
	    //  kCalTipoAlim[ta].setBounds(0, base, 60, racTipoAlim[ta].getHeight()*racTipoAlim[ta].getValue()*KCAL_TIPO_ALIM[ta]/racTipoAlim[ta].getHeight());
		//	kCalTipoAlim[ta].setText("" + racTipoAlim[ta].getValue() * KCAL_TIPO_ALIM[ta] + "-KC");
		//	totalkc += racTipoAlim[ta].getValue() * KCAL_TIPO_ALIM[ta];
		}
		kilocalorias.setText("TotalKC : "+ totalkc + " ");
		this.repaint();
	}
}	
