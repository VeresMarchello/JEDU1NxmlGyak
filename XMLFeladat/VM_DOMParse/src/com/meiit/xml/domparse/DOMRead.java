package com.meiit.xml.domparse;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMRead
{
	private static String separator = "";
	private static String line = "---------------------------------------";
	private static int level = 0;// depth in tree

	/**
	 * Gets an XML file and route element.
	 * Calls printDocument method with parameter: route element.
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File("C:\\Users\\Marci\\OneDrive\\Egyetem\\V. félév\\XML\\XMLFeladat\\VM_XML.xml");
			Document document = builder.parse(xmlFile);

			Element rootNode = document.getDocumentElement();

			printDocument(rootNode);
	}

	/**
	 * Prints child elements of given node.
	 */
	public static void printDocument(Node rootNode)
	{

		System.out.println(separator + rootNode.getNodeName());
		System.out.println(separator + line);

		separator += "  ";
		level++;

		Node childNode = rootNode.getFirstChild();

		while (childNode != null)
		{

			if (childNode.getNodeType() == Node.ELEMENT_NODE)
			{

				boolean nodeIsComplex = childNode.getTextContent().contains("\n");

				if (nodeIsComplex == false)
				{
					System.out.print(separator + childNode.getNodeName());
					System.out.println(": " + childNode.getTextContent());
				}

				else
				{
					System.out.println("");
					printDocument(childNode);
					level--;
					separator = separator.substring(0, separator.length() - 2);
				}
			}

			childNode = childNode.getNextSibling();
		}
	}
}
