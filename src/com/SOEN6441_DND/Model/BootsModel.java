package com.SOEN6441_DND.Model;

import java.awt.Image;

/**
 * This model is for boots
 * 
 * @author Paras Malik
 *
 */
public class BootsModel {

	private String type;
	private String name;
	private Image img;

	/**
	 * getter for boots type
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * setter for boots type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getter for boots name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for boots name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for boots image
	 * 
	 * @return
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * setter for boots image
	 * 
	 * @param img
	 */
	public void setImg(Image img) {
		this.img = img;
	}
}
