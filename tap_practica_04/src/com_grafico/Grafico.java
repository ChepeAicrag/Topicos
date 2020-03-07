
package com_grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * 
 * @author García García José Ángel
 */
public class Grafico extends JComponent implements Serializable{ // Serializable anotar en bitacora
    private int nfiguras; // Numero de barras
    private JLabel [] etis; // etiquetas para el valor a mostrar
    private int [] vals ={0,0,0}; // valores de cada barra, se danvalores por omision
    // se consideran 10 colores para 10 valores
    private static Color color[] ={Color.BLUE,Color.GREEN,Color.CYAN
            ,Color.YELLOW,Color.PINK,Color.WHITE,Color.RED,Color.ORANGE,Color.MAGENTA};
    private static JLabel leyendaBarra[]; //Muestra el titulo de la leyenda
    private static JLabel colorB[]; // identificacion del color de las barras
    private JLabel titulo; // titulo 
    private String tTitulo; // texto del titulo
    private String tLeyenda[]; // titulos de las leyendas que identifican a cada barra
    
    public Grafico(){ // Constructor sin parametros para crear instancias con valores; bitacora 
        titulo = new JLabel("");
        etis = new JLabel[0];
        leyendaBarra = new JLabel[0];
        colorB = new JLabel[0];
        tLeyenda = new String[0];
        // Inicalizar los atributos de la clase, en especial arreglos
    }
    
    
    public Grafico(String encabezado, String tLeyenda[]){
        nfiguras = tLeyenda.length;
        this.tLeyenda = tLeyenda;
        leyendaBarra = new JLabel[tLeyenda.length];
        tTitulo = encabezado;
        setLeyendas(tLeyenda); // Inecesario, creo
        inicarElementos(); // metodo para iniciar los valores
                
    }

    private void inicarElementos() { // Creacion e inicio de los valores de cada barra
        vals = new int[nfiguras];
        for (int i = 0; i < nfiguras; i++) {
            vals[i] = 0;
        } 
        // crea y agrega la etiqueta del titulo 
        titulo = new JLabel(tTitulo);
        add(titulo);
        // crea e inicia los demas arreglos
        etis = new JLabel[nfiguras];
        colorB = new JLabel[nfiguras];
        for (int i = 0; i < nfiguras; i++) {
            etis[i] = new JLabel("" + 0);
            add(etis[i]);
        }
        // identificacion del color de cada barra colorB[]
        for (int i = 0; i < nfiguras; i++) {
            colorB[i] = new JLabel();
            colorB[i].setOpaque(true);
            colorB[i].setBackground(color[i]);
            add(colorB[i]);
        }
    }
    
    public void setTitulo(String encabezado){
        this.tTitulo = encabezado;
    }
    
    public void setLeyendas(String tLeyenda[]){
        nfiguras = tLeyenda.length;
        this.tLeyenda = tLeyenda;
        leyendaBarra = new JLabel[nfiguras];
        for (int i = 0; i < nfiguras; i++) {
            leyendaBarra[i] = new JLabel(tLeyenda[i]);
            add(leyendaBarra[i]);
        }
        inicarElementos();
    }
    
    public void setValores(int valores[]){
        if(valores.length == nfiguras)
        for (int i = 0; i < nfiguras; i++) {
            vals[i] = valores[i];
            etis[i].setText("" + vals[i]);
        }
    }
    
    @Override
    public void paintComponent(Graphics f){
        int i;
        int j = 1;
        int ancho = getWidth();
        int alto = getHeight();
        titulo.setBounds((int)((ancho-f.getFontMetrics().stringWidth(titulo.getText()))/2), 10, titulo.getText().length()*8, 20);
        int separa = (int)(ancho / (nfiguras)* 0.10);
        int anchoB = (int)(ancho / (nfiguras) - separa);
        
        for (i = 0; i < nfiguras; i++) {
            f.setColor(color[i]); // Establece el color de la barra
            etis[i].setBounds(separa+i*(anchoB+separa)+(anchoB/2), (alto-20*colorB.length)-vals[i]*5-etis[i].getHeight()-2,30,20);
            f.fill3DRect(separa+i*(anchoB+separa),((alto-20*colorB.length)-vals[i]*5), anchoB, vals[i]*5, true);
            colorB[nfiguras-1-i].setBounds(separa,getHeight()-(16*j)-(3*i),15,15);
            leyendaBarra[nfiguras-1-i].setBounds(separa+25,getHeight()-(18*j)-(2*i),titulo.getText().length()*8,20); // El problema es y
            j++;
        }
    
    }
}
