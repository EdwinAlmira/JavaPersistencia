
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almira
 */
public class Conexion {
    
    public Connection getConnection(){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/persistenciaPlatzi",
                    "almira","edwins24");
            if(conexion != null){
                System.out.println("Conexion exitosa");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conexion;
    }
    
}
