package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import sun.text.normalizer.UBiDiProps;

import com.SOEN6441_DND.Controller.ItemSceneController;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Model.ItemModel.itemTypeList;

/**
 * This Class is a view for Item Creation and Manipulation. This class is
 * observe by Item Model.
 * 
 * @author Paras Malik
 * @author Amirbabak Rahgozar
 *
 */
public class ItemScene extends View implements Observer {

	// Panels
	View imagePanel;
	NavigationPanelView navMenuPanel;
	public View itemViewPanel;

	// Models
	public ItemModel itemViewModel;
	public FileOperationModel fileModel;
	// ComboBox
	public JComboBox<itemTypeList> itemType;
	public JComboBox subItemType;

	// Label
	public JLabel itemTypeLabel;
	public JLabel itemLabel;
	public JLabel imageLabel;
	// Controllers
	public ItemSceneController itemController;

	// ImageIcon
	ImageIcon itemImage;

	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		itemViewModel = new ItemModel();
		fileModel = new FileOperationModel();
		itemController = new ItemSceneController(this);

		itemViewPanel = new View();
		itemViewPanel.setBackground(Color.BLACK);
		itemViewPanel.setSize(300, 500);
		itemViewPanel.setLocation(335, 70);
		itemViewPanel.setVisible(true);

		itemTypeLabel = new JLabel("Select Item Type:");
		itemTypeLabel.setSize(100, 20);
		itemTypeLabel.setLocation(30, 20);
		itemTypeLabel.setForeground(Color.WHITE);

		itemType = new JComboBox<itemTypeList>(itemTypeList.values());
		itemType.addActionListener(itemController);
		itemType.setSize(140, 40);
		itemType.setLocation(150, 10);

		if (itemViewModel.getSubItemList() == null) {
			fileModel.readFile(fileModel.setFile("Helmet"));
			itemViewModel.setSubItemList(fileModel.getItemsName());
		}
		itemLabel = new JLabel("Select Item:");
		itemLabel.setSize(80, 20);
		itemLabel.setLocation(30, 70);
		itemLabel.setForeground(Color.WHITE);

		subItemType = new JComboBox(itemViewModel.subItemList.toArray());
		subItemType.setSize(140, 40);
		subItemType.setLocation(150, 60);
		subItemType.addActionListener(itemController);
		itemViewPanel.add(itemTypeLabel);
		itemViewPanel.add(itemType);
		itemViewPanel.add(itemLabel);
		itemViewPanel.add(subItemType);

		if (itemViewModel.getImage() == null) {
			itemViewModel.setImage("image/LightHelm.jpg");
		}
		imagePanel = new View();
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setSize(300, 475);
		imagePanel.setLocation(20, 70);
		itemImage = new ImageIcon(itemViewModel.getImage());
		imageLabel = new JLabel(new ImageIcon(
				((itemImage.getImage().getScaledInstance(imagePanel.getWidth(),
						imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
		imageLabel.setSize(imagePanel.getWidth(), imagePanel.getHeight());
		imageLabel.setLocation(0, 0);

		imagePanel.add(imageLabel);
		navMenuPanel = new NavigationPanelView();
		this.add(navMenuPanel);
		this.add(itemViewPanel);
		this.add(imagePanel);
		itemViewModel.addObserver(this);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.itemViewModel = (ItemModel) o;
		if (itemViewModel.message == "SubItemTypeListChanged") {
	
			subItemType.removeAllItems();
			
			String[] list = (String[]) itemViewModel.getSubItemList().toArray(new String[itemViewModel.getSubItemList().size()]);
			for(String str : list){
				subItemType.addItem(str);
			}
			
		
			itemViewPanel.revalidate();
			itemViewPanel.repaint();
		} else if (itemViewModel.message == "ImageChanged") {
			System.out.println("ImageChanged");
			itemImage.getImage().flush();
			itemImage = new ImageIcon(
					new ImageIcon(itemViewModel.getImage()).getImage()
							.getScaledInstance(imagePanel.getWidth(),
									imagePanel.getHeight(),
									java.awt.Image.SCALE_SMOOTH));
			imageLabel.setIcon(itemImage);
			imageLabel.revalidate();
			imageLabel.repaint();
		}

	}
}
