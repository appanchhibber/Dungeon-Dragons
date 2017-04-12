package com.SOEN6441_DND.Model;

import java.awt.Image;

/**
 * Model class for the armor item
 * 
 * @author Paras Malik
 *
 */
public class ArmorModel extends ItemModel {

	private String type;
	private String name;
	private Image img;

	/**
	 * getter for armor type
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * setter for armor type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getter for armor name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for armor name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for armor image
	 * 
	 * @return
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * setter for armor image
	 * 
	 * @param img
	 */
	public void setImg(Image img) {
		this.img = img;
	}
}
