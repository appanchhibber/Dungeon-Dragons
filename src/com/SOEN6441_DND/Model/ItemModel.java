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
public class ItemModel extends Observable {

	public String name;
	public String image;
	public String itemType;
	public String subItemType;
	public int enchantValue;
	public String weaponType;
	public int weaponRange;

	public boolean burning;
	public boolean pacifying;
	public boolean frightening;
	public boolean freezing;
	public boolean slaying;

	// for reading file data //
	public DefaultComboBoxModel savedItemTypeList;
	public DefaultComboBoxModel savedItemNameList;
	public HashMap<String, String> savedEnchantValueList;
	public DefaultComboBoxModel weaponTypeList;
	public DefaultComboBoxModel weaponRangeList;
	public Boolean chestNeeded;
	public ArrayList chestFileList;

	public enum itemTypeList {
		Helmet, Armor, Shield, Ring, Belt, Boots, Weapon
	};

	public String[] enchanListValues = { "1", "2", "3", "4", "5" };
	public ArrayList subItemList;
	public String itemDecsription;
	public String message;

	/**
	 * getter for burning enchantment
	 * 
	 * @return
	 */
	public boolean isBurning() {
		return burning;
	}

	/**
	 * setter for burning enchantment
	 * 
	 * @param burning
	 */
	public void setBurning(boolean burning) {
		this.burning = burning;
	}

	/**
	 * getter for pacifying enchantment
	 * 
	 * @return
	 */
	public boolean isPacifying() {
		return pacifying;
	}

	/**
	 * setter for pacifying enchantment
	 * 
	 * @param pacifying
	 */
	public void setPacifying(boolean pacifying) {
		this.pacifying = pacifying;
	}

	/**
	 * getter for frightening enchantment
	 * 
	 * @return
	 */
	public boolean isFrightening() {
		return frightening;
	}

	/**
	 * setter for frightening enchantment
	 * 
	 * @param frightening
	 */
	public void setFrightening(boolean frightening) {
		this.frightening = frightening;
	}

	/**
	 * getter for freezing enchantment
	 * 
	 * @return
	 */
	public boolean isFreezing() {
		return freezing;
	}

	/**
	 * setter for freezing enchantment
	 * 
	 * @param freezing
	 */
	public void setFreezing(boolean freezing) {
		this.freezing = freezing;
	}

	/**
	 * getter for slaying enchantment
	 * 
	 * @return
	 */
	public boolean isSlaying() {
		return slaying;
	}

	/**
	 * setter for slaying enchantment
	 * 
	 * @param slaying
	 */
	public void setSlaying(boolean slaying) {
		this.slaying = slaying;
	}

	/**
	 * This method returns the type of Weapon of type String
	 * 
	 * @return String weaponType
	 */
	public String getWeaponType() {
		return weaponType;
	}

	/**
	 * This method sets the type of weapon.
	 * 
	 * @param weaponType
	 *            String
	 */
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
		notifyItemView("weaponType changed");
	}

	/**
	 * This method returns the range of the weapon of type String.
	 * 
	 * @return weaponRange String
	 */
	public int getWeaponRange() {
		return weaponRange;
	}

	/**
	 * This method sets the range of the weapon
	 * 
	 * @param weaponRange
	 */
	public void setWeaponRange(int weaponRange) {
		this.weaponRange = weaponRange;
		notifyItemView("weaponRange changed");
	}

	/**
	 * Constructor of ItemModel Class
	 */
	public ItemModel() {
		savedItemTypeList = new DefaultComboBoxModel();
		savedItemNameList = new DefaultComboBoxModel();
		savedEnchantValueList = new HashMap<String, String>();
		weaponTypeList = new DefaultComboBoxModel();
		weaponRangeList = new DefaultComboBoxModel();
	}

	/**
	 * setter for weapon type list
	 * 
	 * @param weaponTypeList
	 */
	public void setWeaponTypeList(DefaultComboBoxModel weaponTypeList) {
		this.weaponTypeList = weaponTypeList;
	}

	/**
	 * setter for weapon range list
	 * 
	 * @param weaponRangeList
	 */
	public void setWeaponRangeList(DefaultComboBoxModel weaponRangeList) {
		this.weaponRangeList = weaponRangeList;
	}

	/**
	 * This methods returns the list of weapon Ranges.
	 * 
	 * @return weaponRangeList
	 */
	public DefaultComboBoxModel getWeaponRangeList() {
		return weaponRangeList;
	}

	/**
	 * This method returns enchantList of the items
	 * 
	 * @return
	 */
	public HashMap<String, String> getSavedEnchantValueList() {
		return savedEnchantValueList;
	}

	/**
	 * This method returns type of the items as a list.
	 * 
	 * @return
	 */
	public DefaultComboBoxModel getSavedItemTypeList() {
		return savedItemTypeList;
	}

	/**
	 * This method returns type of weapon as a list.
	 * 
	 * @return weaponTypeList
	 */
	public DefaultComboBoxModel getWeaponTypeList() {
		return weaponTypeList;
	}

	/**
	 * This method returns the saved item names added by the user as a list.
	 * 
	 * @return savedItemNameList
	 */
	public DefaultComboBoxModel getSavedItemNameList() {
		return savedItemNameList;
	}

	/**
	 * This method returns the name type of the item.
	 * 
	 * @return itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * This method returns type of item.
	 * 
	 * @return subItemType
	 */
	public String getSubItemType() {
		return subItemType;
	}

	/**
	 * This method sets the subItem for the Item
	 * 
	 * @param subItemType
	 */
	public void setSubItemType(String subItemType) {
		this.subItemType = subItemType;
	}

	/**
	 * This method returns the enchantment Value of the item
	 * 
	 * @return enchantValue
	 */
	public int getEnchantValue() {
		return enchantValue;
	}

	/**
	 * setter for enchantment value
	 * 
	 * @param enchantValue
	 */
	public void setEnchantValue(int enchantValue) {
		this.enchantValue = enchantValue;
	}

	/**
	 * getter for enchantment list values
	 * 
	 * @return
	 */
	public String[] getEnchanListValues() {
		return enchanListValues;
	}

	/**
	 * getter for chest file list
	 * 
	 * @return
	 */
	public ArrayList getChestFileList() {
		return chestFileList;
	}

	/**
	 * setter for chest file list
	 * 
	 * @param chestFileList
	 */
	public void setChestFileList(ArrayList chestFileList) {
		this.chestFileList = chestFileList;
		message = "chestListPopulated";
		notifyItemView(message);
	}

	/**
	 * setter for enchant list values
	 * 
	 * @param enchanListValues
	 */
	public void setEnchanListValues(String[] enchanListValues) {
		this.enchanListValues = enchanListValues;
	}

	/**
	 * getter for item type
	 * 
	 * @return
	 */
	public String getItemtype() {
		return itemType;
	}

	/**
	 * setter for item type
	 * 
	 * @param itemType
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
		message = "itemType changed";
		notifyItemView(message);
	}

	/**
	 * getter for item descsription
	 * 
	 * @return
	 */
	public String getItemDecsription() {
		return itemDecsription;
	}

	/**
	 * setter for item decsription
	 * 
	 * @param itemDecsription
	 */
	public void setItemDecsription(String itemDecsription) {
		this.itemDecsription = itemDecsription;
		message = "DescriptionChanged";
		notifyItemView(message);
	}

	/**
	 * getter for name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for image
	 * 
	 * @return
	 */
	public String getImage() {
		return image;
	}

	/**
	 * setter for image
	 * 
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
		message = "ImageChanged";
		notifyItemView(message);
	}

	/**
	 * getter for subitemlist
	 * 
	 * @return
	 */
	public ArrayList getSubItemList() {
		return subItemList;
	}

	/**
	 * setter for subitem list
	 * 
	 * @param subItemList
	 */
	public void setSubItemList(ArrayList subItemList) {
		this.subItemList = subItemList;
		message = "SubItemTypeListChanged";
		notifyItemView(message);
	}

	/**
	 * method for firing observer change and notify functions
	 * 
	 * @param message
	 */
	public void notifyItemView(String message) {
		setChanged();
		this.message = message;
		notifyObservers(this);
	}
}
