package com.SOEN6441_DND.Views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.SOEN6441_DND.Model.ItemModel.itemTypeList;

public class ItemAssignView extends View {
public View itemPanel;
public View backpackPanel;
public View navPanel;


public JLabel itemTypeLabel;
public JLabel itemSubTypeLabel;

public JComboBox itemType;
public JComboBox subItemType;


public JButton backpackAssign;
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		itemPanel=new View();
		itemPanel.setBackground(Color.BLACK);
		itemPanel.setSize(300, 500);
		itemPanel.setLocation(20,30);
		itemPanel.setVisible(true);

		itemTypeLabel = new JLabel("Select Item Type:");
		itemTypeLabel.setSize(100, 20);
		itemTypeLabel.setLocation(30, 20);
		itemTypeLabel.setForeground(Color.WHITE);
		itemPanel.add(itemTypeLabel);
		itemType = new JComboBox();
		itemType.setSize(140, 40);
		itemType.setLocation(150, 10);
        itemPanel.add(itemType);
		
		itemSubTypeLabel = new JLabel("Select Item:");
		itemSubTypeLabel.setSize(80, 20);
		itemSubTypeLabel.setLocation(30, 90);
		itemSubTypeLabel.setForeground(Color.WHITE);
		itemPanel.add(itemSubTypeLabel);
		subItemType = new JComboBox();
		subItemType.setSize(140, 40);
		subItemType.setLocation(150, 80);
		itemPanel.add(subItemType);
		
		backpackAssign=new JButton("Add To Backpack");
		backpackAssign.setSize(120,30);
		backpackAssign.setLocation(75, 180);
		itemPanel.add(backpackAssign);
		backpackPanel=new View();
		navPanel=new View();
		this.add(itemPanel);
		this.add(backpackPanel);
		this.add(navPanel);
		this.setVisible(true);
		
	}

}
