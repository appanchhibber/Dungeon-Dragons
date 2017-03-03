package com.SOEN6441_DND.Model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;

/**
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
	public String getCampaignName() {
		return campaignName;
	}
	
	/**
	 * 
	 * @param campaignName
	 */
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
	public DefaultListModel getCampMapList() {
		return campMapList;
	}
	
	/**
	 * 
	 * @param campMapList
	 */
	public void setCampMapList(DefaultListModel campMapList) {
		this.campMapList = campMapList;
		message="setCampMapList";
		notifyCampaignView(message);
	}
	public DefaultListModel getSelectedMapList() {
		return selectedMapList;
	}
	/**
	 * 
	 * @param selectedMapList
	 */
	public void setSelectedMapList(DefaultListModel selectedMapList) {
		this.selectedMapList = selectedMapList;
		message="selectedMapList";
		notifyCampaignView(message);
	}
	public DefaultListModel getMapList() {
		return mapList;
	}
	
	/**
	 * 
	 * @param mapList
	 */
	public void setMapList(DefaultListModel mapList) {
		this.mapList = mapList;
	 message="setMapList";
		notifyCampaignView(message);
	}
	/**
	 * This is Observer function notifying abou the changes to Campaign View.
	 * @param message
	 */
	public void notifyCampaignView(String message)
	{
		setChanged();
		this.message=message;
		notifyObservers(this);
	}
}
