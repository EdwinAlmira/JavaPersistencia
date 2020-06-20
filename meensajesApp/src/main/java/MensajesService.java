
import com.google.protobuf.Internal;
import com.google.protobuf.TextFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almira
 */
public class MensajesService {

    public static void crearMensajes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEscribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("\nEscribe tu nombre");
        String autor = sc.nextLine();
        
        Mensajes mensajes = new Mensajes();
        mensajes.setMensaje(mensaje);
        mensajes.setAutorMensaje(autor);
        MensajesDAO.crearMensajesDB(mensajes);
    }
    
    public static void listarMensajes(){
        
    }
    
    public static void borrarMensajes(){
        
    }
    
    public static void editarMensajes(){
        
    }
    
}
