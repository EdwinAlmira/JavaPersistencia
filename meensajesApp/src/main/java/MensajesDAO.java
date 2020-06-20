
import com.mysql.cj.Messages;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almira
 */
public class MensajesDAO {
    
    static Conexion dbConnect = new Conexion();
    
    public static void crearMensajesDB(Mensajes mensajes){
        
        
        try(Connection conx = dbConnect.getConnection()) {
            
            PreparedStatement ps = null;
            try {
                String query="INSERT INTO mensajes(mensaje, autor) value (?,?)";
                ps=conx.prepareStatement(query);
                ps.setString(1,mensajes.getMensaje());
                ps.setString(2, mensajes.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("El mensajes creado efectivamente");
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
        
    }
    
    public static void borrarMensajesDB(int idMensaje){
        
    }
    
    public static void actualizarMensajesDB(Mensajes mensajes){
        
    }
}
