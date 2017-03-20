package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;

/**
 * This is the view that is responsible for assigning item to the character
 * 
 * @author Appan Chhibber
 *
 */
public class ItemAssignView extends View implements Observer {
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

	public JList backPackList;
	public DefaultListModel<String> backPackModel;

	public int backPackCounter;

	public Map<String, ArrayList<String>>[] items;

	public JButton backpackAssign;
	public JButton charBackButton;
	public JButton addItem;

	public JButton helmetButton;
	public JButton armorButton;
	public JButton beltButton;
	public JButton bootButton;
	public JButton ringButton;
	public JButton weaponButton;
	public JButton shieldButton;

	public FileOperationModel fileIO;

	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		fileIO = new FileOperationModel();
		itemPanel = new View();
		itemPanel.setBackground(Color.BLACK);
		itemPanel.setSize(300, 500);
		itemPanel.setLocation(20, 30);
		itemPanel.setVisible(true);

		backpackPanel = new View();
		backpackPanel.setBackground(Color.BLACK);
		backpackPanel.setSize(500, 500);
		backpackPanel.setLocation(340, 30);

		backPackModel = new DefaultListModel<String>();
		backPackList = new JList();
		backPackList.setSize(175, 200);
		backPackList.setLocation(10, 10);
		backpackPanel.add(backPackList);

		addItem = new JButton("Add Item");
		addItem.setSize(100, 40);
		addItem.setLocation(44, 220);
		backpackPanel.add(addItem);

		helmetButton = new JButton("Helmet");
		helmetButton.setLocation(300, 10);
		helmetButton.setSize(100, 100);
		backpackPanel.add(helmetButton);

		armorButton = new JButton("Armor");
		armorButton.setLocation(290, 120);
		armorButton.setSize(120, 100);
		backpackPanel.add(armorButton);

		shieldButton = new JButton("Shild");
		shieldButton.setLocation(290, 230);
		shieldButton.setSize(120, 100);
		backpackPanel.add(shieldButton);

		beltButton = new JButton("Belt");
		beltButton.setLocation(290, 340);
		beltButton.setSize(120, 60);
		backpackPanel.add(beltButton);

		bootButton = new JButton("Boot");
		bootButton.setLocation(305, 410);
		bootButton.setSize(90, 80);
		backpackPanel.add(bootButton);

		ringButton = new JButton("Ring");
		ringButton.setLocation(420, 135);
		ringButton.setSize(60, 60);
		backpackPanel.add(ringButton);

		weaponButton = new JButton("Weapon");
		weaponButton.setLocation(195, 125);
		weaponButton.setSize(90, 90);
		backpackPanel.add(weaponButton);

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
		items = new HashMap[7];
		items[0] = fileIO.readSaveItemFile(new File("itemSave/" + itemType.getSelectedItem().toString() + ".xml"));
		subItemType.setModel(new DefaultComboBoxModel(items[0].keySet().toArray()));
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		backPackModel.removeAllElements();
		for (String s : ((CharacterModel) o).getBackPackItems()) {
			backPackModel.addElement(s);
		}
		backPackList.setModel(backPackModel);
		if(((CharacterModel) o).message=="weaponFlag") {
			weaponButton.setIcon(new ImageIcon((((new ImageIcon("image/"
					+ items[6].get(((CharacterModel) o).getWeaponFlag()).toArray()[2].toString().replaceAll("\\s+", "")
					+ ".jpg")).getImage().getScaledInstance(weaponButton.getWidth(), weaponButton.getHeight(),
							java.awt.Image.SCALE_SMOOTH)))));
		}
		else if (((CharacterModel) o).message=="helmetFlag") {
			helmetButton.setIcon(new ImageIcon((((new ImageIcon("image/"
					+ items[0].get(((CharacterModel) o).getHelmetFlag()).toArray()[2].toString().replaceAll("\\s+", "")
					+ ".jpg")).getImage().getScaledInstance(helmetButton.getWidth(), helmetButton.getHeight(),
							java.awt.Image.SCALE_SMOOTH)))));
		}
		else if (((CharacterModel) o).message=="shieldFlag") {
			shieldButton.setIcon(new ImageIcon((((new ImageIcon("image/"
					+ items[2].get(((CharacterModel) o).getShieldFlag()).toArray()[2].toString().replaceAll("\\s+", "")
					+ ".jpg")).getImage().getScaledInstance(shieldButton.getWidth(), shieldButton.getHeight(),
							java.awt.Image.SCALE_SMOOTH)))));
		}
		else if (((CharacterModel) o).message=="beltFlag") {
			beltButton.setIcon(new ImageIcon((((new ImageIcon("image/"
					+ items[3].get(((CharacterModel) o).getBeltFlag()).toArray()[2].toString().replaceAll("\\s+", "")
					+ ".jpg")).getImage().getScaledInstance(beltButton.getWidth(), beltButton.getHeight(),
							java.awt.Image.SCALE_SMOOTH)))));
		}
		else if (((CharacterModel) o).message=="bootFlag") {
			bootButton.setIcon(new ImageIcon((((new ImageIcon("image/"
					+ items[4].get(((CharacterModel) o).getBootFlag()).toArray()[2].toString().replaceAll("\\s+", "")
					+ ".jpg")).getImage().getScaledInstance(bootButton.getWidth(), bootButton.getHeight(),
							java.awt.Image.SCALE_SMOOTH)))));
		}
		else if (((CharacterModel) o).message=="ringFlag") {
			ringButton.setIcon(new ImageIcon((((new ImageIcon("image/"
					+ items[5].get(((CharacterModel) o).getRingFlag()).toArray()[2].toString().replaceAll("\\s+", "")
					+ ".jpg")).getImage().getScaledInstance(ringButton.getWidth(), ringButton.getHeight(),
							java.awt.Image.SCALE_SMOOTH)))));
		}
		else if (((CharacterModel) o).message=="armorFlag") {
			armorButton.setIcon(new ImageIcon((((new ImageIcon("image/"
					+ items[1].get(((CharacterModel) o).getArmorFlag()).toArray()[2].toString().replaceAll("\\s+", "")
					+ ".jpg")).getImage().getScaledInstance(armorButton.getWidth(), armorButton.getHeight(),
							java.awt.Image.SCALE_SMOOTH)))));
		}
	}
}
