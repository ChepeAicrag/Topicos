/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica_08;

import java.util.ArrayList;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class PruebaAccesoDatos {
    public static void main(String[] args) {
        ManejoDatos baseDatos = new ManejoDatos();
        System.out.println("---------------CONSULTA DE ACTIVIADES-----------");
        consulta_actividades(baseDatos);
        System.out.println("\n\n----------------CONSULTA DE PERSONAS------------");
        consulta_personas(baseDatos);
        System.out.println("\n\n----------------CONSULTA DE MEDICIONES------------");
        consulta_mediciones(baseDatos);
        
    }
    
    public static void consulta_personas(ManejoDatos baseDatos){
        String consulta = "SELECT * FROM chepe.PERSONA";
        ArrayList<Object[]> actividad = (ArrayList<Object[]>) baseDatos.conexionConsultaActividad(consulta);
        for (int i = 0; i < actividad.size(); i++) {
            Object [] reg = actividad.get(i);
            System.out.println("");
            for (int j = 0; j < reg.length; j++) {
                if(j > 0)
                System.out.printf("%-30s",reg[j]);
                else
                System.out.printf("%-10s",reg[j]);    
            }
        }
    } 
    public static void consulta_actividades(ManejoDatos baseDatos){
        String consulta = "SELECT * FROM chepe.TIPOACTIVIDAD";
        ArrayList<Object[]> actividad = (ArrayList<Object[]>) baseDatos.conexionConsultaActividad(consulta);
        for (int i = 0; i < actividad.size(); i++) {
            Object [] reg = actividad.get(i);
            System.out.println("");
            for (int j = 0; j < reg.length; j++) {
                System.out.printf("%-25s",reg[j]);
            }
        }
    }
    public static void consulta_mediciones(ManejoDatos baseDatos){
        String consulta = "SELECT * FROM chepe.MEDICIONES";
        ArrayList<Object[]> actividad = (ArrayList<Object[]>) baseDatos.conexionConsultaMediciones(consulta);
        for (int i = 0; i < actividad.size(); i++) {
            Object [] reg = actividad.get(i);
            System.out.println("");
            for (int j = 0; j < reg.length; j++) {
                System.out.printf("%-20s",reg[j]);
            }
        }
    }
    
}
