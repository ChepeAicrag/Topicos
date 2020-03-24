
package misComponentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.Serializable;
import static java.util.Arrays.sort;
import java.util.Vector;
import javax.accessibility.Accessible;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Laura Sanchez
 */
public class BarraHerramientas extends JPanel implements Serializable,Accessible{
    private Vector <JButton> arre;
    
    /**

     * Constructor para la Barra de Herramientas

     * @param eti El parámetro donde se envian las etiquetas para los botones

     */
    public BarraHerramientas( String eti[]){
      arre=new Vector<JButton>();
      int n[]=new int [eti.length];
      for(int o=0;o<eti.length;o++){
          n[o]=eti[o].length();
      }
      sort(n);
      //System.out.println(n[eti.length-1]);
      //setLayout(null);
      for(int i=0; i<eti.length;i++){
          
        JButton btn=new JButton(eti[i]);
        arre.add(btn);
        add(btn);
        btn.setBackground(Color.decode("#F0F0F0"));
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Sylfaen",Font.BOLD,13));
        btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#cae8d5"),Color.decode("#fcf7bb")));
        btn.setBounds(i*n[eti.length-1]*20, 0, n[eti.length-1]*20, 30); 
        btn.setActionCommand("btn"+i);
        
      }
      this.setBackground(null);
      //this.setBorder(BorderFactory.createLineBorder(Color.blue,1));
      this.setSize(eti.length*n[eti.length-1]*10,30);
      setVisible(true);
      updateUI();
    }
    
    
     /**

     * Constructor para la Barra de Herramientas

     * @param eti El parámetro donde se envian las etiquetas para los botones
     * @param imagenes El parámetro donde se envian las imagenes para los botones

     */
    public BarraHerramientas(ImageIcon imagenes[],String eti[]){
       arre=new Vector<JButton>();
      int n[]=new int [eti.length];
      for(int o=0;o<eti.length;o++){
          n[o]=eti[o].length();
      }
      sort(n);
      //setLayout(null);
      
      for(int i=0; i<imagenes.length;i++){
          
        JButton btn=new JButton(eti[i]);
        btn.setIcon(imagenes[i]);
        arre.add(btn);
        add(btn);
        btn.setBackground(Color.decode("#F0F0F0"));
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Sylfaen",Font.BOLD,13));
        btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#cae8d5"),Color.decode("#fcf7bb")));
        btn.setBounds(i*n[eti.length-1]*20, 0, n[eti.length-1]*20, 60);
        btn.setActionCommand("btn"+i); 
      }

      this.setBackground(null);
      //this.setBorder(BorderFactory.createLineBorder(Color.blue,1));
      this.setSize(eti.length*n[eti.length-1]*20,60);
      setVisible(true);
      updateUI();
    }
    
    
    /**

     * Constructor para la Barra de Herramientas

     * @param imagenes El parámetro donde se envian las imagenes para los botones

     */
    public BarraHerramientas(ImageIcon imagenes[]){
       arre=new Vector<JButton>();
      //setLayout(null);
      
      for(int i=0; i<imagenes.length;i++){
          
        JButton btn=new JButton("");
        btn.setIcon(imagenes[i]); 
        arre.add(btn);
        add(btn);
        btn.setBackground(Color.decode("#ffffff"));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Sylfaen",Font.BOLD,13));
        btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#cae8d5"),Color.decode("#fcf7bb")));
        btn.setBounds(i*70,0, 70,50);
        btn.setActionCommand("btn"+i);
      }

      this.setBackground(Color.BLACK);
      this.setBorder(BorderFactory.createLineBorder(Color.blue,1));
      this.setSize(imagenes.length*70,50);
      setVisible(true);
      updateUI();
    }
    
    /**

     * Constructor para la Barra de Herramientas

     * @param botones El parámetro donde se envian los botones

     */
    public BarraHerramientas( JButton botones[]){
       arre=new Vector<JButton>();
      //setLayout(null);
      for(int i=0; i<botones.length;i++){
          
        JButton btn=botones[i];
        arre.add(botones[i]);
        add(btn);
        btn.setBackground(Color.decode("#f6d186"));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Sylfaen",Font.BOLD,13));
        btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#ffc8bd"),Color.decode("#fcf7bb")));
        btn.setBounds(i*100, 0, 100,60);
        btn.setActionCommand("btn"+i);
        
      }
      
      this.setBackground(Color.BLACK);
      this.setBorder(BorderFactory.createLineBorder(Color.blue,1));
      this.setSize(botones.length*100,30);
      setVisible(true);
      updateUI();
    }
    
    /**

     * Constructor para la Barra de Herramientas

     */
    public BarraHerramientas(){
      arre=new Vector<JButton>();
      setLayout(new GridLayout(1,3));
      JButton  btn=new JButton("Opcion 1");
      JButton  btn1=new JButton("Opcion 2");
      JButton  btn2=new JButton("Opcion 3");
      btn.setBackground(Color.decode("#f6d186"));
      btn.setBorder(BorderFactory.createRaisedBevelBorder());
      btn.setForeground(Color.WHITE);
      btn1.setForeground(Color.WHITE);
      btn1.setBorder(BorderFactory.createRaisedBevelBorder());
      btn1.setBackground(Color.decode("#512b58"));
      btn2.setForeground(Color.WHITE);
      btn2.setBorder(BorderFactory.createRaisedBevelBorder());
      btn2.setBackground(Color.decode("#512b58"));
      this.setBackground(Color.decode("#512b58"));
      this.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
      add(btn);
      add(btn1);
      add(btn2);
      this.setSize(3*30,100);
      
      setVisible(true);
      updateUI();
    }
    
    /**

     * Método para obtener el ActionCommand

     * @param noBoton El parámetro para saber el número del botón 
     * @return una cadena con el ActionCommand
     
     */
    public String getActionComand(int noBoton){
       return arre.elementAt(noBoton).getActionCommand();
    }
    
    /**

     * Método para obtener los botones 
     * @return un arreglo de botones
     
     */
    public Vector getBotones(){
      return arre;
    }
    
    /**

     * Método para cambiar las etiquetas

     * @param p El parámetro que contiene la nueva etiqueta
     * @param b contine el indice del boton a cambiar
     * 
     
     */
    public void setEtiqueta(String p,int b){
      arre.elementAt(b).setText(p);
    }
    
    /**

     * Método para cambiar el fondo de la barra

     * @param c El parámetro que contiene el color
   
     * 
     
     */
    public void setFondo(Color c){
        
      for (JButton b:arre){
       b.setBackground(c);
      }
      
    }
    
    /**

     * Método para obtener un boton

     * @param n El parámetro que tiene el indice del boton
     * @return  un boton
     * 
     
     */
    
    public JButton  getBoton(int n){
      return arre.elementAt(n);
    }
    
    public void addBoton(String s){
      arre.add(new JButton(s));
      setLayout(null);
      arre.lastElement().setBackground(Color.decode("#f6d186"));
      arre.lastElement().setForeground(Color.BLACK);
      arre.lastElement().setBorder(BorderFactory.createEtchedBorder(Color.decode("#ffc8bd"),Color.decode("#fcf7bb")));
      add(arre.lastElement());
      arre.lastElement().setBounds((arre.size()-1)*arre.elementAt(0).getText().length()*20, 0, arre.elementAt(0).getText().length()*20, 60);
      this.setSize(arre.size()*arre.elementAt(0).getText().length()*20,60);
    }
    
    
    @Override
    public void paintComponent(Graphics f){
        super.paintComponent(f);
      
       int ancho= getWidth();
       int alto=getHeight();
       int tam=(ancho)/(arre.size());
        System.out.println(alto);
        System.out.println(ancho);
       for(int i=0; i<arre.size();i++){
         
         if(i==0){arre.elementAt(i).setBounds(0, 0,tam,alto);}
         else{
             // System.out.println(tam*(i));
             arre.elementAt(i).setBounds(tam*(i),0,tam,alto);
         }
        
        
       }
       
       
      
    }
    
    
       
    
    
    
    
}
