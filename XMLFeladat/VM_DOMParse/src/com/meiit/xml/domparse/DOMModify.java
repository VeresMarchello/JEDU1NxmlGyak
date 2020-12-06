package com.meiit.xml.domparse;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMModify
{
	/**
	 * Gets an XML file and route element.
	 * Calls findParentNode method with the following parameters:
	 * route element, name of node we are looking for.
	 * 
	 * Calls modifyNodeValue method with the following parameters:
	 * parent node, name of child element, new value of child element.
	 * 
	 * Calls modifyDocument method with the following parameters:
	 * document, result file.
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

		DocumentBuilder builder = factory.newDocumentBuilder();
		File xmlFile = new File("C:\\Users\\Marci\\OneDrive\\Egyetem\\V. félév\\XML\\XMLFeladat\\VM_XML.xml");
		Document document = builder.parse(xmlFile);

		Element rootNode = document.getDocumentElement();

		String parentNode = "kolcsonzo";
		String node = "nev";
		String newValue = "Kiss Pista";

		if (rootNode.getNodeName() == parentNode)
		{
			modifyNodeValue(rootNode, node, newValue);
		}
		else
		{
			Node parent = findParentNode(rootNode, parentNode);

			if (parent != null)
			{
				modifyNodeValue(parent, node, newValue);
				modifyDocument(document, xmlFile);
			}

		}
	}

	/**
	 * Returns the parent node we are looking for.
	 */
	public static Node findParentNode(Node rootNode, String parentNode)
	{
		Node childNode = rootNode.getFirstChild();

		while (childNode != null)
		{

			if (childNode.getNodeType() == Node.ELEMENT_NODE)
			{

				boolean nodeIsComplex = childNode.getTextContent().contains("\n");

				if (nodeIsComplex == true)
				{

					if (childNode.getNodeName() == parentNode)
					{
						return childNode;
					}
					else
					{
						findParentNode(childNode, parentNode);
					}
				}

			}

			childNode = childNode.getNextSibling();
		}
		return null;
	}

	/**
	 * Modifies the specified value of node .
	 */
	public static void modifyNodeValue(Node parentNode, String node, String newValue)
	{
		Node childNode = parentNode.getFirstChild();

		while (childNode != null)
		{

			if (childNode.getNodeType() == Node.ELEMENT_NODE)
			{

				boolean nodeIsComplex = childNode.getTextContent().contains("\n");

				if (nodeIsComplex == false)
				{

					if (childNode.getNodeName() == node)
					{
						childNode.setTextContent(newValue);
					}
				}

			}

			childNode = childNode.getNextSibling();
		}
	}
	
	/**
	 * Modifies the given XML document.
	 */
	public static void modifyDocument(Document document, File xmlFile) throws TransformerException
	{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(xmlFile);

		transformer.transform(source, new StreamResult(System.out));
		transformer.transform(source, result);
	}
}
