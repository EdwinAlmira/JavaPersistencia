
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

    static Scanner sc = new Scanner(System.in);
    
    public static void crearMensajes(){

        String autor;
        String mensaje;
        System.out.println("\nEscribe tu mensaje");
        mensaje = sc.nextLine();
        System.out.println("\nEscribe tu nombre");
        autor = sc.nextLine();
        
        Mensajes mensajes = new Mensajes();
        mensajes.setMensaje(mensaje);
        mensajes.setAutorMensaje(autor);
        MensajesDAO.crearMensajesDB(mensajes);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensajes(){
        int idMensaje;
        System.out.println("Cual es el id del mensaje a borrar:");
        idMensaje = sc.nextInt();
        MensajesDAO.borrarMensajesDB(idMensaje);
    }
    
    public static void editarMensajes(){
        String mensajeNuevo;
        String autor;
        int idMensaje;
        
        System.out.println("Cual es el id del mensaje a editar:");
        idMensaje = Integer.parseInt(sc.nextLine());
        System.out.println("Actualiza el mensaje: ");
        mensajeNuevo = sc.nextLine();
        System.out.println("Actualiza el autor del mensaje:");
        autor = sc.nextLine();
        
        Mensajes mensajito = new  Mensajes();
        
        mensajito.setId_mensaje(idMensaje);
        mensajito.setMensaje(mensajeNuevo);
        mensajito.setAutorMensaje(autor);
        MensajesDAO.actualizarMensajesDB(mensajito);
    }
    
}
