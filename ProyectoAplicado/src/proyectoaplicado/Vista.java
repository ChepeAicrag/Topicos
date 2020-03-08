/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoaplicado;

import com_grafico.Grafico;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class Vista extends JFrame {
    private JTextField txt1; // Para introducir los valores de las barras
    private JTextField txt2[]; // Los text creados
    private JLabel etqG[]; // Las etiquetas creadas
    private JLabel etq1; 
    private JLabel etq2;
    private JPanel p;
    private Grafico g;
    private JButton graficar;
    private JTextField titulo;
    private JLabel etqTitulo;
    
    SpringLayout s;
   public Vista(){
       setSize(600, 600);
       setVisible(true);
       s = new SpringLayout();
       g = new Grafico();
       add(componente());
       setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   public int getTxt1(){
       if(txt1.getText().isEmpty()) 
           return 0;
       int a = Integer.parseInt(txt1.getText());
       if(a < 11 && a > 0)
          return a;
       return 0;
   }
   
   public String getTitulo(){
       if(titulo.getText().isEmpty())
           return "Sin titulo";
       return titulo.getText();
   }
   
   public Container componente(){
       p = new JPanel();
       p.setLayout(s);
       graficar = new JButton("Graficar");
       etqTitulo = new JLabel("Introduce el titulo");
       titulo = new JTextField(10);
       etq1 = new JLabel("Introduce la cantidad de barras");
       txt1 = new JTextField(10);
       p.add(etqTitulo);
       s.putConstraint(SpringLayout.WEST, etqTitulo, 12, SpringLayout.WEST, p);
       s.putConstraint(SpringLayout.NORTH, etqTitulo, 12, SpringLayout.NORTH, p);
       p.add(titulo);
       s.putConstraint(SpringLayout.WEST, titulo, 90, SpringLayout.EAST, etqTitulo);
       s.putConstraint(SpringLayout.NORTH, titulo, 12, SpringLayout.NORTH, p);
       p.add(etq1);
       s.putConstraint(SpringLayout.WEST, etq1, 12, SpringLayout.WEST, p);
       s.putConstraint(SpringLayout.NORTH, etq1, 12, SpringLayout.SOUTH, etqTitulo);
       p.add(txt1);
       s.putConstraint(SpringLayout.NORTH, txt1, 12, SpringLayout.SOUTH, titulo);
       s.putConstraint(SpringLayout.WEST, txt1, 12, SpringLayout.EAST, etq1);
       etq2 = new JLabel("Introduce los valores de las barras");
       p.add(etq2);
       s.putConstraint(SpringLayout.NORTH, etq2, 15, SpringLayout.SOUTH, etq1);
       s.putConstraint(SpringLayout.WEST, etq2, 80, SpringLayout.WEST, p);
       return p;
   }
   
   public void agregarOpciones(){
           txt2 = new JTextField[getTxt1()];
           etqG = new JLabel[getTxt1()];
       for (int i = 0; i < getTxt1(); i++) {
           etqG[i] = new JLabel("Introduce el valor de la barra " + (i+1));
           txt2[i] = new JTextField(10);
           p.add(etqG[i]);
           p.add(txt2[i]);
           s.putConstraint(SpringLayout.WEST, etqG[i],12, SpringLayout.WEST, p);
           s.putConstraint(SpringLayout.WEST, txt2[i], 15, SpringLayout.EAST, etqG[i]);
           if(i == 0){
           s.putConstraint(SpringLayout.NORTH, txt2[i],12, SpringLayout.SOUTH, etq2);
           s.putConstraint(SpringLayout.NORTH, etqG[i],15, SpringLayout.SOUTH, etq2);
           }
           else{
           s.putConstraint(SpringLayout.NORTH, txt2[i], 10, SpringLayout.SOUTH, txt2[i-1]);
           s.putConstraint(SpringLayout.WEST, txt2[i], 15, SpringLayout.EAST, etqG[i]);
           s.putConstraint(SpringLayout.NORTH, etqG[i],14, SpringLayout.SOUTH, etqG[i-1]);
           }
           if(getTxt1() == 0)
              graficar.setEnabled(false);
           p.add(graficar);
           s.putConstraint(SpringLayout.WEST, graficar, 15, SpringLayout.EAST, txt1);
           s.putConstraint(SpringLayout.NORTH, graficar, 12, SpringLayout.NORTH, p);
           
           p.updateUI();
        }
      
   }
   
   public void printf(){
       String[] tLeyenda = new String[getTxt1()];
       for (int i = 0; i < tLeyenda.length; i++) {
           tLeyenda[i] = "Leyenda de barra " + (i+1);
       }
       g = new Grafico(getTitulo(), tLeyenda);
       g.setValores(valoresDeText());
       JFrame ex = new JFrame();
       ex.setSize(800,600);
       ex.setVisible(true);
       ex.setResizable(false);
       ex.setDefaultCloseOperation(HIDE_ON_CLOSE);
       ex.add(g);
       p.updateUI();
   }
   
   private int[] valoresDeText(){
       int nBarras = getTxt1();
       int valores[] = new int[nBarras];
       for (int i = 0; i < nBarras; i++) {
           int val;
           try{
            val = Integer.parseInt(txt2[i].getText());
           }catch(Exception e){
            val = 0;
           }
           valores[i] = val;
       }
       return valores;
   }
   
   public void bloquearTxt(boolean b){
       txt1.setEditable(b);
       titulo.setEditable(b);
   }
   
   public void conectarControlador(Controlador c){
       txt1.addKeyListener((KeyListener)c);
       graficar.addActionListener((ActionListener) c);
   }
}
