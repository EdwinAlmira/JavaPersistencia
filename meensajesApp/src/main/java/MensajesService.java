
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
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensajes(){
        System.out.println("Cual es el id del mensaje a borrar:");
        Scanner sc = new Scanner(System.in);
        int idMensaje = sc.nextInt();
        MensajesDAO.borrarMensajesDB(idMensaje);
    }
    
    public static void editarMensajes(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Cual es el id del mensaje a editar:");
        int idMensaje = sc.nextInt();
        System.out.println("Actualiza el mensaje: ");
        String mensajeNuevo = sc.nextLine();
        
        System.out.println("Actualiza el autor del mensaje:");
        String autor = sc1.nextLine();
        
        Mensajes mensajito = new  Mensajes();
        mensajito.setId_mensaje(idMensaje);
        mensajito.setMensaje(mensajeNuevo);
        mensajito.setAutorMensaje(autor);
        MensajesDAO.actualizarMensajesDB(mensajito);
    }
    
}
