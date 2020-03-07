/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com_grafico;

import javax.swing.JFrame;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class pruebaC extends JFrame{
    public pruebaC(){
        setSize(800, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        String[] tLeyenda = {"Leyenda de barra 1 ","Leyenda de barra 2 "};
        Grafico g = new Grafico("Muestra con 2 valores", tLeyenda);
        int[] a = {10,30};
        g.setValores(a);
        add(g);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    
    public static void main(String[] args) {
        pruebaC b = new pruebaC();
    }
}
