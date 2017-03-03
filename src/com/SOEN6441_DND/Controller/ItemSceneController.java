package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JRadioButton;

import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Views.ItemScene;
/**
 * This Class is a view for Item Creation and Manipulation. This class is
 * observe by Item Model.	
 * 
 * @author Paras Malik
 * 
 *
 */
public class ItemSceneController implements ActionListener {

	public ItemScene itemScreen;
	public ItemModel itemModel;
	public FileOperationModel fileModel;

	/**
	 * This constructor is passed with the current item view to be used
	 * for event handling.
	 * 
	 * @param view
	 */
	public ItemSceneController(ItemScene view) {
		itemScreen = view;
		itemModel = view.itemViewModel;
		fileModel = view.fileModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == itemScreen.itemType) {
			switch (itemScreen.itemType.getSelectedItem().toString()) {
			case "Helmet": {
				fileModel.readFile(fileModel.setFile("Helmet"));
				itemModel.setSubItemList(fileModel.getItemsName());
				break;
			}
			case "Armor": {
				fileModel.readFile(fileModel.setFile("Armor"));

				itemModel.setSubItemList(fileModel.getItemsName());
				break;
			}
			case "Shield": {
				fileModel.readFile(fileModel.setFile("Shield"));
				itemModel.setSubItemList(fileModel.getItemsName());
				break;
			}
			case "Ring": {
				fileModel.readFile(fileModel.setFile("Ring"));
				itemModel.setSubItemList(fileModel.getItemsName());
				break;
			}
			case "Belt": {
				fileModel.readFile(fileModel.setFile("Belt"));
				itemModel.setSubItemList(fileModel.getItemsName());
				break;
			}
			case "Boots": {
				fileModel.readFile(fileModel.setFile("Boots"));
				itemModel.setSubItemList(fileModel.getItemsName());
				break;
			}
			case "Weapon": {
				fileModel.readFile(fileModel.setFile("Weapon"));
				itemModel.setSubItemList(fileModel.getItemsName());
				break;
			}
			}

		} else if (e.getSource() == itemScreen.subItemType) {
			if (itemScreen.subItemType.getSelectedIndex() != -1) {
				itemModel.setImage(fileModel.getItemsImage().get(
						itemScreen.subItemType.getSelectedIndex()));
			
				itemModel.setItemDecsription(fileModel.getItemDesription().get(itemScreen.subItemType.getSelectedIndex()));
			} else {
				
				itemModel.setImage(fileModel.getItemsImage().get(0));
				itemModel.setItemDecsription(fileModel.getItemDesription().get(0));
			}

		}
	
		else if(e.getSource() == itemScreen.navMenuPanel.saveButton){
			
			fileModel.writeItemData(itemScreen);
		}
	}
}
