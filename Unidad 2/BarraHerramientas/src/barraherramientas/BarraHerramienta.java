/*
 * Componente tipo panel con los botones
 * Arreglar componente para el examen
 * Descargar el conector .jar
    Agregar hilos al proyecto 
    Para le fin del semestre

   Duplas son las filas o renglones
 * create table "nonbre de la tabla"{
 *  podemos crearlo d emanera grafica
   comandos para insertar 
    insert into nombreTabla
    values (val1,val2 ... valn); // Mismo orden en la que fue creada la tabla
    insert into nombreTabla
    (campo1,campo2 ... campon)
    values(val1,val2 ... valn);
    delete from nombreTabla; // borra toda las duplas 
    delete from nombreTabla where campo=val; (usar and,or)// condicion que deben cumplir las duplas a eliminar
    update nombreTabla set campo1=valor; // actualiza todas las duplas
    update nombreTabla set campo1=valor where (condicion); //
    select * from nombreTabla;
    select campo,campo2,campo3,campon from nombreTabla; // Muestra las columnas de todas las duplas 
    select * from nombreTabla where (condicion); // Muestra las duplas con esa condicon
    select campo,campo2,campo3,campon from nombreTabla (condicion) // consultas 
 *   };
    En modelo van los datos
    

 */

package barraherramientas;

import com.sun.xml.internal.ws.api.client.ServiceInterceptor;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.EventListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeListener;
/**
 * @author Garcia Garcia Jose Angel
 */
public class BarraHerramienta extends JPanel{
    private Vector<JButton> botones;
    private int nBotones;
    private JButton agregar = new JButton("boton 1"); // Siempre lo tendra el panel
    FlowLayout s = new FlowLayout();
    private int pos;    
    
    public BarraHerramienta(){
        botones = new Vector<>(1); // El primer boton agregado, si es que no incializa uno
        agregarBoton(agregar);
    }
    
    public BarraHerramienta(int nBotones){
        this.nBotones = nBotones; // EL ultimo es el de agregar
        botones = new Vector<>(nBotones); // Creamos el vector con el tamaño que desea el cliente
        //agregarBoton(agregar);
    }
    
    public BarraHerramienta(String[] datos){
        this.nBotones = datos.length;
        this.botones = new Vector(nBotones);
        for (int i = 0; i < datos.length; i++) { 
                agregarBoton(new JButton(datos[i]));
        }
    }
    
    public BarraHerramienta(ImageIcon[] iconos){
        this.nBotones = iconos.length;
        this.botones = new Vector(nBotones);
         for (int i = 0; i < iconos.length; i++) {
                JButton b = new JButton("boton " + (i+1),iconos[i]);
                b.setIconTextGap(JButton.CENTER);
                agregarBoton(b);
        }
    }
    
    public BarraHerramienta(ImageIcon[] iconos,String[]etq){
        if(iconos.length != etq.length){
            botones = new Vector<>(1);
            agregarBoton(agregar);
        }
        this.nBotones = iconos.length;
        this.botones = new Vector(nBotones);
         for (int i = 0; i < iconos.length; i++) { 
                ImageIcon ico = new ImageIcon(iconos[i].getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT));
                JButton b = new JButton(etq[i],ico);
                agregarBoton(b);
        }
    }
    
    public BarraHerramienta(JButton[] botones){
        this.nBotones = botones.length;
        this.botones = new Vector(nBotones);
        //agregarBoton(agregar);
        for (int i = 0; i < nBotones; i++) {
            agregarBoton(botones[i]);
        }
    }
    
    public void agregarBoton(JButton b){
        setLayout(s);
        if(botones.size() < pos)
            return;
        botones.add(b); // lo agrega al ultimo
        add(b);
        pos++;
    }
    
    public JButton getBotonPos(int i){
        if(i >= 0 && i < nBotones)
            return this.botones.elementAt(0); // Tre regresa el primer elemento, con la intencion de evitar el null
        else
            return botones.elementAt(i);
    }
    
    public void conectarControlador(TestMultiple c){
        
        for (int i = 0; i < botones.size(); i++) {
            if(c instanceof ActionListener)
            botones.elementAt(i).addActionListener((ActionListener) c);
            if(c instanceof AncestorListener)
            botones.elementAt(i).addAncestorListener((AncestorListener) c);
            if(c instanceof ChangeListener)
            botones.elementAt(i).addChangeListener((ChangeListener) c);
            if(c instanceof ComponentListener)
            botones.elementAt(i).addComponentListener((ComponentListener) c);
            if(c instanceof ContainerListener)
            botones.elementAt(i).addContainerListener((ContainerListener) c);
            if(c instanceof FocusListener)
            botones.elementAt(i).addFocusListener((FocusListener) c);
            if(c instanceof HierarchyListener)
            botones.elementAt(i).addHierarchyBoundsListener((HierarchyBoundsListener) c);
            if(c instanceof HierarchyBoundsListener)
            botones.elementAt(i).addHierarchyBoundsListener((HierarchyBoundsListener) c);
            if(c instanceof InputMethodListener)
            botones.elementAt(i).addInputMethodListener((InputMethodListener) c);
            if(c instanceof ItemListener)
            botones.elementAt(i).addItemListener((ItemListener) c);
            if(c instanceof KeyListener)
            botones.elementAt(i).addKeyListener((KeyListener) c);
            if(c instanceof MouseListener)
            botones.elementAt(i).addMouseListener((MouseListener) c);
            if(c instanceof MouseMotionListener)
            botones.elementAt(i).addMouseMotionListener((MouseMotionListener) c);
            if(c instanceof MouseWheelListener)
            botones.elementAt(i).addMouseWheelListener((MouseWheelListener) c);
            botones.elementAt(i).setActionCommand("boton " + (i+1) );
        }
    }
  
}
