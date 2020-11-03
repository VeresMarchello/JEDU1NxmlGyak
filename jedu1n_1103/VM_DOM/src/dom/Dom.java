package dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Dom
{
	public static void main(String[] args)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document document = builder.parse(new File("..\\..\\..\\..\\jedu1n_1020\\VM_szemelyek.xml"));
			Document document = builder.parse(new File("D:\\Fork\\JEDU1NxmlGyak\\jedu1n_1020\\VM_szemelyek.xml"));

//			document.getDocumentElement().normalize();
			Element rootNode = document.getDocumentElement();
			
			System.out.println("Gyökér elem: " + rootNode.getNodeName());
			
			NodeList childNodes = rootNode.getChildNodes();
			
			for (int i = 0; i < childNodes.getLength(); i++)
			{
				Node node = childNodes.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element element = (Element) node;
					String id = element.getAttribute("id");
					System.out.println("id: " + id);
					
					Node actualNode = element.getFirstChild();
					
					while (actualNode != null) 
					{
						if (actualNode.getNodeType() == Node.ELEMENT_NODE)
						{
							Element actualElement = (Element) actualNode;
							System.out.println("  " + actualElement.getNodeName() + ":  " + actualElement.getTextContent());
						}
						
						actualNode = actualNode.getNextSibling();
					}
					
					System.out.println();
				}
			}
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
