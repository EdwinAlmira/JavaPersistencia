
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almira
 */
public class Inicio {
    
    public static void main(String[] args) throws IOException {
        int opcionMenu = -1;
        
        String[] botones = {
            "1. Ver gatos",
            "2. Salir"
        };
        
        do {            
             String opcion = (String) (JOptionPane.showInputDialog(null, 
                     "Gatitos java", "Menu principal", 
                     JOptionPane.INFORMATION_MESSAGE, null, 
                     botones, botones[0]));
             
             //Validando opcion seleccionada
             for (int i = 0; i < botones.length; i++) {
                 if (opcion.equals(botones[i])) {
                     opcionMenu=i;
                 }
            }
             
             switch(opcionMenu){
                case 0:
                    GatoService.verGatos();
                     break;
                default:
                    break;
             }
             
        } while (opcionMenu!=1);
    }
    
}
