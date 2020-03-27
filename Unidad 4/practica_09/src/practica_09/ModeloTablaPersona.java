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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ModeloTablaPersona extends AbstractTableModel{

    private List<Object[]> dato;
    private String encabezado[] = new String[]{
            "No.Iden","Nombre","Fecha Nac.","Sexo"};
    private Class tipos[] = new Class[]{
            String.class,String.class,String.class,String.class};
    
    public Class getComunClass(int c){
        return tipos[c];
    }
    
    @Override
    public int getRowCount() {
        return dato.size();
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
    
    public void setDatos(List<Object[]> d){
        dato = d;
    }
}
