/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package polinomio;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class Prueba {
    public static void main(String[] args) throws Exception {
        double[] a = {1,5,2,10};
        Polinomio p = new Polinomio(a);
        double[] raices = p.getRaices();
        System.out.println(p.getPolinomio());
        for (int i = 0; i < raices.length; i++) {
            System.err.println(" La raiz " +  i + " es " + raices[i]);
        }
    
    }
}
