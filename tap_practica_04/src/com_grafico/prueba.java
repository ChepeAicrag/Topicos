/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com_grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JFrame;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class prueba extends JFrame{
    public prueba(){
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        String[] tLeyenda = {"Leyenda de barra 1 ","Leyenda de barra 2 ","Leyenda de Barra 3 ","Leyenda de Barra 4 "};
        Grafico g = new Grafico("Muestra de valores", tLeyenda);
        add(g);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    
    public static void main(String[] args) {
        prueba b = new prueba();
    }
}
