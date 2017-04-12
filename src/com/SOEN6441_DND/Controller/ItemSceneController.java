package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Views.ItemScene;
import com.SOEN6441_DND.Views.MapView;

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
	private GameController gameController;
	File file;

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
		gameController = GameController.getInstance();
	}

	@Override
	/**
	 * This method handles all the possible events occurring on item view page
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object enchatCheck = e.getSource();
		if (e.getSource() == itemScreen.itemType) {
			switch (itemScreen.itemType.getSelectedItem().toString()) {
			case "Helmet": {
				fileModel.readFile(fileModel.setFile("Helmet"));
				itemModel.setSubItemList(fileModel.getItemsName());
				itemModel.setItemType(itemScreen.itemType.getSelectedItem().toString());
				break;
			}
			case "Armor": {
				fileModel.readFile(fileModel.setFile("Armor"));

				itemModel.setSubItemList(fileModel.getItemsName());
				itemModel.setItemType(itemScreen.itemType.getSelectedItem().toString());
				break;
			}
			case "Shield": {
				fileModel.readFile(fileModel.setFile("Shield"));
				itemModel.setSubItemList(fileModel.getItemsName());
				itemModel.setItemType(itemScreen.itemType.getSelectedItem().toString());
				break;
			}
			case "Ring": {
				fileModel.readFile(fileModel.setFile("Ring"));
				itemModel.setSubItemList(fileModel.getItemsName());
				itemModel.setItemType(itemScreen.itemType.getSelectedItem().toString());
				break;
			}
			case "Belt": {
				fileModel.readFile(fileModel.setFile("Belt"));
				itemModel.setSubItemList(fileModel.getItemsName());
				itemModel.setItemType(itemScreen.itemType.getSelectedItem().toString());
				break;
			}
			case "Boots": {
				fileModel.readFile(fileModel.setFile("Boots"));
				itemModel.setSubItemList(fileModel.getItemsName());
				itemModel.setItemType(itemScreen.itemType.getSelectedItem().toString());
				break;
			}
			case "Weapon": {
				fileModel.readFile(fileModel.setFile("Weapon"));
				itemModel.setSubItemList(fileModel.getItemsName());
				itemModel.setItemType(itemScreen.itemType.getSelectedItem().toString());
				break;
			}
			}

		} else if (e.getSource() == itemScreen.subItemType) {
			if(itemScreen.mode.equalsIgnoreCase("create")){
			if (itemScreen.subItemType.getSelectedIndex() != -1) {
				itemModel.setImage(fileModel.getItemsImage().get(itemScreen.subItemType.getSelectedIndex()));

				itemModel.setItemDecsription(
						fileModel.getItemDesription().get(itemScreen.subItemType.getSelectedIndex()));
				if(itemScreen.itemType.getSelectedItem().toString().equalsIgnoreCase("weapon")){
				itemModel.setWeaponType(fileModel.getWeaponType().get(itemScreen.subItemType.getSelectedIndex()));
				itemModel.setWeaponRange(Integer.parseInt(fileModel.getWeaponRange().get(itemScreen.subItemType.getSelectedIndex())));
				}
			} else {

				itemModel.setImage(fileModel.getItemsImage().get(0));
				itemModel.setItemDecsription(fileModel.getItemDesription().get(0));
				if(itemScreen.itemType.getSelectedItem().toString().equalsIgnoreCase("weapon")){
				itemModel.setWeaponType(fileModel.getWeaponType().get(0));
				itemModel.setWeaponRange(Integer.parseInt(fileModel.getWeaponRange().get(0)));
				}
			}

			}
			else{
				if (itemScreen.subItemType.getSelectedIndex() != -1) {
//					itemModel.setImage(fileModel.getItemsImage().get(itemScreen.subItemType.getSelectedIndex()));
//
//					itemModel.setItemDecsription(
//							fileModel.getItemDesription().get(itemScreen.subItemType.getSelectedIndex()));
					itemModel.setImage("image/"+itemScreen.subItemType.getSelectedItem().toString().replaceAll("\\s", "")+".jpg");
					if(itemScreen.itemType.getSelectedItem().toString().equalsIgnoreCase("weapon")){
					itemModel.setWeaponType(itemModel.getWeaponTypeList().getElementAt(itemScreen.subItemType.getSelectedIndex()).toString());
					itemModel.setWeaponRange(Integer.parseInt(itemModel.getWeaponRangeList().getElementAt(itemScreen.subItemType.getSelectedIndex()).toString()));
					}
				} else {

					itemModel.setImage("image/"+itemScreen.subItemType.getSelectedItem().toString().replaceAll("\\s", "")+".jpg");
					itemModel.setItemDecsription(fileModel.getItemDesription().get(0));
					if(itemScreen.itemType.getSelectedItem().toString().equalsIgnoreCase("weapon")){
					itemModel.setWeaponType(fileModel.getWeaponType().get(0));
					itemModel.setWeaponRange(Integer.parseInt(fileModel.getWeaponRange().get(0)));
					}
				}
				
			}
			}
		
		else if (e.getSource() == itemScreen.navMenuPanel.saveButton) {
			if (itemScreen.nameField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter Item name.");
			} else {
				try {
					
					itemModel.setItemType(itemScreen.itemType.getSelectedItem().toString());
					itemModel.setSubItemType(itemScreen.subItemType.getSelectedItem().toString());
					itemModel.setName(itemScreen.nameField.getText());
					if(itemScreen.itemType.getSelectedItem().toString().equalsIgnoreCase("weapon")){
						itemModel.setWeaponType(itemScreen.weaponType.getText());
						itemModel.setWeaponRange(Integer.parseInt(itemScreen.weaponRange.getText()));
						
						itemModel.setBurning(itemScreen.burning.isSelected());
						itemModel.setFreezing(itemScreen.freezing.isSelected());
						itemModel.setPacifying(itemScreen.pacifying.isSelected());
						itemModel.setFrightening(itemScreen.frightening.isSelected());
						itemModel.setSlaying(itemScreen.slaying.isSelected());
					}
					
					itemModel.setEnchantValue(Integer.parseInt(itemScreen.enchantList.getSelectedItem().toString()));
					if(itemScreen.addChest.isSelected()==true){
						fileModel.writeChestFile(itemModel);
						}
			JOptionPane.showMessageDialog(null, fileModel.writeItemData(itemModel));

					
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		else if(e.getSource() == itemScreen.navMenuPanel.loadButton){
			
			File file = openItemFile();
			itemModel=fileModel.readItemSaveFile(file);
			gameController.mainFrame.setView(new ItemScene(itemModel,"edit") );
			
		}
	
	}

	/**
	 * This function returns the list of item names from the item file.
	 * @param file
	 * @return
	 */
	public Map<String,ArrayList<String>> itemNameList(File file){
		return fileModel.readSaveItemFile(new File("itemSave/"+file.getName()));
	}
	
	/**
	 * This function opens and returns the item file already saved in itemSave folder.
	 * @return file
	 */
	public File openItemFile(){
		JFileChooser fileChooser = new JFileChooser(new File("itemSave/"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML",
				"xml");
		fileChooser.setFileFilter(filter);
		int option = fileChooser.showOpenDialog(gameController.mainFrame);

		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			this.file = file;
			return file;
		} else {
			return null;
		}

	}
}
