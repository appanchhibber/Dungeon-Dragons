package com.SOEN6441_DND.Model;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * Model for starting the game
 * 
 * @author appan chhibber
 *
 */
public class StartGameModel {
	public String characterName;
	public String campaignName;
	public Boolean actAsComputer;

	public DefaultListModel characterList;
	public DefaultListModel campaignList;

	/**
	 * getter for characterList
	 * 
	 * @return
	 */
	public DefaultListModel getCharacterList() {
		return characterList;
	}

	/**
	 * setter for characterlist
	 * 
	 * @param characterList
	 */
	public void setCharacterList(DefaultListModel characterList) {
		this.characterList = characterList;
	}

	/**
	 * getter for campaign list
	 * 
	 * @return
	 */
	public DefaultListModel getCampaignList() {
		return campaignList;
	}

	/**
	 * setter for campaign list
	 * 
	 * @param campaignList
	 */
	public void setCampaignList(DefaultListModel campaignList) {
		this.campaignList = campaignList;
	}

}
