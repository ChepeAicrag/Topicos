/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barraherramientas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Test de barra con Arreglo de Botones
 *
 * @author Garcia Garcia Jose Angel
 */
public class TestImagen extends JFrame implements KeyListener {

    public TestImagen() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BarraHerramienta tes = vector();
        add(tes);
    }

    public static void main(String[] args) {
        new TestImagen();
    }

    public BarraHerramienta vector() {
        String[] botones = {"hola", "hola2", "hola3"};
        return new BarraHerramienta(botones); // Creado con un arreglo de botones
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        JOptionPane.showMessageDialog(this, "Hola");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
