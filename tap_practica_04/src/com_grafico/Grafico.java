
package com_grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * @author García García José Ángel
 */
public class Grafico extends JComponent implements Serializable{ 
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
        titulo = new JLabel(""); // Crea la etiqueta que tiene el titulo
        etis = new JLabel[0]; // Crea el arreglo de etiquetas que tiene los valores de las barras
        leyendaBarra = new JLabel[0]; // Crea el arreglo de etiquetas que tiene las leyendas de las barras
        colorB = new JLabel[0]; // Crea el arreglo de etiquetas que tiene los colores de las barras para colocar juanto a las leyendas
        tLeyenda = new String[0]; // Crea el arreglo de los titulos de las leyendas para las barras
        // Se tiene el cosntructor simple, para ello se debe 
        // inicalizar los atributos de la clase, en especial arreglos para que 
        // puedan se usados posteriormente.
    }
    
    // Constructor con parametros para el titulo y las leyendas de las barras
    public Grafico(String encabezado, String tLeyenda[]){
        nfiguras = tLeyenda.length; // Establece el numero de barras
        this.tLeyenda = tLeyenda; 
        leyendaBarra = new JLabel[tLeyenda.length];
        tTitulo = encabezado;
        setLeyendas(tLeyenda); 
        iniciarElementos(); // metodo para iniciar los valores
                
    }

    private void iniciarElementos() { 
        vals = new int[nfiguras]; // Crea el arreglo que guarda los valores
        for (int i = 0; i < nfiguras; i++) {
            vals[i] = 0; // Establece 0 a todos los valores, por defecto
        } 
        titulo = new JLabel(tTitulo); // crea la etiqueta del titulo 
        add(titulo); // Agregamos el titulo al componente
        etis = new JLabel[nfiguras]; // Creamos el arreglo de etiquetas
        colorB = new JLabel[nfiguras]; // Creamos el arreglo de colores 
        for (int i = 0; i < nfiguras; i++) {
            etis[i] = new JLabel("" + 0); // Asignamos el valor de barra a la etiqueta correspondiente
            add(etis[i]); // Agregamos la etiqueta al componente
        }
        // identificacion del color de cada barra colorB[]
        for (int i = 0; i < nfiguras; i++) {
            colorB[i] = new JLabel(); // Se crea la etiqueta a utilizar
            colorB[i].setOpaque(true); // Permite establecer un color de fondo a la etiqueta
            colorB[i].setBackground(color[i]); // Se establece el color de fondo a la etiqueta
            add(colorB[i]); // Se agrega la etiqueta al componente
        }
    }
    
    public void setTitulo(String encabezado){
        this.tTitulo = encabezado; // Establece el titulo al componente de acuerdo con el del parametro
    }
    
    public void setLeyendas(String tLeyenda[]){
        nfiguras = tLeyenda.length; // Establece la cantidad de figuras
        this.tLeyenda = tLeyenda; 
        leyendaBarra = new JLabel[nfiguras]; // Crea el arreglo de las leyendas de barra 
        for (int i = 0; i < nfiguras; i++) { 
            leyendaBarra[i] = new JLabel(tLeyenda[i]); // establece el texto a cada etiqueta leyenda 
            add(leyendaBarra[i]); // Agrega las leyendas de cada barra al componente
        }
        iniciarElementos();
    }
    
    public void setValores(int valores[]){
        if(valores.length == nfiguras) // Si el numero de valores no es el mismo que el de barras, las construye en 0
        for (int i = 0; i < nfiguras; i++) {
            vals[i] = valores[i]; // Establece los nuevos valores a cada elemento del arreglo de valores
            etis[i].setText("" + vals[i]); // Establece el valor en tipo texto a cada etiqueta
        }
    }
    
    @Override
    public void paintComponent(Graphics f){
        int i;
        int j = 1;
        int ancho = getWidth(); // Se alamcena el ancho del componente  
        int alto = getHeight(); // Se almacena el alto del componente
        titulo.setBounds((int)((ancho-f.getFontMetrics().stringWidth(titulo.getText()))/2), 10, titulo.getText().length()*8, 20); // Se posiciona el titulo
        int separa = (int)(ancho / (nfiguras)* 0.10); // Se guarda un valor separador entre barras
        int anchoB = (int)(ancho / (nfiguras) - separa); // Se guarda el ancho entre barras
        
        for (i = 0; i < nfiguras; i++) {
            f.setColor(color[i]); // Establece el color de la barra
            etis[i].setBounds(separa+i*(anchoB+separa)+(anchoB/2), (alto-20*colorB.length)-vals[i]*5-etis[i].getHeight()-2,30,20); // Posiciona el valor de cada barra
            f.fill3DRect(separa+i*(anchoB+separa),((alto-20*colorB.length)-vals[i]*5), anchoB, vals[i]*5, true); // Crea la barra de color en posicion especidifcada
            colorB[nfiguras-1-i].setBounds(separa,getHeight()-(16*j)-(3*i),15,15); // Se posiciona el cuadro de color para cada leyenda en el componente
            leyendaBarra[nfiguras-1-i].setBounds(separa+25,getHeight()-(18*j)-(2*i),leyendaBarra[nfiguras-1-i].getText().length() + 10,20); // Se posiciona la leyenda en el componente
            j++;
        }
    
    }
}