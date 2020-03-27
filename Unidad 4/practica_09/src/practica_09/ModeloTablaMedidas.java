/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica_09;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class ModeloTablaMedidas extends AbstractTableModel{
    
    private List<Object[]> dato;
    private String encabezado[] = new String[]{
            "No.Iden","Nombre","Fecha Nac.","Sexo"};
    private Class tipos[] = new Class[]{
            String.class,String.class,String.class,String.class};
    
    public void setDatos(List<Object[]> d) {
        dato = d;
    }

    public Class getComunClass(int c){
        return tipos[c];
    }
    
    @Override
    public int getRowCount() {
        try{
        return dato.size();
        }catch(Exception e){
            return 0;
            }
     }

    @Override
    public int getColumnCount() {
        return tipos.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return dato.get(r)[c];
    }
    
    public String getComunName(int col){
        return encabezado[col];
    }
    

}
