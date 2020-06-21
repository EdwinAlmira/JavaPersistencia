
import com.mysql.cj.Messages;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            conx.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
    }
    
    public static void leerMensajesDB(){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try(Connection conx = dbConnect.getConnection()) {
        
            String query="SELECT * FROM mensajes";
            ps=conx.prepareStatement(query);
            rs=ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID: "+ rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+ rs.getString("mensaje"));
                System.out.println("Autor: "+ rs.getString("autor"));
                System.out.println("Fecha: "+ rs.getString("fecha"));
                System.out.println("\n");
            }
            conx.close();
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void borrarMensajesDB(int idMensaje){
        
        
        try(Connection conx = dbConnect.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps=conx.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.err.println("Mensaje borrado");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void actualizarMensajesDB(Mensajes mensajes){
        try(Connection conx = dbConnect.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ?, autor=? WHERE id_mensaje = ?";
                ps=conx.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setString(2, mensajes.getAutorMensaje());
                ps.setInt(3, mensajes.getId_mensaje());
                ps.executeUpdate();
                System.err.println("Mensaje editado");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
