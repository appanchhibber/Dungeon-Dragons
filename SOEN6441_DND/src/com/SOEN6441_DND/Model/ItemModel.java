package com.SOEN6441_DND.Model;

import java.awt.Image;

public class ItemModel {
	
	public String name;
    public Image image;
	public enum itemTypeList{Helmet,Armor,Shield,Ring,Belt,Boots,Weapon};
	public itemTypeList itemtype;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
