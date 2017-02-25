package com.SOEN6441_DND.Model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Observable;

public class ItemModel extends Observable{
	
	public String name;
    public String image;
	public enum itemTypeList{Helmet,Armor,Shield,Ring,Belt,Boots,Weapon};
	public itemTypeList itemtype;
	public ArrayList subItemList;
	
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
		notifyObservers(this);
	}
}
