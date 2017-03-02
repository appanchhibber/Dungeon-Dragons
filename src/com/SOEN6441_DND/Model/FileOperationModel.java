package com.SOEN6441_DND.Model;

import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.SOEN6441_DND.Views.ItemScene;
/**
 * This Class is a view for Item Creation and Manipulation. This class is
 * observe by Item Model.	
 * 
 * @author Paras Malik
 * 
 *
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

	
	public File setFile(String fileName) {
		fileName = "items/" + fileName+".xml";
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

	public void readFile(File file) {
		this.file=file;
		itemsName= new ArrayList<String>();
		itemsImage= new ArrayList<String>();
		itemDesription = new ArrayList<String>();
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
				itemDesription.add(eElement.getElementsByTagName("description").item(0).getTextContent());
	
				//items.add(eElement.getTextContent());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public DefaultListModel getAllMaps()
	{
		mapList=new DefaultListModel();
		File folder=new File("maps/");
		File[] files=folder.listFiles();
		for(File file:files){
			if(file.isFile()){
				mapList.addElement(file.getName());
			}
		}
		return mapList;
	}


	public void writeItemData(ItemScene currentScene){
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			
			//root elements
			Document doc = documentBuilder.newDocument();
			Element rootElement = doc.createElement(currentScene.itemType.getSelectedItem().toString());
			doc.appendChild(rootElement);
			
			//item id element
			Element itemType = doc.createElement("item");
			rootElement.appendChild(itemType);
			
			//set attribute to item element
			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			itemType.setAttributeNode(attr);
			
			//item elements
			Element itemSubType = doc.createElement("itemtype");
			itemSubType.appendChild(doc.createTextNode(currentScene.subItemType.getSelectedItem().toString()));
			itemType.appendChild(itemSubType);
			
			//second element
			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode(currentScene.nameField.getText()));
			itemType.appendChild(name);
			
			//third element
			Element enchantValue = doc.createElement("enchantValue");
			enchantValue.appendChild(doc.createTextNode(currentScene.enchantList.getSelectedItem().toString()));
			itemType.appendChild(enchantValue);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File("itemSave/itemFile.xml"));
			
			transformer.transform(source, streamResult);
			System.out.println("File Saved!!");

		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
