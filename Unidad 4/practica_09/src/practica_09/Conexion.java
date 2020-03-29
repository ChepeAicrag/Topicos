package practica_09;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * @author Garcia Garcia Jose Angel
 */
public class Conexion {
    private static Connection coneccion = null; // Contenida en el pquete SQL
    private static Conexion conexion = null; // instancia a utilizar
    private static  int numConexiones = 0; // controla el numero de veces que sucedio
    
    /**
     * Constructor privado porque 
     * Se evitará crear mas de una instancia de la clase
     * es decir, controlaremos la creacion de instancias
     * si se intenta crear mas de una, despues de la primera
     * se retornará la mismada crada al principio
     */
    
    private Conexion(String url, String usuario, String password){
        try {
            // Clase usada para una conexion con Derby
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // Para MySql : "com.mysql.jdbc.Driver"
            // Para Postgres : "org.postgresql.Driver"
            coneccion = DriverManager.getConnection(url,usuario, password);
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * El método tiene la funcion de 
     * incrementar el numero de conexiones solicitadas y ademas
     * verificar que se cree una unica instancia de Conexion; 
     * si ya existe, simplemente la retorna
     * Tiene que tener la firma de static porque no requiere de una instancia ya 
     * creada para ejecutarlo, debido a que primero ejecutamos el método y despues
     * su constructor.
     * 
     */
     public static Conexion getConexion(String url, String Usuario, String password){
        numConexiones++;
        if(conexion == null)
            return conexion = new Conexion(url, Usuario, password);
        return conexion;
     }
     
     public static Connection getConeccion(){
         return coneccion;
     }
     
    /**
     * El método tiene la función de cerrar la conexión
     * para ello comprueba que la variable coneccion sea una instancia,
     * es decir, que sea !null y posterior a ello comprueba nuevamente
     * que el numero de conexiones sea 1 para cerrarla y retornar true;
     * si no es igual a 1, simplemente decrementa el valor y no cierra
     * conexion porque como mencionamos al principio, solo trabajamos con 
     * una unica conexion, por lo que esta solo se cerrara cuando se tenga 
     * una conexion. Si la conexion es null simplemente retorna un false y si
     * hay problemas en tiempo de ejecucion al momento de cerrar 
     * la conexion las controla con el bloque try-catch y muestra el error
     * 
     * 
     */
    public boolean CerrarConexion(){
        try {
            if (coneccion != null) 
              if(numConexiones == 1){
                 coneccion.close();
                 return true;
            }else
                numConexiones--;
            return false;
        } catch (SQLException e) {
            System.err.println(" Error al tratar de cerrar la conexion " + e);
       }
        return false;
    }
    
    
}
