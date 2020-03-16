
package VistaConversor;

import ControladorConversor.ConversorControlador;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Garcia Garcia Jose Angel
 */

public class Ventana extends JFrame{
    // Propiedades
    private JPanel contentPane;
    private JTextField txtImporte;
    private JButton btnConvertir;
    private JComboBox<String> comboDivD;
    private JComboBox<String> comboDivO;
    private JLabel lblResultado;
    private JLabel lblImporte;
    private JLabel lblConvertir;
    
    // Constructor
    public Ventana(){
        setTitle("Conversor de Monedas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setBounds(100,100,309,237);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout());
        
        lblImporte = new JLabel("Introduce importe");
        lblImporte.setFont(new Font("Calibri", Font.BOLD, 12));
        contentPane.add(lblImporte);
        
        txtImporte = new JTextField();
        contentPane.add(txtImporte);
        txtImporte.setColumns(10);
        
        comboDivO = new JComboBox<>();
        contentPane.add(comboDivO);
        
        lblConvertir = new JLabel("Convertir a :");
        lblConvertir.setFont(new Font("Calibri", Font.BOLD, 12));
        contentPane.add(lblConvertir);
        
        comboDivD = new JComboBox<>();
        contentPane.add(comboDivD);
        
        btnConvertir = new JButton("Convertir");
        btnConvertir.setFont(new Font("Calibri",Font.BOLD,12));
        contentPane.add(btnConvertir);
        
        JSeparator separator = new JSeparator();
        contentPane.add(separator);
        
        lblResultado = new JLabel("Resultado");
        lblResultado.setFont(new Font("Calibri", Font.BOLD, 18));
        contentPane.add(lblResultado);
     }
    
    public void arrancar(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    pack();
                    setVisible(true);
                    setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Double obtenerImporte(){
        try {
            return Double.valueOf(txtImporte.getText());
        } catch (NumberFormatException e) {
            return 0.0D;
        }
    }
    
    public String obtenerDivisaOrigen(){
        return comboDivO.getSelectedItem().toString();
    }
    
    public String obtenerDivisaDestino(){
        return comboDivD.getSelectedItem().toString();
    }
    
    public void actualiazarResultado(String importe){
        lblResultado.setText(String.valueOf(obtenerImporte() + ""+ obtenerDivisaOrigen() + "=" + importe + "" + obtenerDivisaDestino()));
    }
    
    public void setComboDivisas (Enumeration<String> codigosMonedas){
        String elemento;
        while(codigosMonedas.hasMoreElements()){
            elemento = codigosMonedas.nextElement();
            // Añadimos elementos a ambos combox 
            comboDivD.addItem(elemento);
            comboDivO.addItem(elemento);
        }
    }
    
    public void conectarControaldor(ConversorControlador controlador){
        btnConvertir.addActionListener((ActionListener) controlador);
    }
}
