/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.websemantique;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



/**
 *
 * @author Flo Macé
 */
public class TextExtractor {
    
    public TextExtractor(){
    }

    public List<String> extractTextFromURLList(List<String> URLList) throws IOException
    {
        List<String> rawTexts = new ArrayList();
        for (String url:URLList)
        {
            extractText(url);
            rawTexts.add(extractText(url));
        }
        return rawTexts;
    }
    
    public String extractText(String url) throws IOException{
        String html = Jsoup.connect(url).get().html();
        return html2text(html);
    }
    
    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
}
