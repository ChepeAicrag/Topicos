

package testcomponente;

import javax.swing.JFrame;
import misComponentes.JPForm;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class TestComponente3 extends JFrame{
    
    public TestComponente3(){
        String[] nombres = {"Pedro","Juan","Marlen","Ramiro","Manuel","Angel"};
        String[] tipo = {"JTextField","JTextField","JTextField","JTextField","JTextField","JTextField"};
        JPForm j = new JPForm(nombres, tipo);
        add(j);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    public static void main(String[] args) {
        new TestComponente3();
    }
}
