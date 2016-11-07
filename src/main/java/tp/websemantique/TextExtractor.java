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
//import org.jsoup.nodes.Document;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.json.*;

import com.alchemyapi.api.*;
import java.io.StringWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



/**
 *
 * @author Flo Macé
 */
public class TextExtractor {
	
	AlchemyAPI alchemyObj;
    
    public TextExtractor(String API_key_path) throws IOException
    {
    	this.alchemyObj = AlchemyAPI.GetInstanceFromFile(API_key_path);
    }

    public List<String> extractTextFromURLList(List<String> URLList) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException
    {
        List<String> rawTexts = new ArrayList();
        for (String url:URLList)
        {
            //extractText(url);
            rawTexts.add(extractText(url));
        }
        return rawTexts;
    }
    
    public String extractText(String url) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException{
        //String html = Jsoup.connect(url).get().html();
        //return html2text(html);
    	
    	Document doc = alchemyObj.URLGetText(url);
    	
    	String text = getStringFromDocument(doc);
    	
    	// Getting only text part, if it exists
    	
    	if (text.contains("<text>") && text.contains("</text>"))
    	{
    		text = text.substring(text.indexOf("<text>") + 6, text.indexOf("</text>"));
    	}
    	
    	return text;
    }
    
    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
    
    private static String getStringFromDocument(Document doc)
	{
        try
		{
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);

            return writer.toString();
        }
		catch (TransformerException ex)
		{
            ex.printStackTrace();
            return null;
        }
	}
}
