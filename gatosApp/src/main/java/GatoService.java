
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class GatoService {
    
    public static void verGatos() throws IOException{

        //Llamando a la api
        String elJson;
        OkHttpClient client;
        client = new OkHttpClient();
        Request request = new Request.Builder()
          .url("https://api.thecatapi.com/v1/images/search")
          .method("GET", null)
          .build();
        Response response = client.newCall(request).execute();
        elJson = response.body().string();
      
        //Cortar primer y ultimo caracter
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);

        //crear objeto Gson
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);

        //Redimensionar imagen
        Image image = null;
        try {
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            
            ImageIcon fondoGato = new ImageIcon(image);
            
            if(fondoGato.getIconWidth() > 800){
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }
            
            String menu = "Opciones: \n"+"1. Ver otra imagen\n"+"2. Marcar como favorito\n"+"3. Volver al menu\n";
            String[] botones = { "Ver otra imagen","Marcar como favorito","Volver al menu"};
            String id_gato = String.valueOf(gatos.getId());
            String opcion = (String) JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE, 
                    fondoGato, botones, botones[0]);
            int seleccion = -1;
            for (int i = 0; i < botones.length; i++) {
                if(opcion.equals(botones[i])){
                    seleccion = i;
                }
                
            }
            switch(seleccion)
            {
                case 0:
                    verGatos();
                     break;
                case 1:
                    favoritoGato(gatos);
                default:
                    break;
            }
            
        } catch (IOException e) {
            System.out.println(e);
        }
      
    }
    
    public static void favoritoGato(Gatos gatos) throws IOException {
                
        try {
            
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body;
            body = RequestBody.create(mediaType, "{\n    \"image_id\": \""+gatos.getId()+"\"\n}");
            Request request = new Request.Builder()
              .url("https://api.thecatapi.com/v1/favourites")
              .method("POST", body)
              .addHeader("Content-Type", "application/json")
              .addHeader("x-api-key", "5825e367-0bb3-47dd-8935-02af52704ff9")
              .addHeader("Cookie", "__cfduid=d098d4bbf71777c1fe663d2bbe245bee11592855708")
              .build();
            Response response = client.newCall(request).execute();
            
        } catch (IOException e) {
        }
        
    }
    
}
