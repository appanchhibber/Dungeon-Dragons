package com.SOEN6441_DND.Model;

import java.awt.Image;

/**
 * This class defines properties of the shield. This class extends ItemModel.
 * 
 * @author Amirbabak Rahgozar
 * @author Ehab Amar
 */
public class ShieldModel extends ItemModel {

	private String type;
	private String name;
	private Image img;

	/**
	 * getter for shield type
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * setter for shield type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getter for name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for image
	 * 
	 * @return
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * setter for image
	 * 
	 * @param img
	 */
	public void setImg(Image img) {
		this.img = img;
	}
}
