package com.SOEN6441_DND.Model;

import java.awt.Image;

public class Shield extends ItemModel{

	private String type;
	private String name;
	private Image img;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
}

