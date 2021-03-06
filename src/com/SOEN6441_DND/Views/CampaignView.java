package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.SOEN6441_DND.Controller.CampaignViewController;
import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.FileOperationModel;

/**
 * This view is responsible for creation and editing of the campaign
 * 
 * @author Appan Chhibber
 *
 */
public class CampaignView extends View implements Observer {

	public NavigationPanelView navPanel;
	public FileOperationModel ioModel;
	public CampaignViewController campaignController;
	public CampaignModel campaignModel;
	public View buttonView;
	public JLabel availMap;
	public JLabel campaignMap;
	public JLabel nameLabel;

	public JTextField nameText;
	public JList maps;
	public JList campMaps;

	public JButton addMap;
	public JButton addAllMaps;
	public JButton removeMap;
	public JButton removeAllMaps;

	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();

		// Name Character
		nameLabel = new JLabel("Name :");
		nameText = new JTextField();
		nameLabel.setLocation(20, 20);
		nameText.setLocation(70, 15);
		nameLabel.setSize(80, 20);
		nameText.setSize(250, 30);
		this.add(nameLabel);
		this.add(nameText);

		availMap = new JLabel("Maps:");
		availMap.setSize(70, 20);
		availMap.setLocation(20, 50);
		maps = new JList();
		JScrollPane scrollPane1 = new JScrollPane(maps);
		scrollPane1.setBounds(20, 70, 300, 475);
		buttonView = new View();
		buttonView.setSize(250, 475);
		buttonView.setLocation(325, 70);
		buttonView.setBackground(Color.DARK_GRAY);

		addMap = new JButton("Add  >");
		addMap.setSize(120, 30);
		addMap.setLocation(65, 20);

		buttonView.add(addMap);

		/*
		 * addAllMaps=new JButton("Add All  >>"); addAllMaps.setSize(120,30);
		 * addAllMaps.setLocation(65, 70);
		 * 
		 * buttonView.add(addAllMaps);
		 */

		removeMap = new JButton("Remove  <");
		removeMap.setSize(120, 30);
		removeMap.setLocation(65, 170);
		removeMap.setEnabled(false);

		buttonView.add(removeMap);

		/*
		 * removeAllMaps=new JButton("Remove All  <<");
		 * removeAllMaps.setSize(120,30); removeAllMaps.setLocation(65,220);
		 * removeAllMaps.setEnabled(false);
		 * 
		 * buttonView.add(removeAllMaps);
		 */
		buttonView.setVisible(true);

		campaignMap = new JLabel("Campaign Maps:");
		campaignMap.setSize(130, 20);
		campaignMap.setLocation(585, 50);

		campMaps = new JList(new DefaultListModel());
		JScrollPane scrollPane2 = new JScrollPane(campMaps);
		scrollPane2.setBounds(585, 70, 270, 475);

		navPanel = new NavigationPanelView();
		this.add(scrollPane1);
		this.add(scrollPane2);
		this.add(buttonView);
		this.add(navPanel);
		this.add(availMap);
		this.add(campaignMap);
		this.setVisible(true);

	}

	/**
	 * Constructor for passing the model from controller to the view and also
	 * the mode in which the view has to be ie. create or edit mode
	 * 
	 * @param model
	 * @param mode
	 * @author Appan Chhibber
	 */
	public CampaignView(CampaignModel model, String mode) {
		this.campaignModel = model;

		ioModel = new FileOperationModel();
		campaignController = new CampaignViewController(this);

		addMap.addActionListener(campaignController);
		// addAllMaps.addActionListener(campaignController);
		removeMap.addActionListener(campaignController);
		// removeAllMaps.addActionListener(campaignController);
		navPanel.saveButton.addActionListener(campaignController);
		navPanel.loadButton.addActionListener(campaignController);
		this.campaignModel.setMapList(ioModel.getAllFolderFile("maps"));
		maps.setModel(campaignModel.getMapList());

		if (mode == "edit") {
			campMaps.setModel(campaignModel.getCampMapList());
			nameText.setText(campaignModel.campaignName);
		}
		campaignModel.addObserver(this);
	}

	/**
	 * Observer update method to make the changes made to be reflected on the
	 * view
	 * 
	 * @author Appan Chhibber
	 */
	@Override
	public void update(Observable o, Object arg) {

		// TODO Auto-generated method stub
		this.campaignModel = (CampaignModel) o;

		if (campaignModel.message.equals("setCampMapList")) {
			campMaps.setModel(campaignModel.getCampMapList());
			maps.setModel(new DefaultListModel());
			// removeAllMaps.setEnabled(true);
			removeMap.setEnabled(true);
		}
		/*
		 * else if(campaignModel.message=="RemoveAll") {
		 * maps.setModel(ioModel.getAllFolderFile("maps"));
		 * campMaps.setModel(new DefaultListModel());
		 * removeAllMaps.setEnabled(false); removeMap.setEnabled(false); }
		 */
		else if (campaignModel.message == "selectedMapList") {
			campMaps.setModel(campaignModel.getSelectedMapList());
			maps.setModel(campaignModel.getMapList());
			// removeAllMaps.setEnabled(true);
			removeMap.setEnabled(true);
		} else if (campaignModel.message == "setMapList") {
			campMaps.setModel(campaignModel.getSelectedMapList());
			maps.setModel(campaignModel.getMapList());
			if (campMaps.getSize() == null) {
				// removeAllMaps.setEnabled(false);
				removeMap.setEnabled(false);
			}
		}

	}

}
