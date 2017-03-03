package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

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
			campaignModel.setCampMapList(campaignModel.getMapList());

		}
		else if(e.getSource()==campaignView.removeAllMaps){
			campaignModel.notifyCampaignView("RemoveAll");
		}
        else if(e.getSource()==campaignView.addMap){
             DefaultListModel model=(DefaultListModel)campaignView.campMaps.getModel();
             for (Object selectedValue : campaignView.maps.getSelectedValuesList()) {
                    model.addElement(selectedValue);
                    campaignModel.mapList.removeElement(selectedValue);
                }
             campaignModel.setSelectedMapList(model);
             
            }
        else if(e.getSource()==campaignView.removeMap){
            DefaultListModel model =(DefaultListModel)campaignView.maps.getModel();
            campaignModel.campMapList=(DefaultListModel)campaignView.campMaps.getModel();
            for(Object selectedValue: campaignView.campMaps.getSelectedValuesList()){
                model.addElement(selectedValue);
                campaignModel.campMapList.removeElement(selectedValue);
            }

            campaignModel.setMapList(model);
        }
        }


		
	}
