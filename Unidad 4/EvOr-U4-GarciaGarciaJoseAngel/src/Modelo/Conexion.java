

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * @author Garcia Garcia Jose Angel
 */
public class Conexion {

    private String host = "localhost";
    private String usuario = "postgres";
    private final String clave = "Dexter1998";
    private int puerto = 5432;
    private String servidor = "";
    private String baseDatos;
    private static Connection conexion = null;

    public Conexion(String baseDatos) {
        this.baseDatos = baseDatos;
        ConexionBd();
    }

    private void ConexionBd() {
        this.servidor = "jdbc:postgresql://" + host + ":" + puerto + "/" + baseDatos;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER " + e);
            System.exit(0);
        }
        try {
            conexion = DriverManager.getConnection(this.servidor,
                    this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); 
        }
        System.out.println("Conectado a " + baseDatos);
    }

    private Connection getConexion() {
        return conexion;
    }

    public void closeConexion() {
        if (getConexion() != null) {
            try {
                getConexion().close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la bd " + e);
            }
        }
    }
    // Hacer el registro del servicio dado un id empleado y un id de caja
    public  boolean insertServicio(int empleado,int caja){
        String sql = "insert into scsupermarket.aperturaservicio values (?,?, now(),now())";
        PreparedStatement ps;
        try{
             ps  = getConexion().prepareStatement(sql);
             ps.setInt(1, empleado);
             ps.setInt(2, caja);
              ps.executeUpdate();
              return true;
        }catch(SQLException e){
            System.err.println("Error en la INSERCIÓN " + e );
            return false;
        }
    }
    // Consulta los servicios 
    public List<Object[]> listServicios(){
         PreparedStatement ps;
         ResultSet rs;
         String consultaSQL = "select numerocaja, empleado.numempleado, primerapellido || ' ' || segundoapellido|| ' ' || nombre as nomempleado, apertura from \n" +
"scsupermarket.aperturaservicio natural join scsupermarket.empleado;";
         ArrayList<Object[]> datos = new ArrayList<>();
        try{
             ps  = getConexion().prepareStatement(consultaSQL);
                      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            
            //Recorrer el resultado para agregar al arraylist
            while(rs.next()){
               //Añadir registro a registro en el vector
               String dat[] = new String[3];
               dat[0] = rs.getString(1);
               dat[1] = rs.getString(3);
               dat[2] = rs.getString(4);
                datos.add(dat);
            }
 
        }catch (SQLException e) {
            System.err.println("Error al consultar cajas" + e );
        }
        return datos;
    }
    
    //Ver que cajas y empleados estan libres
     public List<Integer> disponibles(String sql){  
        PreparedStatement ps;
        ResultSet rs;
        List<Integer> datos = new ArrayList<>();
        try{
            ps = getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                datos.add(rs.getInt(1));
            }
 
        }catch (SQLException e) {
            System.err.println("Error en la consulta " + e );
        }
        return datos;
    }
     // Para poner ocupada la caja
      public boolean updateCaja(int id){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlUpdate = "update scsupermarket.caja set estado = ? where numerocaja = ?;";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlUpdate);
                
            //Indicar qué información se pasa al procedimiento
            ps.setBoolean(1,false);
            ps.setInt(2, id);
            //Ejecutar el procedimiento
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            System.err.println("Error en la MODIFICACION  " + e);
            return false;
        }
    }
    
}
    