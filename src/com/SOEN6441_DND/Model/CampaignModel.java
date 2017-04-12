package com.SOEN6441_DND.Model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;

/**
 * this model is for the campaign screen
 * 
 * @author Appan Chhibber
 *
 */
public class CampaignModel extends Observable {

	public String campaignName;
	public DefaultListModel mapList;
	public DefaultListModel selectedMapList;
	public DefaultListModel campMapList;
	public String message;

	/**
	 * getter for campaign name
	 * 
	 * @return
	 */
	public String getCampaignName() {
		return campaignName;
	}

	/**
	 * setter for campaign name
	 * 
	 * @param campaignName
	 */
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	/**
	 * getter for campaign map list
	 * 
	 * @return
	 */
	public DefaultListModel getCampMapList() {
		return campMapList;
	}

	/**
	 * setter for campaign map list
	 * 
	 * @param campMapList
	 */
	public void setCampMapList(DefaultListModel campMapList) {
		this.campMapList = campMapList;
		message = "setCampMapList";
		notifyCampaignView(message);
	}

	/**
	 * getter for selected map list
	 * 
	 * @return
	 */
	public DefaultListModel getSelectedMapList() {
		return selectedMapList;
	}

	/**
	 * setter for selected map list
	 * 
	 * @param selectedMapList
	 */
	public void setSelectedMapList(DefaultListModel selectedMapList) {
		this.selectedMapList = selectedMapList;
		message = "selectedMapList";
		notifyCampaignView(message);
	}

	/**
	 * getter for map list
	 * 
	 * @return
	 */
	public DefaultListModel getMapList() {
		return mapList;
	}

	/**
	 * setter for maplist
	 * 
	 * @param mapList
	 */
	public void setMapList(DefaultListModel mapList) {
		this.mapList = mapList;
		message = "setMapList";
		notifyCampaignView(message);
	}

	/**
	 * This is Observer function notifying abou the changes to Campaign View.
	 * 
	 * @param message
	 */
	public void notifyCampaignView(String message) {
		setChanged();
		this.message = message;
		notifyObservers(this);
	}
}
