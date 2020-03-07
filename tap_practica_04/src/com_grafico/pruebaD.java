/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com_grafico;

import javax.swing.JFrame;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class pruebaD extends JFrame{
    public pruebaD(){
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        String[] tLeyenda = {"Leyenda de barra 1 ","Leyenda de barra 2 ",
                        "Leyenda de barra 3 ","Leyenda de barra 4 ","Leyenda de barra 5 "};
        Grafico g = new Grafico("Muestra con 5 valores", tLeyenda);
        int[] a = {10,30,20,15,18};
        g.setValores(a);
        add(g);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    
    public static void main(String[] args) {
        pruebaD b = new pruebaD();
    }
}
