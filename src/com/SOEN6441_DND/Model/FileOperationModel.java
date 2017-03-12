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

import org.dom4j.tree.DefaultElement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.ItemScene;

/**
 * This Class is a the file operation model handling the functionalities in and
 * out of files for whole project.
 * 
 * @author Paras Malik
 * @author Punit Trivedi
 * @author Appan Chhibber
 */
public class FileOperationModel {

	public File file;
	private ArrayList<String> itemsName;
	private ArrayList<String> itemsImage;
	private ArrayList<String> itemDesription;
	private ArrayList<String> enchantValue;
	private DefaultListModel readFileList;
	private DefaultListModel treasureList;

	public DefaultListModel getTreasureList() {
		return treasureList;
	}

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
	 * This method is used to read the items file present in items folder. Takes
	 * the input file to be read.
	 * 
	 * @param file
	 *            File
	 * 
	 */
	public void readFile(File file) {
		this.file = file;
		itemsName = new ArrayList<String>();
		itemsImage = new ArrayList<String>();
		itemDesription = new ArrayList<String>();
		enchantValue = new ArrayList<String>();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Element rootElement = document.getRootElement();
		List<Element> typeElements = rootElement.elements();
		for (Element item : typeElements) {
			itemsName.add(item.selectSingleNode("name").getText());
			itemsImage.add(item.selectSingleNode("image").getText());
			itemDesription.add(item.selectSingleNode("description").getText());
		}
	}

	public ArrayList<String> readSaveItemFile(File file) {
		this.file = file;
		itemsName = new ArrayList<String>();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Element rootElement = document.getRootElement();
		List<Element> typeElements = rootElement.elements();
		for (Element item : typeElements) {
			itemsName.add(item.selectSingleNode("name").getText());
		}
		return itemsName;
	}

	/**
	 * Returns all the save files name.
	 * 
	 * @author Punit Trivedi
	 * @return item list
	 */
	public DefaultListModel getAllFolderFile(String folderName) {
		readFileList = new DefaultListModel();
		File folder = new File(folderName + "/");
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				readFileList.addElement(file.getName());
			}
		}
		return readFileList;
	}

	public String writeCharacter(CharacterScene characterScene) throws IOException {
		CharacterModel characterModel = characterScene.characterViewModel;
		File file = new File("characters/" + characterModel.getName() + ".xml");
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("Character");
		root.addElement("name").addAttribute("id", "1").addText(characterModel.getName());
		root.addElement("type").addText(characterModel.getType());
		root.addElement("level").addText(String.valueOf(characterModel.getLevel()));
		root.addElement("image").addText(String.valueOf(characterModel.getImage()));

		Element abilityScore = root.addElement("abilityScore");
		abilityScore.addElement("strength").addText(String.valueOf(characterModel.getAbilityScore().getStrength()));
		abilityScore.addElement("dexterity").addText(String.valueOf(characterModel.getAbilityScore().getDexterity()));
		abilityScore.addElement("constitution")
				.addText(String.valueOf(characterModel.getAbilityScore().getConstitution()));
		abilityScore.addElement("intelligence")
				.addText(String.valueOf(characterModel.getAbilityScore().getIntelligence()));
		abilityScore.addElement("wisdom").addText(String.valueOf(characterModel.getAbilityScore().getWisdom()));
		abilityScore.addElement("charisma").addText(String.valueOf(characterModel.getAbilityScore().getCharisma()));

		Element abilityModifier = root.addElement("abilityModifier");
		abilityModifier.addElement("strength")
				.addText(String.valueOf(characterModel.getAbilityModifier().getStrength()));
		abilityModifier.addElement("dexterity")
				.addText(String.valueOf(characterModel.getAbilityModifier().getDexterity()));
		abilityModifier.addElement("constitution")
				.addText(String.valueOf(characterModel.getAbilityModifier().getConstitution()));
		abilityModifier.addElement("intelligence")
				.addText(String.valueOf(characterModel.getAbilityModifier().getIntelligence()));
		abilityModifier.addElement("wisdom").addText(String.valueOf(characterModel.getAbilityModifier().getWisdom()));
		abilityModifier.addElement("charisma")
				.addText(String.valueOf(characterModel.getAbilityModifier().getCharisma()));

		write(document, file);
		return "File Saved!!";

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
			Document document;
			try {
				document = reader.read(file);
				Element root = document.getRootElement();
				List<Element> typeElements = root.elements();
				Element typeElement = root.element("type");
				for (Element item : typeElements) {
					itemsName.add(item.selectSingleNode("name").getText());
				}
				if (itemsName.contains(currentScene.nameField.getText())) {
					return "Item already Exist!!";
				} else {
					List<org.dom4j.Element> list = root.elements();
					int total = list.size() + 1;
					Element typeId = root.addElement("type").addAttribute("id", String.valueOf(total));
					typeId.addElement("itemTypeName").addText(currentScene.subItemType.getSelectedItem().toString());
					typeId.addElement("name").addText(currentScene.nameField.getText());
					typeId.addElement("enchantValue").addText(currentScene.enchantList.getSelectedItem().toString());
					write(document, file);
				}
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			Document document = DocumentHelper.createDocument();
			Element root = document.addElement(currentScene.itemType.getSelectedItem().toString());
			Element typeId = root.addElement("type").addAttribute("id", "1");
			typeId.addElement("itemTypeName").addText(currentScene.subItemType.getSelectedItem().toString());
			typeId.addElement("name").addText(currentScene.nameField.getText());
			typeId.addElement("enchantValue").addText(currentScene.enchantList.getSelectedItem().toString());
			write(document, file);
		}
		return "File Saved!!";

	}

	public void writeChestFile(ItemScene currentScene) {
		File file = new File("items/Tressure.xml");

		if (file.exists()) {

			SAXReader reader = new SAXReader();
			Document document;
			try {
				document = reader.read(file);
				Element root = document.getRootElement();
				List<org.dom4j.Element> list = root.elements();
				int total = list.size() + 1;

				Element item = list.get(0);
				item.addElement("type").addText(currentScene.itemType.getSelectedItem().toString());
				item.addElement("name").addText(currentScene.nameField.getText());
				try {
					write(document, file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			Document document = DocumentHelper.createDocument();

			Element rootElement = document.addElement("treasure");
			Element root = rootElement.addElement("item");
			// Element typeId = root.addElement("type").addAttribute("id", "1");
			root.addElement("itemTypeName").addText(currentScene.subItemType.getSelectedItem().toString());
			root.addElement("name").addText(currentScene.nameField.getText());
			try {
				write(document, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	 * This Method is responsible for getting name of all the treasures created by the user
	 * @author Appan Chhibber
	 */
	public void readTreasureFile() {
		this.file = new File("items/Treasure.xml");
		treasureList = new DefaultListModel();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Element rootElement = document.getRootElement();
		List<Element> typeElements = rootElement.elements();
		for (Element item : typeElements) {
			treasureList.addElement(item.attributeValue("name"));
			
		}
	}

	/**
	 * Function is used to right the Created Items in File
	 * 
	 * @param document
	 * @param file
	 * @throws IOException
	 * @author Punit Trivedi
	 */
	public void write(org.dom4j.Document document, File file) throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		// lets write to a file
		XMLWriter writer = new XMLWriter(new FileWriter(file), format);
		writer.write(document);
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
		Document document = DocumentHelper.createDocument();
		Element rootElement = document.addElement("Map");
		rootElement.addElement("mapfilename").addText(file.getName());
		rootElement.addElement("mapwidth").addText(String.valueOf(mapModel.getMapWidth()));
		rootElement.addElement("mapheight").addText(String.valueOf(mapModel.getMapHeight()));

		Element entryDoorElement = new DefaultElement("EntryDoor");
		entryDoorElement.addElement("X").addText(String.valueOf((int) mapModel.getEntry().getWidth()));
		entryDoorElement.addElement("Y").addText(String.valueOf((int) mapModel.getEntry().getHeight()));
		rootElement.add(entryDoorElement);

		Element wallElements = rootElement.addElement("Wall");
		for (Dimension dimension : mapModel.getWalls()) {

			Element wallElement = new DefaultElement("wall");
			wallElement.addElement("X").addText(String.valueOf((int) dimension.getWidth()));
			wallElement.addElement("Y").addText(String.valueOf((int) dimension.getHeight()));
			wallElements.add(wallElement);
		}
		Element chestElement = new DefaultElement("Chest");
		chestElement.addElement("X").addText(String.valueOf((int) mapModel.getChest().getWidth()));
		chestElement.addElement("Y").addText(String.valueOf((int) mapModel.getChest().getHeight()));
		rootElement.add(chestElement);

		Element exitDoorElement = new DefaultElement("ExitDoor");
		exitDoorElement.addElement("X").addText(String.valueOf((int) mapModel.getExit().getWidth()));
		exitDoorElement.addElement("Y").addText(String.valueOf((int) mapModel.getExit().getHeight()));
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
	 * This method is resposible for reading the saved map file and setting in
	 * the model and returning it
	 * 
	 * @param file
	 * @return mapModel
	 * @author Appan Chhibber
	 * 
	 */
	public MapModel readMapFile(File file) {
		MapModel mapModel = new MapModel();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		Element rootElement = document.getRootElement();

		Node mapWidth = rootElement.selectSingleNode("mapwidth");
		mapModel.setMapWidth(Integer.parseInt(mapWidth.getText()));
		Node mapHeight = rootElement.selectSingleNode("mapheight");
		mapModel.setMapHeight(Integer.parseInt(mapHeight.getText()));

		Element entryDoor = rootElement.element("EntryDoor");
		Node entryX = entryDoor.selectSingleNode("X");
		Node entryY = entryDoor.selectSingleNode("Y");
		mapModel.setEntry(new Dimension(Integer.parseInt(entryX.getText()), Integer.parseInt(entryY.getText())));

		Element wallElement = rootElement.element("Wall");
		List<org.dom4j.Element> wallElements = wallElement.elements();
		for (org.dom4j.Element element : wallElements) {
			Node wallX = element.selectSingleNode("X");
			Node wallY = element.selectSingleNode("Y");
			mapModel.walls.add(new Dimension(Integer.parseInt(wallX.getText()), Integer.parseInt(wallY.getText())));
		}
		Element chest = rootElement.element("Chest");
		Node chestX = chest.selectSingleNode("X");
		Node chestY = chest.selectSingleNode("Y");
		mapModel.setChest(new Dimension(Integer.parseInt(chestX.getText()), Integer.parseInt(chestY.getText())));

		Element exitDoor = rootElement.element("ExitDoor");
		Node exitX = exitDoor.selectSingleNode("X");
		Node exitY = exitDoor.selectSingleNode("Y");
		mapModel.setExit(new Dimension(Integer.parseInt(exitX.getText()), Integer.parseInt(exitY.getText())));
		return mapModel;
	}
	
	
}