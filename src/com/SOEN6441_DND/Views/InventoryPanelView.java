package com.SOEN6441_DND.Views;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.SOEN6441_DND.Controller.TransferHandlerController;

public class InventoryPanelView extends View {

	public JLabel wallLabel;
	public JLabel entryDoorLabel;
	public JLabel chestLabel;
	public JLabel exitDoorLabel;
	
	public ImageIcon chestImage;
	public ImageIcon wallImage;
	public ImageIcon entryDoorImage;
	public ImageIcon exitDoorImage;
	
public JButton validateButton;
public JButton removeButton;
	public TransferHandlerController transferHandler;

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
		
		
		
		//Validate Button 
		validateButton=new JButton("Validate");
		validateButton.setSize(100,30);
		validateButton.setLocation(50,495);
		//------------//
		//Remove Button//
		removeButton=new JButton("Remove");
		removeButton.setSize(100,30);
		removeButton.setLocation(50, 445);
		removeButton.setVisible(false);
		//-------------//
		this.add(chestLabel);
		this.add(entryDoorLabel);
		this.add(wallLabel);
		this.add(exitDoorLabel);
		this.add(validateButton);
		this.add(removeButton);
		this.setVisible(true);
	}

}
