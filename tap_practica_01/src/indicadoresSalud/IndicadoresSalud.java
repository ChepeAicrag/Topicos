/*
 * GUI CON EVENTS PARA CALCULAR IMC Y EL ICC 
 * Utilizando FlowLayout
 */
package indicadoresSalud;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
/**
 *
 * @author García García José Ángel
 */
public class IndicadoresSalud extends JFrame implements ActionListener{
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
       ButtonGroup opcion = new ButtonGroup();
       opcion.add(hombre);
       opcion.add(mujer);
       hombre.setSelected(true);
       cIMC.addActionListener(this);
       cICC.addActionListener(this);
       borrar.addActionListener(this);
       setLayout(new FlowLayout());
       setLocationRelativeTo(null);
       setSize(300,500);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        String resultado = "";
        String situacion = "";
        if(boton == cIMC) // Si el boton que produce el evento es cIMC
        {
            int edadAños = Integer.parseInt(edad.getText());
            double mtsCms = Double.parseDouble(estatura.getText())/100;
            double pesoKgs = Double.parseDouble(peso.getText());
            if(mtsCms < 1.4 || mtsCms > 1.9 || pesoKgs < 40 || pesoKgs > 150 || edadAños < 20 || edadAños > 63 )
               JOptionPane.showMessageDialog(this, "Se requieren valores dentro del rango ");
            else{
              double vIMC = pesoKgs/ Math.pow(mtsCms,2); 
              if(vIMC < 18.5)
                  situacion = "Peso bajo";
              else if(vIMC > 18.5 && vIMC < 24.9)
                  situacion = "Peso normal";
              else if(vIMC > 25 && vIMC < 29.9)
                  situacion = "Sobre peso";
              else 
                  situacion = "Obesidad";
              resultado  =  String.format("%.2f %s", vIMC,situacion);
              resultadoIMC.setText(resultado);
            }
        }
        else if(boton == cICC)
        {
            double cinturaCms = Double.parseDouble(cintura.getText());
            double caderaCms = Double.parseDouble(cadera.getText());
            double vICC = cinturaCms / caderaCms;
            if (caderaCms < 60 || caderaCms > 150 || cinturaCms < 50 || cinturaCms > 140)
                JOptionPane.showMessageDialog(this, "Se requieren valores dentro del rango");
            else{
                if(hombre.isSelected()){
                    if(vICC <= 0.95 )
                        situacion = "Riesgo Cardiovascular Bajo";
                    else if(vICC > 0.95 && vICC < 1)
                        situacion = "Riesgo Cardiovascular Medio";
                    else 
                        situacion = "Riesgo Cardiovascular Alto";
                }else{
                    if(vICC <= 0.80 )
                        situacion = "Riesgo Cardiovascular Bajo";
                    else if(vICC > 0.80 && vICC < 0.85)
                        situacion = "Riesgo Cardiovascular Medio";
                    else 
                        situacion = "Riesgo Cardiovascular Alto";
                }
              resultado  =  String.format("%.2f %s", vICC,situacion);
              resultadoICC.setText(resultado);
            }
        }else if(boton == borrar){
            cadera.setText("");
            cintura.setText("");
            edad.setText("");
            peso.setText("");
            estatura.setText("");
            resultadoIMC.setText("");
            resultadoICC.setText("");
        }
        
    }
    
}
