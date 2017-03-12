package com.SOEN6441_DND.Views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import com.SOEN6441_DND.Controller.TransferHandlerController;

/**
 * 
 * @author Punit Trivedi
 * @author Appan Chhibber
 *
 */
public class InventoryPanelView extends View {

	public JLabel wallLabel;
	public JLabel entryDoorLabel;
	public JLabel chestLabel;
	public JLabel exitDoorLabel;
	public JLabel charImageLabel;
	public JLabel treaImageLabel;
	//-For Dropdown Label//
	public JLabel characterLabel;
	public JLabel treasureLabel;
	//------------//
	public ImageIcon chestImage;
	public ImageIcon wallImage;
	public ImageIcon entryDoorImage;
	public ImageIcon exitDoorImage;
	public ImageIcon treasureImage;
	public ImageIcon characterImage;
public JButton validateButton;
public JButton removeButton;

public JCheckBox addCharacter;
public JCheckBox addTreasure;
	public TransferHandlerController transferHandler;

	public JComboBox characterDropDown;
	public JComboBox treasureDropDown;
	

	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();

		this.setSize(200, 535);
		this.setLocation(645, 10);
		this.setBackground(Color.BLACK);
		wallImage = new ImageIcon("image/Wall.jpg");
		wallLabel = new JLabel(new ImageIcon(
				((wallImage.getImage().getScaledInstance(50, 50,
						java.awt.Image.SCALE_SMOOTH)))));
		wallLabel.setLocation(10, 10);
		wallLabel.setSize(50, 50);
		wallLabel.setTransferHandler(new TransferHandlerController()
				.valueExportCreator("image/Wall.jpg"));

		entryDoorImage = new ImageIcon("image/EntryDoor.jpg");
		entryDoorLabel = new JLabel(new ImageIcon(
				((entryDoorImage.getImage().getScaledInstance(50, 50,
						java.awt.Image.SCALE_SMOOTH)))));
		entryDoorLabel.setLocation(70, 10);
		entryDoorLabel.setSize(50, 50);
		entryDoorLabel.setTransferHandler(new TransferHandlerController()
		.valueExportCreator("image/EntryDoor.jpg"));
		
		chestImage=new ImageIcon("image/Chest.jpg");
		chestLabel=new JLabel(new ImageIcon(
				((chestImage.getImage().getScaledInstance(50, 50,
						java.awt.Image.SCALE_SMOOTH)))));
		chestLabel.setLocation(130, 10);
		chestLabel.setSize(50, 50);
		chestLabel.setTransferHandler(new TransferHandlerController()
		.valueExportCreator("image/Chest.jpg"));
		
		exitDoorImage = new ImageIcon("image/ExitDoor.jpg");
		exitDoorLabel = new JLabel(new ImageIcon(
				((exitDoorImage.getImage().getScaledInstance(50, 50,
						java.awt.Image.SCALE_SMOOTH)))));
		exitDoorLabel.setLocation(10, 70);
		exitDoorLabel.setSize(50, 50);
		exitDoorLabel.setTransferHandler(new TransferHandlerController()
		.valueExportCreator("image/ExitDoor.jpg"));
		
		treaImageLabel=new JLabel();
		treaImageLabel.setSize(50,50);
		treaImageLabel.setLocation(130, 70);
		
		charImageLabel=new JLabel();
		charImageLabel.setSize(50,50);
		charImageLabel.setLocation(70, 70);
		
		addCharacter=new JCheckBox("Add Character");
		addCharacter.setSize(120,30);
		addCharacter.setLocation(25,130);
		addCharacter.setForeground(Color.WHITE);
		addCharacter.setOpaque(false);
		addTreasure=new JCheckBox("Add Treasure");
		addTreasure.setSize(120, 30);
		addTreasure.setLocation(25,160);
		addTreasure.setForeground(Color.WHITE);
		addTreasure.setOpaque(false);
		
		characterLabel=new JLabel("Select Character:");
		characterLabel.setForeground(Color.WHITE);
		characterLabel.setSize(120, 20);
		characterLabel.setLocation(10,190);
		characterLabel.setVisible(false);
		characterDropDown=new JComboBox();
		characterDropDown.setSize(120,30);
		characterDropDown.setLocation(10, 210);
		characterDropDown.setVisible(false);
		
		treasureLabel=new JLabel("Select Treasure:");
		treasureLabel.setForeground(Color.WHITE);
		treasureLabel.setSize(120, 20);
		treasureLabel.setLocation(10, 250);
		treasureLabel.setVisible(false);
		treasureDropDown=new JComboBox();
		treasureDropDown.setSize(120, 30);
		treasureDropDown.setLocation(10, 270);
		treasureDropDown.setVisible(false);
		//Validate Button 
		validateButton=new JButton("Validate");
		validateButton.setSize(100,30);
		validateButton.setLocation(50,495);
		//------------//

		this.add(chestLabel);
		this.add(entryDoorLabel);
		this.add(wallLabel);
		this.add(exitDoorLabel);
		this.add(validateButton);
		this.add(addCharacter);
		this.add(addTreasure);
		this.add(characterDropDown);
		this.add(treasureDropDown);
		this.add(characterLabel);
		this.add(treasureLabel);
		this.add(charImageLabel);
		this.add(treaImageLabel);
		this.setVisible(true);
	}

}
