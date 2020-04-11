package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author García García José Ángel
 */
public class Ventana extends JFrame{

   private JPanel principal; 
   private JLabel fondo;
    
   public Ventana(){
       principal = (JPanel) getContentPane();
       setSize(1920,1280);
       fondo = imageFondo();
       add(fondo);
       setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setResizable(false);
       setLocationRelativeTo(null);
   }
   
   public JLabel imageFondo(){
       ImageIcon img = new ImageIcon("/imagenes/inicio1.jpg");
       ImageIcon icono = new ImageIcon(img.getImage().getScaledInstance(1000, 1000,Image.SCALE_DEFAULT));
       JLabel p = new JLabel("Hola", icono, SwingConstants.CENTER);
       p.setOpaque(true);
       return p;
   }
    
}
