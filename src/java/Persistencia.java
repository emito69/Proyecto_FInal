
//import jakarta.jms.Connection;
//import com.sun.istack.logging.Logger;
//import jakarta.resource.cci.ResultSet;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;


public class Persistencia {
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSetMetaData rsm;
    
    public String servidor, puerto, basededatos, usuario, clave, ejecutar;
    
    public Connection conectarse(){
        
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        servidor = "localhost";
        puerto = ":3306";
        basededatos="cacproyecto";
        usuario= "root";
        clave="";
                                            /*jdbc:mysql://localhost:3306/conexion*/
        cn = DriverManager.getConnection("jdbc:mysql://" + servidor + puerto +"/" + basededatos+"?autoReconnect=true&useSSL=false",
                                    usuario, clave);
        
        
           } catch(Exception e){
            System.out.println("Error de Conexion");   
             }
        return cn;
    }
    
    public  ResultSet consultaSQL(String busqueda){
        try {
            ps = conectarse().prepareStatement(busqueda);
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
                    
        }catch(Exception e){
            // Logger.getLogger(busqueda, componentClass)
            System.out.println("Error de Conexion");   
        }
        return rs;
    }
    
    
    
}
