/*
 * Nuevo componente, llamado "MiBoton" 
 */
package misComponentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * @author Garcia Garcia Jose Angel
 */
public class MiBoton extends JButton{
    private String txt;

    public MiBoton(){
        super();
        txt = "etqiueta";
        super.setText(txt);
    }
    
    public MiBoton(String txt){
        super(txt);
        apariencia();
    }

    public MiBoton(String txt, ImageIcon iconoOriginal,int ancho, int alto){
        super(txt,new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
        apariencia();
    }
    
    public MiBoton(ImageIcon iconoOriginal,int ancho, int alto){
        super(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
        apariencia();
    }
    
    private void apariencia() {
        this.setBorder(null);
        this.setContentAreaFilled(true);
        this.setOpaque(true);
        this.setFont(new Font("Arial", Font.BOLD, 15));
        this.setBackground(Color.white);
        this.setForeground(Color.blue);
        this.setPreferredSize(new Dimension(200, 40));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setSize(100, 20);
    }
}
