/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.websemantique;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.*;

/**
 *
 * @author Flo Macé
 */
public class GoogleCustomSearchEngine {
    
    String customEngineIdentifier;
    String APIKey;
    
    //String customEngineIdentifier = "001556729754408094837:r86b9hjdnoe";
    //String key = "AIzaSyDmE16v9wqfViMfWWxkW07qCQQn2Or0uMI";
    
    public GoogleCustomSearchEngine() {
    }
    
    public GoogleCustomSearchEngine (String key, String cx){
        APIKey = key;
        customEngineIdentifier = cx;
    }
    
    public void RequestSearch(String searchText) throws IOException{
        try {
            final String RESOURCE_STR = "http://dbpedia.org/resource/";
            final String PAGE_STR = "http://dbpedia.org/page/";
            final String RESOURCE_PATH = "ressources.txt";

            URL url = new URL("https://www.googleapis.com/customsearch/v1?key="+APIKey+ "&cx="+ customEngineIdentifier +"&q="+    searchText+"&alt=json");
            HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
            
            conn2.setRequestMethod("GET");
            conn2.setRequestProperty("Accept", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn2.getInputStream())));
            
            String res;
            String jsonString = "";
            
            while((res = br.readLine()) != null)
            {
                jsonString += res;
            }
            
            JSONObject requestResult = new JSONObject(jsonString);
            JSONArray items = requestResult.getJSONArray("items");
            
            List<String> ressourceLinks = new ArrayList();
            List<String> pageLinks = new ArrayList();
            
            for (int i = 0; i < items.length(); i++)
            {
                JSONObject obj = items.getJSONObject(i);
                String link = obj.getString("link");
                
                if (link.startsWith(RESOURCE_STR))
                {
                    ressourceLinks.add(link);
                }
                else if (link.startsWith(PAGE_STR))
                {
                    pageLinks.add(link);
                }
            }
            
            System.out.println("Ressources:\n");
            for (String l : ressourceLinks)
            {
                System.out.println(l);
            }
            
            System.out.println("\nPages:\n");
            for (String l : pageLinks)
            {
                System.out.println(l);
            }
            File ressource_file = new File(RESOURCE_PATH);
            BufferedWriter writer = new BufferedWriter(new FileWriter(ressource_file));
            for (String l : ressourceLinks)
            {
                writer.write(l);
                writer.newLine();
            }
            
            writer.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(GoogleCustomSearchEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
