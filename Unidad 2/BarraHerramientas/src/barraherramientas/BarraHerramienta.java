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
    inser into nombreTabla
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
    private JButton agregar = new JButton("Boton 1"); // Siempre lo tendra el panel
    FlowLayout s = new FlowLayout();
    private int pos;    
    
    public BarraHerramienta(){
        botones = new Vector<>(1); // El boton con imagen de mas
        agregarBoton(agregar);
        // agregar el action listener a agregar 
    }
    
    public BarraHerramienta(int nBotones){
        this.nBotones = nBotones; // EL ultimo es el de agregar
        botones = new Vector<>(nBotones); // Creamos el arreglo con el tamaño que desea el cliente
        agregarBoton(agregar);
    }
    
    public BarraHerramienta(JButton[] botones){
        this.nBotones = botones.length;
        this.botones = new Vector(nBotones);
        agregarBoton(agregar);
        for (int i = 0; i < botones.length; i++) {
            agregarBoton(botones[i]);
        }
    }
    
    public void agregarBoton(JButton b){
         setLayout(s);
        if(botones.size() == nBotones)
            return;
        botones.add(b);
        add(b);  
    }
    
    // c de la clase controlador
    public void conectarControlador(ActionListener c){
        for (int i = 0; i < botones.size(); i++) {
            botones.elementAt(i).addActionListener(c);
        }
    }
}
