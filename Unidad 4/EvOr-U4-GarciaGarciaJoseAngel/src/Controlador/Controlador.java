
package Controlador;

import Modelo.Conexion;
import Vista.ModeloTablaCajas;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 
 * @author García García José Ángel
 */
public class Controlador implements ActionListener,FocusListener{

    private Conexion m;
    private Vista v;
    
    public Controlador(Conexion m, Vista v){
        this.m = m;
        this.v = v;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String op = ae.getActionCommand();
        switch(op){
            case "abrir":
                int caja = v.listaCajas.getSelectedIndex()+1;
                int empleado = v.listaEmpleados.getSelectedIndex() + 1;
                if(caja >= 0 && empleado >= 0){
                    m.insertServicio(empleado, caja); // Insertamos el registro
                    v.cerrar.setVisible(true); // Mostramos la opcion cerrar
                    ModeloTablaCajas mod = new ModeloTablaCajas();
                    mod.setDatos(m.listServicios());
                    v.tablaCajas.setModel(mod);
                    v.tablaCajas.setVisible(true);
                   v.hTab.setVisible(true);
                    // Quitamos del registro el seleccionado
                    v.listaCajas.removeItemAt(caja-1);
                    v.listaEmpleados.removeItemAt(empleado-1);
                    consultarCajasCerradas();
                    consultarEmpleadoDisponible();
                    v.tablaCajas.updateUI();
                }
                break;
            case "listaEmpleados":
                consultarEmpleadoDisponible();
                break;
            case "listaCajas":
                consultarCajasCerradas();
                break;
            case "cerrar":
                int index = v.tablaCajas.getSelectedRow();
                if(index >= 0){
                    int id = Integer.parseInt((String) v.tablaCajas.getValueAt(index, 0));
                    m.updateCaja(id);
                    ModeloTablaCajas mod = new ModeloTablaCajas();
                    mod.setDatos(m.listServicios());
                    v.tablaCajas.setModel(mod);
                    v.tablaCajas.updateUI();
                }
                break;
                    
        }
       
    
    }
private void consultarCajasCerradas(){
        if(v.listaCajas.getItemAt(0) == null){
            String sql = "select numerocaja from scsupermarket.caja where estado = true";
            List<Integer> dis = m.disponibles(sql);
            v.listaCajas.removeAllItems();
            for(Integer d : dis){
            v.listaCajas.addItem(d);
             }
        }
    }
private void consultarEmpleadoDisponible(){
        if(v.listaEmpleados.getItemAt(0) == null ){
        /*String sql = "select empleado.numempleado, primerapellido || ' ' || segundoapellido|| ' ' || nombre as nomempleado from empleado  natural join \n" +
"(select numempleado from empleado except (\n" +
" select numempleado from aperturaservicio where cierre is null) )";
        
           
SELECT * --e.numempleado as id_empleado,nombre as name_empl
from empleado as e left join aperturaservicio as a
ON e.numempleado = a.numempleado
where a.numempleado is null; 
            
            
            */
        String sql = " SELECT numempleado,nombre \n" +
        "from scsupermarket.empleado\n" +
        "where numempleado not in (select numempleado from scsupermarket.aperturaservicio);";
        List<Integer> dis = m.disponibles(sql);
        v.listaEmpleados.removeAllItems();
        for(Integer d : dis){
           v.listaEmpleados.addItem(d);
            }
        }
}

    @Override
    public void focusGained(FocusEvent fe) {
        consultarCajasCerradas();
        consultarEmpleadoDisponible();
    }

    @Override
    public void focusLost(FocusEvent fe) {
    }
}
