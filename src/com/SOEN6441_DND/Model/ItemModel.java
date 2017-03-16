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
    
    
    public ItemModel(){
    	savedItemTypeList=new DefaultComboBoxModel();
    	savedItemNameList=new DefaultComboBoxModel();
    	savedEnchantValueList=new HashMap<String,String>();
    }
    
    //for reading file data //
    public DefaultComboBoxModel savedItemTypeList;
    public DefaultComboBoxModel savedItemNameList;
    public HashMap<String,String> savedEnchantValueList;
    
    public HashMap<String,String> getSavedEnchantValueList(){
    	return savedEnchantValueList;
    }
    public DefaultComboBoxModel getSavedItemTypeList() {
		return savedItemTypeList;
	}

	public DefaultComboBoxModel getSavedItemNameList() {
		return savedItemNameList;
	}

	//----------------------//
    public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getSubItemType() {
		return subItemType;
	}

	public void setSubItemType(String subItemType) {
		this.subItemType = subItemType;
	}

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
	public itemTypeList itemtype;
	public ArrayList subItemList;
	public String itemDecsription;
	
	public itemTypeList getItemtype() {
		return itemtype;
	}

	public void setItemtype(itemTypeList itemtype) {
		this.itemtype = itemtype;
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
