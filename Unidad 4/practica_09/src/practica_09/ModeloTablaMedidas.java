
package practica_09;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class ModeloTablaMedidas extends AbstractTableModel{
    
    private List<Object[]> dato;
    private String encabezado[] = new String[]{
            "IdMed","Fecha","Estaura(cms)","Peso(kg)","Cintura(cm)","Cadera(cm)","Tipo act"};
    private Class tipos[] = new Class[]{
            String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    
    
    public void setDatos(List<Object[]> d) {
        dato = d;
    }

    @Override
    public Class getColumnClass(int c){
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
        return encabezado.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return dato.get(r)[c];
    }
    @Override
    public String getColumnName(int col){
        return encabezado[col];
    }
    

}
