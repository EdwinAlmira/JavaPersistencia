
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almira
 */
public class inicio {
    
    public static void main(String[] args){
        
        Conexion conex = new Conexion();
        try(Connection cnx = new Conexion().getConnection()) {
                
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
