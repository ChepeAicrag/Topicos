
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Diseño de una calculadora
 * @author Garcia Garcia Jose Ángel
 * */
public class Ventana extends JFrame{
	private Container numeros; // Contiene botones del 1-9
	private Container operaciones; // Contiene los botones de las operaciones
	private Container acciones;
	private JTextField num;
	private JButton[] btnNumeros;
	private JButton suma;
	private JButton resta;
	private JButton div;
	private JButton borrar;
	private JButton igual;
	private JTextField resultado;
	
		public Ventana() {
		numeros = new Container();
		num = new JTextField(10);
		btnNumeros = rellenarNumeros();
		operaciones = botonesOperaciones();
		acciones = botonesAcciones();
		setLayout(new BorderLayout());
		add(numeros,BorderLayout.CENTER);
		add(num,BorderLayout.NORTH);
		add(operaciones,BorderLayout.EAST);
		add(acciones,BorderLayout.SOUTH);
		arrancar();
		
	}	
		
	public 	void actualizarResultado(String r){
		resultado.setText("Resultado : " + r);
	}
	
	private Container botonesAcciones() {
		Container principal = new Container();
		principal.setLayout(new BoxLayout(principal, BoxLayout.X_AXIS));
		Container c = new Container();
		c.setLayout(new FlowLayout(FlowLayout.RIGHT));
		borrar = new JButton("Borrar Datos");
		igual = new JButton("=");
		c.add(borrar);
		c.add(igual);
		resultado = new JTextField(20);
		resultado.setEditable(false);
		principal.add(resultado);
		principal.add(c);
		return principal;
	}	
		
	private Container botonesOperaciones() {
			Container c = new Container();
			c.setLayout(new GridLayout(3, 1));
			suma = new JButton("+");
			resta = new JButton("-");
			div = new JButton("/");
			c.add(suma);
			c.add(resta);
			c.add(div);
			return c;
		
	}
	private JButton[] rellenarNumeros(){
		numeros.setLayout(new GridLayout(3,3)); // Panel para hacer la calculadora
		JButton[] btnNumeros = new JButton[9];
		for (int i = 0; i < btnNumeros.length; i++) {
			btnNumeros[i] = new JButton("" + (i+1));
			btnNumeros[i].setBackground(Color.GRAY);
			numeros.add(btnNumeros[i]);
		}
		return btnNumeros;
	}
	
	public void arrancar(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    pack();
                    setVisible(true);
                    setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
