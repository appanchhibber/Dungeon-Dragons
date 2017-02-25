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
	private ArrayList<String> itemsName;
	private ArrayList<String> itemsImage;
	
	public File setFile(String fileName) {
		fileName = "items/" + fileName+".xml";
		this.file = new File(fileName);
		return file;
	}

	public ArrayList<String> getItemsName() {
		return itemsName;
	}

	public ArrayList<String> getItemsImage() {
		return itemsImage;
	}

	public void readFile(File file) {
		this.file=file;
		itemsName= new ArrayList<String>();
		itemsImage= new ArrayList<String>();
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc=dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("type");
			for(int i=0;i<nList.getLength();i++){
				Element eElement = (Element) nList.item(i);
				itemsName.add(eElement.getElementsByTagName("name").item(0).getTextContent());
				itemsImage.add(eElement.getElementsByTagName("image").item(0).getTextContent());
				//items.add(eElement.getTextContent());
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
