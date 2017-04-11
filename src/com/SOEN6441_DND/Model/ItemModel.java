package com.SOEN6441_DND.Model;


import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
/**
 * This Class is a view for Item Creation and Manipulation. This class is
 * observe by Item Model.	
 * 
 * @author Paras Malik
 * @author Amirbabak Rahgozar
 *
 */
public class ItemModel extends Observable{
	
	public String name;
    public String image;
    public String itemType;
    public String subItemType;
    public int enchantValue;
    public String weaponType;
    public String weaponRange;
    public ArrayList<String> enchatCheckValues;
    
    /**
     * This method returns the type of Weapon of type String
     * @return String weaponType
     */
    public String getWeaponType() {
		return weaponType;
	}
    
    /**
     * This method sets the type of weapon.
     * @param weaponType String
     */
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
		notifyItemView("weaponType changed");
	}
	
	/**
	 * This method returns the range of the weapon of type String.
	 * @return weaponRange String
	 */
	public String getWeaponRange() {
		return weaponRange;
	}
	
	/**
	 * This method sets the range of the weapon
	 * @param weaponRange
	 */
	public void setWeaponRange(String weaponRange) {
		this.weaponRange = weaponRange;
		notifyItemView("weaponRange changed");
	}
	
	/**
	 * Constructor of ItemModel Class
	 */
	public ItemModel(){
    	savedItemTypeList=new DefaultComboBoxModel();
    	savedItemNameList=new DefaultComboBoxModel();
    	savedEnchantValueList=new HashMap<String,String>();
    	weaponTypeList = new DefaultComboBoxModel();
    	weaponRangeList = new DefaultComboBoxModel();
    	enchatCheckValues = new ArrayList<>();
    }
    
    public void setWeaponTypeList(DefaultComboBoxModel weaponTypeList) {
		this.weaponTypeList = weaponTypeList;
	}

	public void setWeaponRangeList(DefaultComboBoxModel weaponRangeList) {
		this.weaponRangeList = weaponRangeList;
	}

	//for reading file data //
    public DefaultComboBoxModel savedItemTypeList;
    public DefaultComboBoxModel savedItemNameList;
    public HashMap<String,String> savedEnchantValueList;
    public DefaultComboBoxModel weaponTypeList;
    public DefaultComboBoxModel weaponRangeList;
    
    /**
     * This methods returns the list of weapon Ranges.
     * @return weaponRangeList
     */
    public DefaultComboBoxModel getWeaponRangeList() {
		return weaponRangeList;
	}
    
    /**
     * This method returns enchantList of the items
     * @return
     */
	public HashMap<String,String> getSavedEnchantValueList(){
    	return savedEnchantValueList;
    }
	
	/**
	 * This method returns type of the items as a list.
	 * @return
	 */
    public DefaultComboBoxModel getSavedItemTypeList() {
		return savedItemTypeList;
	}

    /**
     * This method returns type of weapon as a list.
     * @return weaponTypeList
     */
	public DefaultComboBoxModel getWeaponTypeList() {
		return weaponTypeList;
	}
	
	/**
	 * This method returns the saved item names added by the user as a list.
	 * @return savedItemNameList
	 */
	public DefaultComboBoxModel getSavedItemNameList() {
		return savedItemNameList;
	}

/**
 * This method returns the name type of the item.
 * @return itemType
 */
    public String getItemType() {
		return itemType;
	}

/**
 * This method returns type of item.
 * @return subItemType
 */
	public String getSubItemType() {
		return subItemType;
	}

	/**
	 * This method sets the subItem for the Item
	 * @param subItemType
	 */
	public void setSubItemType(String subItemType) {
		this.subItemType = subItemType;
	}

	/**
	 * This method returns the enchantment Value of the item
	 * @return enchantValue
	 */
	public int getEnchantValue() {
		return enchantValue;
	}

	public void setEnchantValue(int enchantValue) {
		this.enchantValue = enchantValue;
	}

	public Boolean chestNeeded;
	public String[] getEnchanListValues() {
		return enchanListValues;
	}

	public ArrayList chestFileList;
	public ArrayList getChestFileList() {
		return chestFileList;
	}

	public void setChestFileList(ArrayList chestFileList) {
		this.chestFileList = chestFileList;
		message="chestListPopulated";
		notifyItemView(message);
	}

	public void setEnchanListValues(String[] enchanListValues) {
		this.enchanListValues = enchanListValues;
	}
	public enum itemTypeList{Helmet,Armor,Shield,Ring,Belt,Boots,Weapon};
	public String[] enchanListValues = {"1","2","3","4","5"};
	public ArrayList subItemList;
	public String itemDecsription;
	
	public String getItemtype() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
		message = "itemType changed";
		notifyItemView(message);
	}

	public String getItemDecsription() {
		return itemDecsription;
	}

	public void setItemDecsription(String itemDecsription) {
		this.itemDecsription = itemDecsription;
		message="DescriptionChanged";
		notifyItemView(message);
	}
	public String message;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	 message="ImageChanged";
		notifyItemView(message);
	}

	public ArrayList getSubItemList() {
		return subItemList;
	}

	public void setSubItemList(ArrayList subItemList) {
		this.subItemList = subItemList;
		 message="SubItemTypeListChanged";
		notifyItemView(message);
	}	
	public void notifyItemView(String message)
	{
		setChanged();
		this.message=message;
		notifyObservers(this);
	}
}
