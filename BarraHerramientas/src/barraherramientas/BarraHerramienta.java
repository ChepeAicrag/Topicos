/*
 * Componente tipo panel con los botones
 */

package barraherramientas;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * @author Garcia Garcia Jose Angel
 */
public class BarraHerramienta extends JPanel{
    private Vector<JButton> botones;
    private int nBotones;
    private ImageIcon img1 = new ImageIcon("agregar.jpg");
    private ImageIcon imgAgregar = new ImageIcon(img1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
    private JButton agregar = new JButton(imgAgregar); // Siempre lo tendra el panel
    FlowLayout s = new FlowLayout();
    private int pos;    
    
    public BarraHerramienta(){
        botones = new Vector<>(1); // El boton con imagen de mas
        agregarBotonPanel(agregar);
    }
    
    public BarraHerramienta(int nBotones){
        this.nBotones = nBotones + 1; // EL ultimo es el de agregar
        botones = new Vector<>(nBotones); // Creamos el arreglo con el tamaño que desea el cliente
        agregarBotonPanel(agregar);
    }
    
    public BarraHerramienta(JButton[] botones){
        this.nBotones = botones.length + 1;
        this.botones = new Vector(nBotones);
        agregarBotonPanel(agregar);
        for (int i = 0; i < botones.length; i++) {
            agregarBotonPanel(botones[i]);
        }
    }
    
    private void agregarBotonPanel(JButton b){
        setLayout(s);
        if(botones.size() == nBotones-1)
            return;
        botones.add(b);
        add(b);
    }
    
    public void agregarBoton(JButton b){
        agregarBotonPanel(b);
    }
    
    // c de la clase controlador
    public void conectarControlador(ActionListener c){
        agregar.addActionListener(c);
    }
}
