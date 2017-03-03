package com.SOEN6441_DND.Model;

import java.awt.Dimension;
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
import org.dom4j.tree.DefaultElement;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

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
				itemsName.add(eElement.getElementsByTagName("name").item(0).getTextContent());
				itemsImage.add(eElement.getElementsByTagName("image").item(0).getTextContent());
				itemDesription.add(eElement.getElementsByTagName("description").item(0).getTextContent());

				// items.add(eElement.getTextContent());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	 * @param currentScene
	 *            ItemScene
	 * @author Paras Malik
	 * @throws IOException 
	 */
	public String writeItemData(ItemScene currentScene) throws IOException {
		File file = new File("itemSave/" + currentScene.itemType.getSelectedItem().toString() + ".xml");
		
		if (file.exists()) {

			SAXReader reader = new SAXReader();
			org.dom4j.Document document;
			try {
				document = reader.read(file);
				org.dom4j.Element root= document.getRootElement();
				org.dom4j.Element typeElement= root.element("type");
				
				List<Element> list = root.elements();
				int total=list.size()+1;
				org.dom4j.Element typeId = root.addElement("type").addAttribute("id", String.valueOf(total));
				typeId.addElement("itemTypeName").addText(currentScene.subItemType.getSelectedItem().toString());
				typeId.addElement("name").addText(currentScene.nameField.getText());
				typeId.addElement("enchantValue").addText(currentScene.enchantList.getSelectedItem().toString());
				write(document,file);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			org.dom4j.Document document = DocumentHelper.createDocument();
			org.dom4j.Element root = document.addElement(currentScene.itemType.getSelectedItem().toString());
			org.dom4j.Element typeId = root.addElement("type").addAttribute("id", "1");
			typeId.addElement("itemTypeName").addText(currentScene.subItemType.getSelectedItem().toString());
			typeId.addElement("name").addText(currentScene.nameField.getText());
			typeId.addElement("enchantValue").addText(currentScene.enchantList.getSelectedItem().toString());
			write(document,file);
		}
		return "File Saved!!";
		

	}
    public void write(org.dom4j.Document document,File file) throws IOException {
    	OutputFormat format = OutputFormat.createPrettyPrint();
	        // lets write to a file
	        XMLWriter writer = new XMLWriter(
	            new FileWriter(file),format
	        );
	        writer.write( document);
	        writer.close();
	    }

    /**
	 * This method is responsible for saving the map created
	 * 
	 * @param mapModel
	 *            MapModel
	 * @author Appan Chhibber
	 */
	public String writeMapData(File file, MapModel mapModel) {
		message = "Map Saved Successfully!";
		org.dom4j.Document document = DocumentHelper.createDocument();
		org.dom4j.Element rootElement = document.addElement("Map");
		rootElement.addElement("mapfilename").addText(file.getName());
		rootElement.addElement("mapwidth").addText(
				String.valueOf(mapModel.getMapWidth()));
		rootElement.addElement("mapheight").addText(
				String.valueOf(mapModel.getMapHeight()));

		org.dom4j.Element entryDoorElement = new DefaultElement("EntryDoor");
		entryDoorElement.addElement("X").addText(
				String.valueOf((int) mapModel.getEntry().getWidth()));
		entryDoorElement.addElement("Y").addText(
				String.valueOf((int) mapModel.getEntry().getHeight()));
		rootElement.add(entryDoorElement);

		org.dom4j.Element wallElements = rootElement.addElement("Wall");
		for (Dimension dimension : mapModel.getWalls()) {

			org.dom4j.Element wallElement = new DefaultElement("wall");
			wallElement.addElement("X").addText(
					String.valueOf((int) dimension.getWidth()));
			wallElement.addElement("Y").addText(
					String.valueOf((int) dimension.getHeight()));
			wallElements.add(wallElement);
		}
		org.dom4j.Element chestElement =  new DefaultElement("Chest");
		chestElement.addElement("X").addText(
				String.valueOf((int) mapModel.getChest().getWidth()));
		chestElement.addElement("Y").addText(
				String.valueOf((int) mapModel.getChest().getHeight()));
		rootElement.add(chestElement);

		org.dom4j.Element exitDoorElement = new DefaultElement("ExitDoor");
		exitDoorElement.addElement("X").addText(
				String.valueOf((int) mapModel.getExit().getWidth()));
		exitDoorElement.addElement("Y").addText(
				String.valueOf((int) mapModel.getExit().getHeight()));
		rootElement.add(exitDoorElement);

		XMLWriter writer = null;
		try {
			OutputFormat output = OutputFormat.createPrettyPrint();
			writer = new XMLWriter(new FileWriter(file), output);
			writer.write(document);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Save Failed";
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {

				}
			}
		}
		return message;
	}
/**
 * This method is resposible for reading the saved map file and setting in the model and returning it  
 * @param file
 * @return mapModel
 * @author Appan Chhibber
 * 
 */
	public MapModel readMapFile(File file) {
		MapModel mapModel = new MapModel();
		SAXReader reader = new SAXReader();
		org.dom4j.Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		org.dom4j.Element rootElement = document.getRootElement();

		org.dom4j.Node mapWidth = rootElement.selectSingleNode("mapwidth");
		mapModel.setMapWidth(Integer.parseInt(mapWidth.getText()));
		org.dom4j.Node mapHeight = rootElement.selectSingleNode("mapheight");
		mapModel.setMapHeight(Integer.parseInt(mapHeight.getText()));

		org.dom4j.Element entryDoor = rootElement.element("EntryDoor");
		org.dom4j.Node entryX = entryDoor.selectSingleNode("X");
		org.dom4j.Node entryY = entryDoor.selectSingleNode("Y");
		mapModel.setEntry(new Dimension(Integer.parseInt(entryX.getText()),
				Integer.parseInt(entryY.getText())));

		org.dom4j.Element wallElement = rootElement.element("Wall");
		List<org.dom4j.Element> wallElements = wallElement.elements();
		for (org.dom4j.Element element : wallElements) {
			org.dom4j.Node wallX = element.selectSingleNode("X");
			org.dom4j.Node wallY = element.selectSingleNode("Y");
			mapModel.walls.add(new Dimension(Integer.parseInt(wallX.getText()),
					Integer.parseInt(wallY.getText())));
		}
		org.dom4j.Element chest = rootElement.element("Chest");
		org.dom4j.Node chestX = chest.selectSingleNode("X");
		org.dom4j.Node chestY = chest.selectSingleNode("Y");
		mapModel.setChest(new Dimension(Integer.parseInt(chestX.getText()),Integer.parseInt(chestY.getText())));
		
		
		org.dom4j.Element exitDoor=rootElement.element("ExitDoor");
		org.dom4j.Node exitX=exitDoor.selectSingleNode("X");
		org.dom4j.Node exitY=exitDoor.selectSingleNode("Y");
		mapModel.setExit(new Dimension(Integer.parseInt(exitX.getText()),Integer.parseInt(exitY.getText())));
		return mapModel;
	}
}