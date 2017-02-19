package com.SOEN6441_DND.Model;

import java.awt.Image;

public abstract class ItemModel {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Image image;
	
	private ItemModel type;
	

}
