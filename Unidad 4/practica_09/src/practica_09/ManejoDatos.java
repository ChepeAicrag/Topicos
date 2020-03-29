package practica_09;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static sun.java2d.cmm.ColorTransform.In;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class ManejoDatos {
    private Connection conexion ; // Acceso a conexion
    private Conexion crearConexion;// Crea conexion
    private final int CAMPOS_PERSONA = 4;    
    private final int CAMPOS_ACTIVIDAD = 3;
    private final int CAMPOS_MEDICIONES = 8;
    
    public ManejoDatos(){
        try{
        String usuario = "chepe",contraseña = "chepe123";
        crearConexion = crearConexion.getConexion("jdbc:derby://localhost:1527/mediciones_personas",usuario,contraseña);
        conexion = crearConexion.getConeccion();
        }catch(Exception e){
        }
    }
    
    public List <Object[]> conexionConsultaPersona(String sql){
        // Regresa los registros de las personas en una lista
        List <Object []> datos = new ArrayList<Object[]>();
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                // Estructura del registro de persona pasado como cadena
                String[] dat = new String[CAMPOS_PERSONA];
                dat[0] = String.valueOf((Integer) rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = fecha.format((Date) rs.getDate(3));
                dat[3] = rs.getString(4);
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar personas " + e);
        }
        return datos;
    }
    
    public List <Object[]> conexionConsultaActividad(String sql){
        // Regresa los registros de actividad
        List <Object[]> datos = new ArrayList<Object[]>();
        try {
           Statement ps = conexion.createStatement();
           ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                // Estructura del registro activiad
                String [] dat = new String[CAMPOS_ACTIVIDAD];
                dat[0] = String.valueOf(rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = rs.getString(3);
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar actividades " + e);
        }
        return datos;
    }
    
    public List <Object[]> conexionConsultaMediciones(String sql){
        // Regresa los registros de actividad
        List <Object[]> datos = new ArrayList<Object[]>();
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
           Statement ps = conexion.createStatement();
           ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                // Estructura del registro activiad
                String [] dat = new String[CAMPOS_MEDICIONES];
                dat[0] = String.valueOf((Integer)rs.getInt(1));
                dat[1] = fecha.format((Date) rs.getDate(2));
                dat[2] = String.valueOf((Integer) rs.getInt(3));
                dat[3] =  String.valueOf((Double) rs.getDouble(4));
                dat[4] = String.valueOf((Integer) rs.getInt(5));
                dat[5] = String.valueOf((Integer) rs.getInt(6));
                dat[6] = String.valueOf((Integer) rs.getInt(7));
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar mediciones " + e);
        }
        return datos;
    }

    public boolean actualizaDatos(String SQL) {
        // Inserta actualiza o elimina
        System.out.println(SQL);
        boolean res = false;
        try {
            java.sql.Statement st = conexion.createStatement();
            st.executeUpdate(SQL);
            res = true;
            System.out.println((SQL.contains("INSERT")) ? "Se insertó" : "Se eliminó");
        } catch (Exception e) {
            System.err.println("Error al INSERTAR / ACTUALIZAR\n " + e);
        }
        return res;
    }
    
}
