import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlador implements ActionListener,KeyListener{

    
	private Ventana v;
	private Modelo m;
	
	public Controlador(Ventana v, Modelo m) {
		this.v = v;
		this.m = m;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if(e.getActionCommand().equals("Reiniciar")) {
			m.limpiar(v);
                        return;
		}
			
		if(e.getActionCommand().equals("Votar1")) {
			m.actualizarVotos(v,1);
			
		}
		if(e.getActionCommand().equals("Votar2")) {
			m.actualizarVotos(v,2);
			
		}
		if(e.getActionCommand().equals("Votar3")) {
			m.actualizarVotos(v,3);
			
		}
		
		m.actualizarPorcentaje(v);
                m.actualizarBarras(v);
		m.actualizarTotalesVotos(v);
		m.actualizarPresuTotolaes(v);
		
	}

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
    }

    public void keyReleased(KeyEvent ke) {
        try{
        	m.actualizarPresuTotolaes(v);
        	}catch(Exception e) {}
        }

}
