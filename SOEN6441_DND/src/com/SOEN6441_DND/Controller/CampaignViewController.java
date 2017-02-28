package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Views.CampaignView;

public class CampaignViewController implements ActionListener {
	CampaignView campaignView;
	FileOperationModel ioModel;
	CampaignModel campaignModel;
	public CampaignViewController(CampaignView view)
	{
		campaignView=view;
		ioModel=view.ioModel;
		this.campaignModel=view.campaignModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getSource()==campaignView.addAllMaps){
			campaignModel.notifyCampaignView("AddAll");
		}
		else if(e.getSource()==campaignView.removeAllMaps){
			campaignModel.notifyCampaignView("RemoveAll");
		}
		
	}
	
	

}
