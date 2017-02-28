package com.SOEN6441_DND.Model;

import java.util.ArrayList;
import java.util.Observable;

public class CampaignModel extends Observable {

	public String campaignName;
	public ArrayList<String> mapList;
	public String message;
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public ArrayList<String> getMapList() {
		return mapList;
	}
	public void setMapList(ArrayList<String> mapList) {
		this.mapList = mapList;
		notifyCampaignView(message);
	}
	public void notifyCampaignView(String message)
	{
		setChanged();
		this.message=message;
		notifyObservers(this);
	}
}
