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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import org.dom4j.tree.DefaultElement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.SOEN6441_DND.Model.ItemModel.itemTypeList;
import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.ItemScene;
import com.sun.beans.decoder.DocumentHandler;

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
	private String rootElementName;
	
	public String getRootElementName() {
		return rootElementName;
	}


	public void setRootElementName(String rootElementName) {
		this.rootElementName = rootElementName;
	}


	public ArrayList<String> getWeaponType() {
		return weaponType;
	}


	public ArrayList<String> getWeaponRange() {
		return weaponRange;
	}


	private ArrayList<String> enchantValue;
	private ArrayList<String> weaponType;
	private ArrayList<String> weaponRange;
	private DefaultListModel readFileList;
	private DefaultListModel treasureList;

	private String characterImage;
	private CharacterModel chModel;

	public String getCharacterImage() {
		return characterImage;
	}

	public DefaultListModel getTreasureList() {
		return treasureList;
	}

	private String message;

	public File setFile(String fileName) {
		fileName = "items/" + fileName + ".xml";
		this.file = new File(fileName);
		return file;
	}

	/**
	 * This method creates file based on the string name
	 * 
	 * @param fileName
	 * @return file
	 * @author Appan Chhibber
	 */
	public File setCharacterFile(String fileName) {
		fileName = "characters/" + fileName + ".xml";
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
		weaponType = new ArrayList<String>();
		weaponRange = new ArrayList<String>();
		enchantValue = new ArrayList<String>();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Element rootElement = document.getRootElement();
		rootElementName = rootElement.getName();
		List<Element> typeElements = rootElement.elements();
		for (Element item : typeElements) {
			itemsName.add(item.selectSingleNode("name").getText());
			itemsImage.add(item.selectSingleNode("image").getText());
			itemDesription.add(item.selectSingleNode("description").getText());
		
			if(rootElement.getName().equalsIgnoreCase("weapon")){
				weaponType.add(item.selectSingleNode("weapontype").getText());
				weaponRange.add(item.selectSingleNode("range").getText());
			}
		}

	}
	/**
	 * This method is used to read the character file saved by the user
	 * 
	 * @param file
	 * @author Appan Chhibber
	 */
	public void readCharaterFile(File file) {
		this.file = file;
		itemsImage = new ArrayList<String>();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Element rootElement = document.getRootElement();
		characterImage = rootElement.selectSingleNode("image").getText();
	}
/**
 * This method is responsible for reading the itemtype files saved in itemsave folder
 * @param file
 * @return itemModel
 * @author Appan Chhibber
 * @author Paras Malik 
 */
	public ItemModel readItemSaveFile(File file){
		ItemModel itemModel=new ItemModel();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Element rootElement = document.getRootElement();
		List<Element> typeElements=rootElement.elements();
		for(Element item:typeElements){
			Node itemType=item.selectSingleNode("itemTypeName");
			itemModel.savedItemTypeList.addElement(itemType.getText());
			Node itemName=item.selectSingleNode("name");
			itemModel.savedItemNameList.addElement(itemName.getText());
			if(file.getName().substring(0, 6).equals("Weapon")){
				Node weaponType = item.selectSingleNode("weaponType");
				itemModel.weaponTypeList.addElement(weaponType.getText());
				//itemModel.weaponType = weaponType.getText();
				Node weaponRange = item.selectSingleNode("weaponRange");
				itemModel.weaponRangeList.addElement(weaponRange.getText());
				//itemModel.weaponRange = weaponRange.getText();
			}
			Node enchantValue=item.selectSingleNode("enchantValue");
			itemModel.savedEnchantValueList.put(itemName.getText(),enchantValue.getText());
		}
		itemModel.itemType=rootElement.getName();
		return itemModel;
	}
	/**
	 * This method reads all the items from the file.
	 * @param file
	 * @return
	 * @author Punit Trivedi
	 */
	public Map<String, ArrayList<String>> readSaveItemFile(File file) {
		Map<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
		this.file = file;
		String filename=file.getName().replaceAll(".xml", "");
		itemsName = new ArrayList<String>();
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
			Element rootElement = document.getRootElement();
			List<Element> typeElements = rootElement.elements();

			for (Element item : typeElements) {
				itemsName.add(item.selectSingleNode("name").getText());//Name of Item
				itemsName.add(filename);//Type of Item
				itemsName.add(item.selectSingleNode("itemTypeName").getText());//Sub Type
				itemsName.add(item.selectSingleNode("enchantValue").getText());//Enchanment Value
				if(filename.equals("Weapon")){
				  itemsName.add(item.selectSingleNode("weaponRange").getText());
				}
				
				hm.put(item.selectSingleNode("name").getText(),itemsName);
			}
			return hm;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No Item has been created for this type");
		}
		return hm;
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
		readFileList.addElement("Select");
		for (File file : files) {
			if (file.isFile()) {
				readFileList.addElement(file.getName().replaceAll(".xml", "").trim());
			}
		}
		return readFileList;
	}
	public void setCharacterModel(CharacterModel model)
	{
		chModel=model;
	}
	/**
	 * @author Punit Trivedi
	 * @param characteName
	 * @return
	 * @throws DocumentException 
	 */
	public Map<String, ArrayList<String>>[] readAllItems() {
		Map<String, ArrayList<String>>[] itemList = new HashMap[7];
		Map<String, ArrayList<String>> items;
		for (itemTypeList s : ItemModel.itemTypeList.values()) {
			File f1 = new File("itemSave/" + s.toString() + ".xml");
			items = readSaveItemFile(f1);
			switch (s.toString()) {
			case "Helmet": {
				itemList[0] = items;
				break;
			}
			case "Armor": {
				itemList[1] = items;
				break;
			}
			case "Shield": {
				itemList[2] = items;
				break;
			}
			case "Belt": {
				itemList[3] = items;
				break;
			}
			case "Boots": {
				itemList[4] = items;
				break;
			}
			case "Ring": {
				itemList[5] = items;
				break;
			}
			case "Weapon": {
				itemList[6] = items;
				break;
			}
			}

		}
		return itemList;
	}
	/**
	 * Read character's assigned Item.
	 * @param characteName
	 * @return
	 */
	public ItemModel readSingleItem(String itemName, String itemType){
		ItemModel item= new ItemModel();
		Map<String, ArrayList<String>> items = readSaveItemFile(new File("itemSave/"+itemType+".xml"));
		
		item.setName(itemName);
		item.setItemType(itemType);
		item.setSubItemType(items.get(itemName).toArray()[2].toString());
		item.setImage(items.get(itemName).toArray()[2].toString().replaceAll("\\s+", "")+".jpg");
		item.setEnchantValue(Integer.parseInt(items.get(itemName).toArray()[3].toString()));
		if(itemType.equals("Weapon")){
			item.setWeaponRange(Integer.parseInt(items.get(itemName).toArray()[4].toString()));
		}
			
		return item;
	}
	
	public CharacterModel loadCharacter(String characteName)
	{
		ArrayList<String> backPackList=new ArrayList<String>();
		if(chModel==null){
			chModel = new CharacterModel();
		}
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File("characters/"+characteName+".xml"));
			Element rootElement = document.getRootElement();
			chModel.setName(rootElement.selectSingleNode("name").getText());
			chModel.setType(rootElement.selectSingleNode("type").getText());
			chModel.setLevel(Integer.parseInt(rootElement.selectSingleNode("level").getText()));
			chModel.setImage(rootElement.selectSingleNode("image").getText());
			
			Element charCharacteristics = rootElement.element("characteristics");
			chModel.setHitPoints(Integer.parseInt(charCharacteristics.selectSingleNode("hitPoint").getText()));
			chModel.setArmorClass(Integer.parseInt(charCharacteristics.selectSingleNode("armorClass").getText()));
			chModel.setAttackBonus(Integer.parseInt(charCharacteristics.selectSingleNode("attackBonus").getText()));
			chModel.setDamageBonus(Integer.parseInt(charCharacteristics.selectSingleNode("damageBonus").getText()));
			
			Element itemEquip = rootElement.element("itemEquip");
			chModel.setHelmetFlag(itemEquip.selectSingleNode("helmetFlag").getText());
			chModel.addOwnedItems("Helmet",readSingleItem(chModel.getHelmetFlag(),"Helmet"));
			chModel.setArmorFlag(itemEquip.selectSingleNode("armorFlag").getText());
			chModel.addOwnedItems("Armor",readSingleItem(chModel.getArmorFlag(),"Armor"));
			chModel.setBeltFlag(itemEquip.selectSingleNode("beltFlag").getText());
			chModel.addOwnedItems("Belt",readSingleItem(chModel.getBeltFlag(),"Belt"));
			chModel.setBootFlag(itemEquip.selectSingleNode("bootFlag").getText());
			chModel.addOwnedItems("Boots",readSingleItem(chModel.getBootFlag(),"Boots"));
			chModel.setRingFlag(itemEquip.selectSingleNode("ringFlag").getText());
			chModel.addOwnedItems("Ring",readSingleItem(chModel.getRingFlag(),"Ring"));
			chModel.setShieldFlag(itemEquip.selectSingleNode("shieldFlag").getText());
			chModel.addOwnedItems("Shield",readSingleItem(chModel.getShieldFlag(),"Shield"));
			chModel.setWeaponFlag(itemEquip.selectSingleNode("weaponFlag").getText());
			chModel.addOwnedItems("Weapon",readSingleItem(chModel.getWeaponFlag(),"Weapon"));
			
			
			Element abiModiElement = rootElement.element("abilityModifier");
			chModel.getAbilityModifier().setStrength(Integer.parseInt(abiModiElement.selectSingleNode("strength").getText()));
			chModel.getAbilityModifier().setConstitution(Integer.parseInt(abiModiElement.selectSingleNode("constitution").getText()));
			chModel.getAbilityModifier().setDexterity(Integer.parseInt(abiModiElement.selectSingleNode("dexterity").getText()));
			chModel.getAbilityModifier().setIntelligence(Integer.parseInt(abiModiElement.selectSingleNode("intelligence").getText()));
			chModel.getAbilityModifier().setWisdom(Integer.parseInt(abiModiElement.selectSingleNode("wisdom").getText()));
			chModel.getAbilityModifier().setCharisma(Integer.parseInt(abiModiElement.selectSingleNode("charisma").getText()));
			
			Element abiScorElement = rootElement.element("abilityScore");
			chModel.getAbilityScore().setStrength(Integer.parseInt(abiScorElement.selectSingleNode("strength").getText()));
			chModel.getAbilityScore().setConstitution(Integer.parseInt(abiScorElement.selectSingleNode("constitution").getText()));
			chModel.getAbilityScore().setDexterity(Integer.parseInt(abiScorElement.selectSingleNode("dexterity").getText()));
			chModel.getAbilityScore().setIntelligence(Integer.parseInt(abiScorElement.selectSingleNode("intelligence").getText()));
			chModel.getAbilityScore().setWisdom(Integer.parseInt(abiScorElement.selectSingleNode("wisdom").getText()));
			chModel.getAbilityScore().setCharisma(Integer.parseInt(abiScorElement.selectSingleNode("charisma").getText()));
			
			
			chModel.setBackPackCounter(Integer.parseInt(rootElement.selectSingleNode("backPackCounter").getText()));
			Element backPackElement = rootElement.element("backPackItems");
			List<Element> backPackItems=backPackElement.elements();
			chModel.setBackPackItems(backPackList);
			for (Element item : backPackItems) {
				chModel.addBackPackItems(item.getText());
				//System.out.println(backPackList.toString());
			}
			for(Map.Entry<String, ItemModel> item:chModel.getOwnedItems().entrySet()){
				item.getValue().setEnchantValue(+chModel.calculateEnchanment(chModel.getLevel()));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return chModel;
		
	}

	public String writeCharacter(CharacterModel characterModel) throws IOException {
		File file = new File("characters/" + characterModel.getName() + ".xml");
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("Character");
		root.addElement("name").addAttribute("id", "1").addText(characterModel.getName());
		root.addElement("type").addText(characterModel.getType());
		root.addElement("level").addText(String.valueOf(characterModel.getLevel()));
		root.addElement("image").addText(String.valueOf(characterModel.getImage()));
		
		Element characteristics=root.addElement("characteristics");
		characteristics.addElement("hitPoint").addText(String.valueOf(characterModel.getHitPoints()));
		characteristics.addElement("armorClass").addText(String.valueOf(characterModel.getArmorClass()));
		characteristics.addElement("attackBonus").addText(String.valueOf(characterModel.getAttackBonus()));
		characteristics.addElement("damageBonus").addText(String.valueOf(characterModel.getDamageBonus()));
		
		Element itemEquip=root.addElement("itemEquip");
		itemEquip.addElement("helmetFlag").addText(characterModel.getHelmetFlag());
		itemEquip.addElement("armorFlag").addText(characterModel.getArmorFlag());
		itemEquip.addElement("shieldFlag").addText(characterModel.getShieldFlag());
		itemEquip.addElement("beltFlag").addText(characterModel.getBeltFlag());
		itemEquip.addElement("bootFlag").addText(characterModel.getBootFlag());
		itemEquip.addElement("ringFlag").addText(characterModel.getRingFlag());
		itemEquip.addElement("weaponFlag").addText(characterModel.getWeaponFlag());
		
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
		
		root.addElement("backPackCounter").addText(String.valueOf(characterModel.getBackPackCounter()));
		Element backPackItem = root.addElement("backPackItems");
		for (String item: characterModel.backPackItems) {
			backPackItem.addElement("item").addText(item);
		}
		write(document, file);
		return "File Saved!!";

	}

	
/**
 * This method is responsible for reading the contents of items saved in ItemSave folder
 * @param file
 * @return
 */
	public ItemModel readItemFile(File file) {

		ItemModel itemModel = new ItemModel();
		this.file = file;

		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		
		itemModel.setItemType(rootElement.getName());
		Element type = rootElement.element("type");
		itemModel.setSubItemType(type.selectSingleNode("itemTypeName").getText());
		itemModel.setName(type.selectSingleNode("name").getText());
		itemModel.setEnchantValue(Integer.parseInt((type.selectSingleNode("enchantValue").getText())));

		return itemModel;
	}

	/**
	 * This method is responsible for saving contents of the itemScreen into file in itemSave folder.
	 * @param writeItemModel
	 * @return String type value
	 * @throws IOException
	 */
	public String writeItemData(ItemModel writeItemModel) throws IOException {
		
		
		File file = null;
		
			file = new File("itemSave/" + writeItemModel.getItemType() + ".xml");

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
					if (itemsName.contains(writeItemModel.getName())) {
						return "Item already Exist!!";
					} else {
						List<org.dom4j.Element> list = root.elements();
						int total = list.size() + 1;
						Element typeId = root.addElement("type").addAttribute("id", String.valueOf(total));
						typeId.addElement("itemTypeName")
								.addText(writeItemModel.getSubItemType());
						typeId.addElement("name").addText(writeItemModel.getName());
						if(writeItemModel.getItemtype().equalsIgnoreCase("weapon")){
							typeId.addElement("weaponType").addText(writeItemModel.getWeaponType());
							typeId.addElement("weaponRange").addText(String.valueOf(writeItemModel.getWeaponRange()));
						}
						typeId.addElement("enchantValue")
								.addText(Integer.toString(writeItemModel.getEnchantValue()));
						write(document, file);
					}
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else {

					Document document = DocumentHelper.createDocument();
					Element root = document.addElement(writeItemModel.getItemtype());
					Element typeId = root.addElement("type").addAttribute("id", "1");
					typeId.addElement("itemTypeName").addText(writeItemModel.getSubItemType());
					typeId.addElement("name").addText(writeItemModel.getName());
					typeId.addElement("enchantValue").addText(Integer.toString(writeItemModel.getEnchantValue()));
					write(document, file);
				}
	

	 
	return "File Saved!!";

	}
	
	/**
	 * This function add values in the treasure file in items folder
	 * @param writeChestModel
	 * @author Paras Malik
	 */
	public void writeChestFile(ItemModel writeChestModel) {
		File file = new File("items/Treasure.xml");

		if (file.exists()) {

			SAXReader reader = new SAXReader();
			Document document;
			try {
				document = reader.read(file);
				Element root = document.getRootElement();
				List<org.dom4j.Element> list = root.elements();
				int total = list.size() + 1;

				Element item = root.addElement("item").addAttribute("name", writeChestModel.getName());
				item.addElement("type").addText(writeChestModel.getItemType());
				item.addElement("name").addText(writeChestModel.getName());
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
			root.addAttribute("name", writeChestModel.getName());
			root.addElement("type").addText(writeChestModel.getItemtype());
			root.addElement("name").addText(writeChestModel.getName());
			try {
				write(document, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	 * This Method is responsible for getting name of all the treasures created
	 * by the user
	 * 
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
		entryDoorElement.addElement("X").addText(String.valueOf((int) mapModel.getEntry().getHeight()));
		entryDoorElement.addElement("Y").addText(String.valueOf((int) mapModel.getEntry().getWidth()));
		rootElement.add(entryDoorElement);

		Element wallElements = rootElement.addElement("Wall");
		for (Dimension dimension : mapModel.getWalls()) {

			Element wallElement = new DefaultElement("wall");
			wallElement.addElement("X").addText(String.valueOf((int) dimension.getHeight()));
			wallElement.addElement("Y").addText(String.valueOf((int) dimension.getWidth()));
			wallElements.add(wallElement);
		}
		Element chestElement = new DefaultElement("Chest");
		chestElement.addElement("X").addText(String.valueOf((int) mapModel.getChest().getHeight()));
		chestElement.addElement("Y").addText(String.valueOf((int) mapModel.getChest().getWidth()));
		rootElement.add(chestElement);

		Element exitDoorElement = new DefaultElement("ExitDoor");
		exitDoorElement.addElement("X").addText(String.valueOf((int) mapModel.getExit().getHeight()));
		exitDoorElement.addElement("Y").addText(String.valueOf((int) mapModel.getExit().getWidth()));
		rootElement.add(exitDoorElement);

		Element characterElements = rootElement.addElement("Character");
		for (Map.Entry<String, MapModel> character : mapModel.getCharacters().entrySet()) {
			Element characterElement = new DefaultElement("character").addAttribute("name", character.getKey());
			characterElement.addElement("Behavior").addText(character.getValue().getCharacterBehavior());
			characterElement.addElement("X").addText(String.valueOf((int) character.getValue().getCharacterLocation().getHeight()));
			characterElement.addElement("Y").addText(String.valueOf((int) character.getValue().getCharacterLocation().getWidth()));
			characterElements.add(characterElement);
		}

		Element treasureElements = rootElement.addElement("Treasure");
		for (Map.Entry<String, Dimension> treasure : mapModel.getTreasures().entrySet()) {
			Element treasureElement = new DefaultElement("treasure").addAttribute("name", treasure.getKey());
			treasureElement.addElement("X").addText(String.valueOf((int) treasure.getValue().getHeight()));
			treasureElement.addElement("Y").addText(String.valueOf((int) treasure.getValue().getWidth()));
			treasureElements.add(treasureElement);
		}
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
 * This method returns the image of the character for the map 
 * @param Name
 * @return image
 * @author Appan Chhibber
 */
	public String getCharacterImagePath(String Name){
		this.file = new File("characters/"+Name+".xml");
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element rootElement=document.getRootElement();
		String image=rootElement.selectSingleNode("image").getText();
		return image;
	}
/**
 * This method is used to save the campaign created into xml file
 * @param file
 * @return message
 * @author Appan Chhibber
 */
	public String createCampaignFile(File file,ArrayList list){
		message="Campaign Saved Successfully";

		Document document=DocumentHelper.createDocument();
		Element rootElement=document.addElement("Campaign");
		Element mapElements=rootElement.addElement("Maps");
		int counter=0;
		for(Object map:list){
			counter++;
          Element mapElement=new DefaultElement("map").addAttribute("id",String.valueOf(counter));
          if(map.toString().contains(".xml")){
        	  mapElement.addElement("name").addText(map.toString());
          }else{
          mapElement.addElement("name").addText(map.toString()+".xml");
          }
  		mapElements.add(mapElement);
		}
		try {
			write(document,file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message="Campaign not Saved";
			e.printStackTrace();
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
		mapModel.mapName=rootElement.selectSingleNode("mapfilename").getText();
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
		
		if(rootElement.element("Character")!=null){
		Element characterNode=rootElement.element("Character");
		List<Element> characters=characterNode.elements();
		for(Element character:characters){
			MapModel model=new MapModel();
			Node characterX=character.selectSingleNode("X");
		    Node characterY=character.selectSingleNode("Y");
		    model.setCharacterName(character.attributeValue("name"));
			model.setCharacterLocation(new Dimension(Integer.parseInt(characterX.getText()), Integer.parseInt(characterY.getText())));
			model.setCharacterBehavior(character.selectSingleNode("Behavior").getText());
			model.setCharacterImage(getCharacterImagePath(character.attributeValue("name")));
			mapModel.characters.put(character.attributeValue("name"), model);
		}
		}
		if(rootElement.element("Treasure")!=null){
			Element treasureNode=rootElement.element("Treasure");
			List<Element> treasures=treasureNode.elements();
			for(Element treasure:treasures){
				Node treasureX=treasure.selectSingleNode("X");
			    Node treasureY=treasure.selectSingleNode("Y");
			    mapModel.treasurePresent=true;
				mapModel.treasures.put(treasure.attributeValue("name"), new Dimension(Integer.parseInt(treasureX.getText()), Integer.parseInt(treasureY.getText())));
			}
			}
		return mapModel;
	}
    /**
     * This method reads the selected campaign file 
     * @param file
     * @return Campaign Model
     * @author Appan Chhibber
     */
    public CampaignModel readCampaignFile(File file){
        CampaignModel campaignModel=new CampaignModel();
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element rootElement = document.getRootElement();
        Element mapElement=rootElement.element("Maps");
        List<Element> mapElements=mapElement.elements();
        DefaultListModel campaignMaps=new DefaultListModel();
        for(Element element:mapElements){
            Node mapName=element.selectSingleNode("name");
            campaignMaps.addElement(mapName.getText());
        }
        campaignModel.setCampMapList(campaignMaps);
        campaignModel.campaignName=file.getName().replace(".xml", "").trim();
        return campaignModel;
    }


}