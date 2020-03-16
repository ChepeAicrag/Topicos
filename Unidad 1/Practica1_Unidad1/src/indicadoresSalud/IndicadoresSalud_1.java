/*
 * GUI sin LayoutManager
 */
package indicadoresSalud;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author García García José Ángel
 */
public class IndicadoresSalud_1 extends JFrame implements ActionListener{
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
   
   public IndicadoresSalud_1(){
       String path = "/imagenes/bascula.png"; //Ubicacion de la imagen
       setSize(340,650);
       URL ur1 = this.getClass().getResource(path); //Obtiene un recurso de la ubicacion
       ImageIcon icon = new ImageIcon(ur1); // Crea un objeto ImageIcon a partir del recurso
       //Creacion y cosntruccion del titulo principal
       JLabel presentacion = new JLabel("INDICADORES BASICOS DE RIESGOS A LA SALUD",icon,SwingConstants.CENTER);
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
       System.out.println(getWidth());
       presentacion.setBounds(0,0,getWidth(), 220);
       tEdad.setBounds(50, 220, getWidth(), 20);
       edad.setBounds(210, 220, 40, 20);
       tIMC.setBounds(10, 260, getWidth(), 20);
       tEstatura.setBounds(80, 290, getWidth(), 20);
       estatura.setBounds(180, 290, 40, 20);
       tPeso.setBounds(80, 315, getWidth(), 20);
       peso.setBounds(180, 315, 40, 20);
       cIMC.setBounds(10, 340, 105, 25);
       resultadoIMC.setBounds(125, 340, 250, 25);
       presentacion.setHorizontalTextPosition(SwingConstants.CENTER);
       presentacion.setVerticalTextPosition(SwingConstants.TOP);
       tICC.setBounds(10, 380, getWidth(), 20);
       tCintura.setBounds(80, 410, getWidth(), 20);
       cintura.setBounds(180, 410, 40, 20);
       tCadera.setBounds(80, 435, getWidth(), 20);
       cadera.setBounds(180, 435, 40, 20);
       tSexo.setBounds(40, 460, getWidth(), 20);
       hombre.setBounds(100, 460, 80, 20);
       mujer.setBounds(200, 460, 80, 20);
       cICC.setBounds(10, 500, 105, 25);
       resultadoICC.setBounds(125, 500, 250, 25);
       borrar.setBounds(100, 535, 120, 20);
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
       setLayout(null);
       setLocationRelativeTo(null);
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
                  situacion = "PESO BAJO";
              else if(vIMC > 18.5 && vIMC < 24.9)
                  situacion = "PESO NORMAL";
              else if(vIMC > 25 && vIMC < 29.9)
                  situacion = "SOBRE PESO";
              else 
                  situacion = "OBESIDAD";
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
                        situacion = "Riesgo Cardiovascular BAJO";
                    else if(vICC > 0.95 && vICC < 1)
                        situacion = "Riesgo Cardiovascular MEDIO";
                    else 
                        situacion = "Riesgo Cardiovascular ALTO";
                }else{
                    if(vICC <= 0.80 )
                        situacion = "Riesgo Cardiovascular BAJO";
                    else if(vICC > 0.80 && vICC < 0.85)
                        situacion = "Riesgo Cardiovascular MEDIO";
                    else 
                        situacion = "Riesgo Cardiovascular ALTO";
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
            resultadoIMC.setText("_ _ _ _ _ _ _ _ _ _");
            resultadoICC.setText("_ _ _ _ _ _ _ _ _ _");
        }
        
    }
    
}
