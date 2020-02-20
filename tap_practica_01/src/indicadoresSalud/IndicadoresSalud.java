/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indicadoresSalud;

import java.awt.FlowLayout;
import java.net.URL;
import javax.swing.*;
/**
 *
 * @author García García José Ángel
 */
public class IndicadoresSalud extends JFrame{
   private JButton cIMC; //ACtiva el cálculo del IMC
   private JButton cICC; //ACtiva el cálculo del ICC
   private JButton borrar; //ACtiva el borrado de los datos
   private JLabel resultadoIMC; // Para mostrar el resultado de IMC
   private JLabel resultadoICC; // Para mostrar el resultado de ICC
   private JTextField edad; // Recibe el dato descrito
   private JTextField estatura; //Recibe el dato descrito
   private JTextField peso; // Recibe el dato descrito
   private JTextField cadera;   // Recibe el dato descrito
   private JTextField cintura;  // Recibe el dato descrito
   private JRadioButton hombre; // Seleccion del dato descrito
   private JRadioButton mujer;  // Seleccion del dato descrito
   
   public IndicadoresSalud(){
       String path = "/imagenes/bascula.png"; //Ubicacion de la imagen
       URL ur1 = this.getClass().getResource(path); //Obtiene un recurso de la ubicacion
       ImageIcon icon = new ImageIcon(ur1); // Crea un objeto ImageIcon a partir del recurso
       //Creacion y cosntruccion del titulo principal
       JLabel presentacion = new JLabel("INDICADORES BASICOS DEL RIESGO DE LA SALUD",icon,SwingConstants.CENTER);
       //construccion de elementos a visualizasr
       cIMC = new JButton("Caclular IMC");
       cICC = new JButton("Calcular ICC");
       edad = new JTextField(4);
       estatura = new JTextField(4);
       peso = new JTextField(4);
       resultadoIMC = new  JLabel("_ _ _ _ _ _ _ _ _ _");
       cintura = new JTextField(4);
       cadera = new JTextField(4);
       hombre = new JRadioButton(" Hombre ");
       mujer = new JRadioButton(" Mujer ");
       resultadoICC = new  JLabel("_ _ _ _ _ _ _ _ _ _");
       borrar = new JButton("Borrar Datos");
       JLabel tEdad = new JLabel("Proporciona tu Edad (> 19) :");
       JLabel tIMC = new JLabel("CALCULO DE INDICE DE MASA CORPORAL (IMC)");
       JLabel tEstatura = new JLabel(" Estatura(cms) :");
       JLabel tPeso = new JLabel(" Peso(kgs) :");
       JLabel tICC = new JLabel("CALCULO DEL INDICE DE CINTURA-CADEEA (I-C-C) :");
       JLabel tCintura = new JLabel(" Cintura(cms) :");
       JLabel tCadera = new JLabel(" Cadera(cms) :");
       JLabel tSexo = new JLabel(" Sexo :");
       presentacion.setHorizontalTextPosition(SwingConstants.CENTER);
       presentacion.setVerticalTextPosition(SwingConstants.TOP);
       add(presentacion);
       add(tEdad);
       add(edad);
       add(tIMC);
       add(tEstatura);
       add(estatura);
       add(tPeso);
       add(peso);
       add(cIMC);
       add(resultadoIMC);
       add(tICC);
       add(tCintura);
       add(cintura);
       add(tCadera);
       add(cadera);
       add(tSexo);
       add(hombre);
       add(mujer);
       add(cICC);
       add(resultadoICC);
       add(borrar);
       
       
       setLayout(new FlowLayout());
       setLocationRelativeTo(null);
       setSize(300,500);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
    }
    
}
