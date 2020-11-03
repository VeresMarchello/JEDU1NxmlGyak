package parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser
{

	public static void main(String[] args)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document document = builder.parse(new File("..\\..\\..\\..\\jedu1n_1103\\VM_student.xml"));
			Document document = builder.parse(new File("D:\\Fork\\JEDU1NxmlGyak\\jedu1n_1103\\VM_student.xml"));

			document.getDocumentElement().normalize();

			Element rootNode = document.getDocumentElement();
			System.out.println("Root element: " + rootNode.getNodeName());
			
			NodeList nodeList = document.getElementsByTagName("student");
			System.out.println("-------------------");
			
			for (int i = 0; i < nodeList.getLength(); i++)
			{
				Node actualNode = nodeList.item(i);
				System.out.println("Curent Element: " + actualNode.getNodeName());
				
				if (actualNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element actualElement = (Element) actualNode;
					
					System.out.println("Student rollno: " + 
					actualElement.
					getAttribute("rollno"));
					
					System.out.println("First name: " + 
					actualElement.
					getElementsByTagName("firstname")
					.item(0)
					.getTextContent());
					
					System.out.println("Last name: " + 
					actualElement.
					getElementsByTagName("lastname")
					.item(0)
					.getTextContent());
					
					System.out.println("Nick name: " + 
					actualElement.
					getElementsByTagName("nickname")
					.item(0)
					.getTextContent());
					
					System.out.println("Age: " + 
					actualElement.
					getElementsByTagName("age")
					.item(0)
					.getTextContent());
					
					System.out.println();
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
