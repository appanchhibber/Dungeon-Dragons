package com.SOEN6441_DND.Model;

import java.awt.Image;

/**
 * This model is for belt
 * 
 * @author Paras Malik
 *
 */
public class BeltModel extends ItemModel {

	private String type;
	private String name;
	private Image img;

	/**
	 * getter for belt type
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * setter for belt type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getter for belt name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for belt name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for belt image
	 * 
	 * @return
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * setter for belt image
	 * 
	 * @param img
	 */
	public void setImg(Image img) {
		this.img = img;
	}
}
