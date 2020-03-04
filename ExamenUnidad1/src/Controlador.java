import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener{

	private Ventana v;
	private Modelo m;
	
	public Controlador(Ventana v, Modelo m) {
		this.v = v;
		this.m = m;
		v.establecerPresupuestoTotal("0");
		v.establecerVotacionTotal("0");
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Reiniciar")) {
			m.limpiar(v);
		}
			
		if(e.getActionCommand().equals("Votar1")) {
			JOptionPane.showMessageDialog(v, "Ha votado por Peña");
			m.actualizarVotos(v,1);
			
		}
		if(e.getActionCommand().equals("Votar2")) {
			JOptionPane.showMessageDialog(v, "Ha votado por Obrador");
			m.actualizarVotos(v,2);
			
		}
		if(e.getActionCommand().equals("Votar3")) {
			JOptionPane.showMessageDialog(v, "Ha votado por Salinas");
			m.actualizarVotos(v,3);
			
		}
		
		m.actualizarPorcentaje(v);
		int votos = v.votos1() + v.votos2() + v.votos3();
		int presupuestos = v.getPresupuesto1() + v.getPresupuesto2() + v.getPresupuesto3();
		v.establecerVotacionTotal("" + votos);
		v.establecerPresupuestoTotal("" + presupuestos);
		
	}

}
