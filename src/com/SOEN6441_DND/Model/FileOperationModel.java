package com.SOEN6441_DND.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import com.SOEN6441_DND.Views.ItemScene;

/**
 * This Class is a the file operation model handling the functionalities
 * in and out of files for whole project.
 * 
 * @author Paras Malik
 * @author Punit Trivedi
 *@author Appan Chhibber
 */
public class FileOperationModel {

	public File file;
	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	Document doc;
	private ArrayList<String> itemsName;
	private ArrayList<String> itemsImage;
	private ArrayList<String> itemDesription;
	private DefaultListModel mapList;

	private String message;

	public File setFile(String fileName) {
		fileName = "items/" + fileName + ".xml";
		this.file = new File(fileName);
		return file;
	}

	public ArrayList<String> getItemDesription() {
		return itemDesription;
	}

	public ArrayList<String> getItemsName() {
		return itemsName;
	}

	public ArrayList<String> getItemsImage() {
		return itemsImage;
	}

	/**
	 * This method is used to read the items file present in items folder.
	 * Takes the input file to be read.
	 * @param file File
	 */
	public void readFile(File file) {
		this.file = file;
		itemsName = new ArrayList<String>();
		itemsImage = new ArrayList<String>();
		itemDesription = new ArrayList<String>();
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("type");
			for (int i = 0; i < nList.getLength(); i++) {
				Element eElement = (Element) nList.item(i);
				itemsName.add(eElement.getElementsByTagName("name").item(0)
						.getTextContent());
				itemsImage.add(eElement.getElementsByTagName("image").item(0)
						.getTextContent());
				itemDesription.add(eElement.getElementsByTagName("description")
						.item(0).getTextContent());

				// items.add(eElement.getTextContent());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function return the maps present in the map directory.
	 * @return mapList List of all maps on maps directory.
	 */
	public DefaultListModel getAllMaps() {
		mapList = new DefaultListModel();
		File folder = new File("maps/");
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				mapList.addElement(file.getName());
			}
		}
		return mapList;
	}

	/**
	 * This method is reponsible for saving the item created.
	 * 
	 * @param currentScene ItemScene
	 * @author Paras Malik
	 */
	public void writeItemData(ItemScene currentScene) {
		
		File file = new File("itemSave/"+currentScene.itemType.getSelectedItem().toString()+".xml");
		if(file.exists()){
		
			SAXReader reader = new SAXReader();
			
				org.dom4j.Document document;
				try {
					document = reader.read(file);
					
					if(document.getRootElement().getName() == currentScene.itemType.getSelectedItem().toString())
					{
						
					
					org.dom4j.Element rootElement = document.getRootElement();
					Node helmet=rootElement.selectSingleNode("type");
					org.dom4j.Element type=rootElement.element("type");
					List abc=type.elements();
					System.out.println(abc);
					
				
					
					
					}
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
			
		}
		else{

		org.dom4j.Document document = DocumentHelper.createDocument();
		org.dom4j.Element root = document.addElement(currentScene.itemType.getSelectedItem().toString());
		
		org.dom4j.Element typeId = root.addElement("type").addAttribute("Id", "1");
		typeId.addElement("itemTypeName").addText(currentScene.subItemType.getSelectedItem().toString());
		
		typeId.addElement("name").addText(currentScene.nameField.getText());
		
		typeId.addElement("enchantValue").addText(currentScene.enchantList.getSelectedItem().toString());
		
		
		try {
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			FileOutputStream fos = new FileOutputStream(new File("itemSave/"+currentScene.itemType.getSelectedItem().toString()+".xml"));
			try {
				XMLWriter xmlWriter = new XMLWriter(fos, outputFormat);
				try {
					xmlWriter.write(document);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  
		}
		
		
		
	}

	/**
	 * This method is responsible for saving the map created
	 * 
	 * @param mapModel  MapModel
	 * @author Appan Chhibber
	 */
	public String writeMapData(File file,MapModel mapModel) {
		message = "Map Saved Successfully!";
		org.dom4j.Document document=DocumentHelper.createDocument();
		org.dom4j.Element rootElement=document.addElement("Map");
		
		
	//	rootElement.add(play.encode());
		
		XMLWriter writer=null;
		try{
			writer=new XMLWriter(new FileWriter(file));
			writer.write(document);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(writer!=null)
			{
				try{
				writer.close();
				}catch(Exception e)
				{
					
				}
			}
		}
		return message;
	}
}
