package com.SOEN6441_DND.Views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
/**
 *This is the view that is responsible for assigning item to the character 
 * @author Appan Chhibber
 *
 */
public class ItemAssignView extends View {
public View itemPanel;
public View backpackPanel;
public JPanel navPanel;


public JLabel itemTypeLabel;
public JLabel itemSubTypeLabel;

public JComboBox itemType;
public JComboBox subItemType;

public JList backpackList;
public JList assignItemList;

public JButton backpackAssign;
public JButton charBackButton;
public JButton addItem;
public JButton removeItem;
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		itemPanel=new View();
		itemPanel.setBackground(Color.BLACK);
		itemPanel.setSize(300, 500);
		itemPanel.setLocation(20,30);
		itemPanel.setVisible(true);
		
		backpackPanel=new View();
		backpackPanel.setBackground(Color.BLACK);
		backpackPanel.setSize(500, 500);
		backpackPanel.setLocation(340,30);
		backpackList=new JList();
		backpackList.setSize(200, 480);
		backpackList.setLocation(10, 10);
		backpackPanel.add(backpackList);
		
		addItem=new JButton(">");
		addItem.setSize(50,30);
		addItem.setLocation(220, 100);
		backpackPanel.add(addItem);
		
		removeItem=new JButton("<");
		removeItem.setSize(50,30);
		removeItem.setLocation(220, 200);
		backpackPanel.add(removeItem);
		
		assignItemList=new JList();
		assignItemList.setSize(200, 480);
		assignItemList.setLocation(290, 10);
		backpackPanel.add(assignItemList);
		backpackPanel.setVisible(true);
		
		
		navPanel=new JPanel();
		navPanel.setBackground(Color.BLACK);
		navPanel.setSize(860, 75);
		navPanel.setLocation(0,550);
		navPanel.setVisible(true);
		backpackAssign=new JButton("Back To  Character Screen");
		backpackAssign.setSize(240,30);
		backpackAssign.setLocation(190,45);
		navPanel.add(backpackAssign);
		this.setSize(860, 645);
		this.add(itemPanel);
		this.add(backpackPanel);
		this.add(navPanel);
		this.setVisible(true);
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
		backpackAssign.setSize(160,30);
		backpackAssign.setLocation(75, 180);
		
		itemPanel.add(backpackAssign);
		
		
		
		
		
		
		
	
		charBackButton=new JButton("Back To Character Screen");
		charBackButton.setSize(240,30);
		charBackButton.setLocation(190,30);
		
	}

}
