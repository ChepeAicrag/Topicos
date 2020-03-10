/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package polinomio;

import java.io.Serializable;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class Polinomio implements Serializable{
    protected double coeficiente[];
    protected static int  MAX_GRRADO = 3;
    protected static int MIN_GRADO = 1;
    protected int grado;
    
    public Polinomio(){
        coeficiente = new double[MAX_GRRADO+1];
        for (int i = 0; i <= MAX_GRRADO; i++) {
            coeficiente[i] = 0.0d;
        }
    }
    
    public Polinomio(double[] coeficiente) throws Exception{
        grado = coeficiente.length-1;
        if (coeficiente.length > 1) {
            this.coeficiente = coeficiente;
        }else{
            throw new Exception("Numero de coeficientes debe ser > 1");
        }
    }
    
    public void setCoeficiente(double coefs[]){
        grado = coefs.length-1;
        if(coefs.length > 1){
            coeficiente = coefs;
        }
    }
    
    public int getGrado(){
       return grado;
    }
    
    public double[] vals(){
        double[] co = new double[coeficiente.length];
        for (int i = 0; i < coeficiente.length; i++) {
            co[i] = coeficiente[i];
        }
        return co;
    }
    
    public double getY(double x){
        double y = 0.0;
        for (int i = 0; i <= grado; i++) {
            y += coeficiente[i]*Math.pow(x, i);
        }
        return y;
    }
    
    public double getDerFX(double x){
        double dx = 0.0;
        for (int i = 1; i < grado; i++) {
            dx += i * coeficiente[i]*Math.pow(x, i-1);
        }
        return dx;
    }
    
    public String getPolinomio(){
        String polinomio = "";
      for ( int i = 0; i <= grado; i++ ) {
         if ( coeficiente[i] != 0 ){
            if ( i != 0 && coeficiente[i] > 0) 
                polinomio += "+";
            if ( coeficiente[i] != 1 || i == 0 ) 
                polinomio +=  + coeficiente[i];
            if ( i > 0 ) 
                polinomio += "x";
            if ( i > 1 ) 
                polinomio += "^" + i;
         }
      }
        return polinomio;
    }
    
    // Para cuando es de grado 1
    public double[] getRaices() throws Exception{
        double x[] = null;
        if (grado == 1) {
            x = new double[grado];
            if (coeficiente[0] != 0) {
                x[0] = -1*coeficiente[0]/coeficiente[1];
            }else{
                throw new Exception("Coefciente debe X deber ser != 0");
            }
        }else if(grado == 2){
            x = new double[4];
            double a = coeficiente[2];
            double b = coeficiente[1];
            double c = coeficiente[0];
            double rad = Math.pow(b, 2.0) - 4*a*c;
            if(rad >= 0){
                x[0] = (-b + Math.sqrt(rad))/(2*a);
                x[1] = (-b - Math.sqrt(rad))/(2*a);
            }else{ // Raices imaginarias
                x[0] = x[2] = -b/(2*a); // parte real
                x[1] = + Math.sqrt(Math.abs(rad))/(2*a); // Parte imaginaria + /
                x[3] = - Math.sqrt(Math.abs(rad))/(2*a); // Parte imagina -
           }
        }else if(grado > 2){
            // Utilizando el método de newton raphson
            final int MAX_ITERA = 100;
            final double PRECISION = 0.001;
            x = new double[grado];
            double error = 999999.0, x1 = 0;
            int i = 0, n = 0;
            for (n = 0; n < grado-2; n++) {
                i = 0;
                do {              
                    x1 = x1 - getY(x1) / getDerFX(x1);
                    i++;
                } while (Math.abs(getY(x1)) > error && i == MAX_ITERA  );
                    x[n] = x1;
                }
        }
        return x;
    } 
}
