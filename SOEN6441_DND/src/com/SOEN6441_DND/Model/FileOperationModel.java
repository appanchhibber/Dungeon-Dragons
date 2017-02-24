package com.SOEN6441_DND.Model;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileOperationModel {

	public File file;
	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	Document doc;
	ArrayList items;
	
	public File setFile(String fileName) {
		fileName = "items/" + fileName+".xml";
		this.file = new File(fileName);
		return file;
	}

	public ArrayList readFile(File file) {
		this.file=file;
		items= new ArrayList();
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc=dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("name");
			for(int i=0;i<nList.getLength();i++){
				Element eElement = (Element) nList.item(i);
				items.add(eElement.getTextContent());
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
}
