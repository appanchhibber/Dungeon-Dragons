package com.SOEN6441_DND.Model;

import java.awt.Image;

/**
 * Model for ring item
 * @author Paras Malik
 *
 */
public class RingModel extends ItemModel{
	
	private String type;
	private String name;
	private Image img;
	/**
	 * getter for ring type
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * setter for ring type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * getter for ring name
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter for ring name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter for ring image
	 * @return
	 */
	public Image getImg() {
		return img;
	}
	/**
	 * setter for ring image
	 * @param img
	 */
	public void setImg(Image img) {
		this.img = img;
	}
}

