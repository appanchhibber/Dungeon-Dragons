package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JRadioButton;

import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Views.ItemScene;

public class ItemSceneController implements ActionListener {

	public ItemScene itemScreen;
	public ItemModel itemModel;
	public FileOperationModel fileModel;

	public ItemSceneController(ItemScene view) {
		itemScreen = view;
		itemModel = view.itemViewModel;
		fileModel = new FileOperationModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == itemScreen.itemType) {
			switch (itemScreen.itemType.getSelectedItem().toString()) {
			case "Helmet": {	
				fileModel.readFile(fileModel.setFile("Helmet"));
				break;
			}
			case "Armor": {

				break;
			}
			case "Shield": {

				break;
			}
			case "Ring": {

				break;
			}
			case "Belt": {

				break;
			}
			case "Boots": {

				break;
			}
			case "Weapon": {

				break;
			}
			}
		}
	}

}
