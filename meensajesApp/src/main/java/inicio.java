
import java.sql.Connection;
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
public class inicio {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        do {            
            System.out.println("__________________________");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. Editar mensaje");
            System.out.println("5. Salir");
            
            //Leemos la entrada
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    MensajesService.crearMensajes();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensajes();
                    break;
                case 4:
                    MensajesService.editarMensajes();
                    break;
                case 5:
                    System.out.println("Hasta la proxima");
                    break;
                default:
                    System.out.println("Use un digito valido\n");
                    break;
            }
            
        } while (opcion != 5);
        
    }
    
}
