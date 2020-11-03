package sax;


import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SAXjedu1n extends DefaultHandler
{

	public static void main(String[] args)
	{
		try
		{
			
			
		}
		catch (SAXException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	public void startElement (String namespaceuri, String localname, String rawname, Attributes atts)throws  SAXException  
	{
		System.out.println(rawname + "start");
	}
	public void endElement (String namespaceuri, String localname, String rawname)  throws SAXException  
	{
		
	}
	public void characters (char[] ch, int start, int length)  throws SAXException
	{
		
	}    

}
