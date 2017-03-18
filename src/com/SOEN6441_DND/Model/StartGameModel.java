package com.SOEN6441_DND.Model;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class StartGameModel {
	public String characterName;
	public String campaignName;
	
	public DefaultListModel characterList;
	public DefaultListModel campaignList;
	public DefaultListModel getCharacterList() {
		return characterList;
	}
	public void setCharacterList(DefaultListModel characterList) {
		this.characterList = characterList;
	}
	public DefaultListModel getCampaignList() {
		return campaignList;
	}
	public void setCampaignList(DefaultListModel campaignList) {
		this.campaignList = campaignList;
	}
	

}
