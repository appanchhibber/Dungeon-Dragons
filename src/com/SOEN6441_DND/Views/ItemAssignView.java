package com.SOEN6441_DND.Views;

import java.awt.Color;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;

/**
 * This is the view that is responsible for assigning item to the character
 * 
 * @author Appan Chhibber
 *
 */
public class ItemAssignView extends View {
	public View itemPanel;
	public View backpackPanel;
	public JPanel navPanel;

	public JLabel itemTypeLabel;
	public JLabel itemSubTypeLabel;

	public JLabel hitPointsLabel;
	public JLabel armorLabel;
	public JLabel attackBonusLabel;
	public JLabel damageBonusLabel;
	public JLabel levelsLabel;

	public JLabel hitValueLabel;
	public JLabel armorValueLabel;
	public JLabel attackValueLabel;
	public JLabel damageValueLabel;
	public JLabel levelsValueLabel;

	public JComboBox itemType;
	public JComboBox subItemType;

	public JList backpackList;
	public JList assignItemList;

	public JButton backpackAssign;
	public JButton charBackButton;
	public JButton addItem;
	public JButton removeItem;
	
	public FileOperationModel fileIO;

	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		fileIO=new FileOperationModel();
		itemPanel = new View();
		itemPanel.setBackground(Color.BLACK);
		itemPanel.setSize(300, 500);
		itemPanel.setLocation(20, 30);
		itemPanel.setVisible(true);

		backpackPanel = new View();
		backpackPanel.setBackground(Color.BLACK);
		backpackPanel.setSize(500, 500);
		backpackPanel.setLocation(340, 30);
		backpackList = new JList();
		backpackList.setSize(200, 480);
		backpackList.setLocation(10, 10);
		backpackPanel.add(backpackList);

		addItem = new JButton(">");
		addItem.setSize(50, 30);
		addItem.setLocation(220, 100);
		backpackPanel.add(addItem);

		removeItem = new JButton("<");
		removeItem.setSize(50, 30);
		removeItem.setLocation(220, 200);
		backpackPanel.add(removeItem);

		assignItemList = new JList();
		assignItemList.setSize(200, 480);
		assignItemList.setLocation(290, 10);
		backpackPanel.add(assignItemList);
		backpackPanel.setVisible(true);

		navPanel = new JPanel();
		navPanel.setBackground(Color.BLACK);
		navPanel.setSize(860, 75);
		navPanel.setLocation(0, 550);
		navPanel.setVisible(true);

		charBackButton = new JButton("Back");
		charBackButton.setSize(240, 30);
		charBackButton.setLocation(190, 45);
		navPanel.add(charBackButton);

		itemTypeLabel = new JLabel("Select Type:");
		itemTypeLabel.setSize(100, 20);
		itemTypeLabel.setLocation(20, 20);
		itemTypeLabel.setForeground(Color.WHITE);
		itemPanel.add(itemTypeLabel);
		itemType = new JComboBox(ItemModel.itemTypeList.values());
		itemType.setSize(140, 40);
		itemType.setLocation(150, 10);
		itemPanel.add(itemType);

		itemSubTypeLabel = new JLabel("Select Item:");
		itemSubTypeLabel.setSize(80, 20);
		itemSubTypeLabel.setLocation(20, 90);
		itemSubTypeLabel.setForeground(Color.WHITE);
		itemPanel.add(itemSubTypeLabel);
		subItemType = new JComboBox();
		subItemType.setModel(new DefaultComboBoxModel(fileIO.getAllFolderFile("itemSave").toArray()));
		subItemType.setSize(140, 40);
		subItemType.setLocation(150, 80);
		itemPanel.add(subItemType);
		
		levelsLabel = new JLabel("Level :");
		levelsLabel.setSize(100, 20);
		levelsLabel.setLocation(20, 270);
		levelsLabel.setForeground(Color.WHITE);
		itemPanel.add(levelsLabel);

		levelsValueLabel = new JLabel("Value");
		levelsValueLabel.setSize(100, 20);
		levelsValueLabel.setLocation(130, 270);
		levelsValueLabel.setForeground(Color.WHITE);
		itemPanel.add(levelsValueLabel);
		
		hitPointsLabel = new JLabel("Hit Points :");
		hitPointsLabel.setSize(100, 20);
		hitPointsLabel.setLocation(20, 300);
		hitPointsLabel.setForeground(Color.WHITE);
		itemPanel.add(hitPointsLabel);

		hitValueLabel = new JLabel("Value");
		hitValueLabel.setSize(100, 20);
		hitValueLabel.setLocation(130, 300);
		hitValueLabel.setForeground(Color.WHITE);
		itemPanel.add(hitValueLabel);
		
		armorLabel = new JLabel("Armor :");
		armorLabel.setSize(100, 20);
		armorLabel.setLocation(20, 330);
		armorLabel.setForeground(Color.WHITE);
		itemPanel.add(armorLabel);

		armorValueLabel = new JLabel("Value");
		armorValueLabel.setSize(100, 20);
		armorValueLabel.setLocation(130, 330);
		armorValueLabel.setForeground(Color.WHITE);
		itemPanel.add(armorValueLabel);
		
		attackBonusLabel = new JLabel("Attack Bonus :");
		attackBonusLabel.setSize(100, 20);
		attackBonusLabel.setLocation(20, 360);
		attackBonusLabel.setForeground(Color.WHITE);
		itemPanel.add(attackBonusLabel);

		attackValueLabel = new JLabel("Value");
		attackValueLabel.setSize(100, 20);
		attackValueLabel.setLocation(130, 360);
		attackValueLabel.setForeground(Color.WHITE);
		itemPanel.add(attackValueLabel);
		
		damageBonusLabel = new JLabel("Damage Bonus :");
		damageBonusLabel.setSize(110, 20);
		damageBonusLabel.setLocation(20, 390);
		damageBonusLabel.setForeground(Color.WHITE);
		itemPanel.add(damageBonusLabel);

		damageValueLabel = new JLabel("Value");
		damageValueLabel.setSize(100, 20);
		damageValueLabel.setLocation(130, 390);
		damageValueLabel.setForeground(Color.WHITE);
		itemPanel.add(damageValueLabel);
		

		backpackAssign = new JButton("Add To Backpack");
		backpackAssign.setSize(160, 30);
		backpackAssign.setLocation(75, 180);
		itemPanel.add(backpackAssign);

		this.setSize(860, 645);
		this.add(itemPanel);
		this.add(backpackPanel);
		this.add(navPanel);
		this.setVisible(true);

	}

}
