package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Views.CampaignView;
import com.SOEN6441_DND.Views.MapView;


/**
 * 
 * @author Appan Chhibber
 *
 */
public class CampaignViewController implements ActionListener {
	CampaignView campaignView;
	FileOperationModel ioModel;
	CampaignModel campaignModel;
	private GameController gameController;
	
	/**
	 * This is constructor assigning passed input Campaign view
	 * 
	 * @param view
	 */
	public CampaignViewController(CampaignView view)
	{
		gameController=GameController.getInstance();
		campaignView=view;
		ioModel=view.ioModel;
		this.campaignModel=view.campaignModel;
	}

	@Override
	/**
	 * This function is handling the action listener from thecampaign view.
	 */
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
        else if (e.getSource()==campaignView.navPanel.saveButton){
        	DefaultListModel list=(DefaultListModel)campaignView.campMaps.getModel();
        	if(campaignView.nameText.getText().equals(""))
        	{
        	JOptionPane.showMessageDialog(null, "Enter name of the campaign");	
        	}
        	else{
          ArrayList arrayList=Collections.list(list.elements());
          File file=new File("campaign/"+campaignView.nameText.getText()+".xml");
          String result= ioModel.createCampaignFile(file,arrayList);
          JOptionPane.showMessageDialog(null, result);
        	}
        }
        else if(e.getSource()==campaignView.navPanel.loadButton)
        {
        	File file = openCampaignFile();
			campaignModel=ioModel.readCampaignFile(file);
			String mode="edit";
			gameController.mainFrame.setView(new CampaignView(campaignModel,mode));
        }
		
        }

	// To Open Dialog Box
	public File openCampaignFile() {
		JFileChooser fileChooser = new JFileChooser(new File("campaign/"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML",
				"xml");
		fileChooser.setFileFilter(filter);
		int option = fileChooser.showOpenDialog(gameController.mainFrame);

		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			return file;
		} else {
			return null;
		}
	}

		
	}

