package tp.websemantique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DBpediaSpotlightClient {

    private final static String API_URL = "http://spotlight.sztaki.hu:2222/";
    private static Exception SpotlightCallException;

    public static String getSpotlightResponse(String text, double confidence, int support) throws IOException {
            String url =    API_URL + "rest/annotate/?"
                            + "confidence=" + confidence
                            + "&support=" + support
                            + "&text=" + URLEncoder.encode(text, "utf-8");

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
            }
            in.close();

            return response.toString();
    }
    
    public static LinkedList<String> extractURI (String htmlSource)
    {
        LinkedList<String> listUri = new LinkedList<>();
        Document doc = Jsoup.parse(htmlSource);
        
        Elements body = doc.getElementsByTag("body");
        Elements uriElements = body.get(0).getElementsByTag("a");
        
        for(Element balise  : uriElements)
        {
            listUri.push(balise.attributes().get("title"));
        }
            
        return listUri;
    }
    
    public static LinkedList<String> callAPI(String text) throws Exception
    {
        String htmlResponse = "";       
        try {
            htmlResponse = DBpediaSpotlightClient.getSpotlightResponse(text, 0.5, 0);
        } catch (IOException ex) {
            Logger.getLogger(DBpediaSpotlightClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return extractURI(htmlResponse);
    }
    
    public static void main(String[] args)
    {
        String test = "First documented in the 13th century, Berlin was the capital"
                + " of the Kingdom of Prussia (1701–1918), the German Empire (1871–1918),"
                + " the Weimar Republic (1919–33) and the Third Reich (1933–45). Berlin in"
                + " the 1920s was the third largest municipality in the world. After"
                + " World War II, the city became divided into East Berlin -- the capital "
                + "of East Germany -- and West Berlin, a West German exclave surrounded by "
                + "the Berlin Wall from 1961–89. Following German reunification in 1990, the ";

        LinkedList<String> listURI = new LinkedList<>();
        try {
            listURI = callAPI(test);
        } catch (Exception ex) {
            Logger.getLogger(DBpediaSpotlightClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listURI.stream().forEach((URI) -> {
            System.out.print("URI : ");
            System.out.println(URI);
        });
    }
}
