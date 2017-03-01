package com.SOEN6441_DND.Model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;

public class CampaignModel extends Observable {

	public String campaignName;
	public DefaultListModel mapList;
	public String message;

	public DefaultListModel selectedMapList;

	public DefaultListModel getSelectedMapList() {
		return selectedMapList;
	}

	public void setSelectedMapList(DefaultListModel selectedMapList) {
		this.selectedMapList = selectedMapList;
		message="selectedMapList";
		notifyCampaignView(message);
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public DefaultListModel getMapList() {
		return mapList;
	}

	public void setMapList(DefaultListModel mapList) {
		this.mapList = mapList;
		message="setMapList";
		notifyCampaignView(message);
	}

	public void notifyCampaignView(String message) {
		setChanged();
		this.message = message;
		notifyObservers(this);
	}
}
