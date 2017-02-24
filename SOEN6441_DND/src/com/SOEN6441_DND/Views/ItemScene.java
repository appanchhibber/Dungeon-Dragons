package com.SOEN6441_DND.Views;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import com.SOEN6441_DND.Controller.ItemSceneController;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Model.ItemModel.itemTypeList;

/**
 * This Class is a view for Item Creation and Manipulation.
 * This class is observe by Item Model.
 * @author Paras Malik
 * @author Amirbabak Rahgozar
 *
 */
public class ItemScene extends View {
	//Panels
	View imagePanel;
	NavigationPanelView navMenuPanel;
	public View itemViewPanel;
	
	//Models
	public ItemModel itemViewModel;
	
	//ComboBox
	public JComboBox<itemTypeList> itemType;
	public JComboBox itemList;
	
	//Label
	public JLabel itemTypeLabel;
	
	//Controllers
	public ItemSceneController itemController;
 
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		itemViewModel = new ItemModel();
		itemController = new ItemSceneController(this);
		
		itemViewPanel= new View();
		itemViewPanel.setBackground(Color.BLACK);
		itemViewPanel.setSize(300, 500);
		itemViewPanel.setLocation(335, 70);
		itemViewPanel.setVisible(true);
		
		imagePanel = new View();
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setSize(300, 475);
		imagePanel.setLocation(20, 70);
		
		itemTypeLabel= new JLabel("Select Item :");
		itemTypeLabel.setSize(80,20);
		itemTypeLabel.setLocation(30,20);
		itemTypeLabel.setForeground(Color.WHITE);
		
		itemType= new JComboBox<itemTypeList>(itemTypeList.values());
		itemType.addActionListener(itemController);
		itemType.setSize(140,40);
		itemType.setLocation(150,10);
		
		
		itemViewPanel.add(itemTypeLabel);
		itemViewPanel.add(itemType);
		
		
		
		navMenuPanel = new NavigationPanelView();
		this.add(navMenuPanel);	
		this.add(itemViewPanel);
		this.add(imagePanel);
	}

}
