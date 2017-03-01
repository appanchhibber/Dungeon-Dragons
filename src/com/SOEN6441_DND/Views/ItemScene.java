package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	public View imagePanel;
	public NavigationPanelView navMenuPanel;
	public View itemViewPanel;
	public View itemInfoPanel;

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
	public JLabel nameLabel;
	public JLabel enchantLabel;
	public JLabel itemInfoLabel;
	public JTextArea itemDescription;
	
	// TextField
	public JTextField nameField;
	public JTextField enchantField;
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
		itemViewPanel.setLocation(320, 70);
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
		itemLabel.setLocation(30, 90);
		itemLabel.setForeground(Color.WHITE);

		subItemType = new JComboBox(itemViewModel.subItemList.toArray());
		subItemType.setSize(140, 40);
		subItemType.setLocation(150, 80);
		subItemType.addActionListener(itemController);
		
		nameLabel = new JLabel("Set Name :");
		nameLabel.setSize(100, 30);
		nameLabel.setLocation(30, 170);
		nameLabel.setForeground(Color.WHITE);
		
		nameField = new JTextField();
		nameField.setSize(140, 30);
		nameField.setLocation(150, 170);
		
		
		
		enchantLabel = new JLabel("Enter Enchantment Value (+1 - +5) :");
		enchantLabel.setSize(210, 20);
		enchantLabel.setLocation(30, 250);
		enchantLabel.setForeground(Color.WHITE);
		
		enchantField = new JTextField();
		enchantField.setSize(40, 25);
		enchantField.setLocation(250, 250);
		
		
		
		itemViewPanel.add(itemTypeLabel);
		itemViewPanel.add(itemType);
		itemViewPanel.add(itemLabel);
		itemViewPanel.add(subItemType);
		itemViewPanel.add(nameLabel);
		itemViewPanel.add(enchantLabel);
		itemViewPanel.add(nameField);
		itemViewPanel.add(enchantField);
		
		

		if (itemViewModel.getImage() == null) {
			itemViewModel.setImage("image/LightHelm.jpg");
		}
		imagePanel = new View();
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setSize(300, 475);
		imagePanel.setLocation(10, 70);
		itemImage = new ImageIcon(itemViewModel.getImage());
		imageLabel = new JLabel(new ImageIcon(
				((itemImage.getImage().getScaledInstance(imagePanel.getWidth(),
						imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
		imageLabel.setSize(imagePanel.getWidth(), imagePanel.getHeight());
		imageLabel.setLocation(0, 0);

		imagePanel.add(imageLabel);
		
		itemInfoPanel = new View();
		itemInfoPanel.setBackground(Color.BLACK);
		itemInfoPanel.setSize(220, 500);
		itemInfoPanel.setLocation(625, 70);
		
		itemInfoPanel.setVisible(true);
		
		itemInfoLabel = new JLabel("<html><b><u>ITEM DESCRIPTION : </u></b></html>");
		itemInfoLabel.setSize(210, 30);
		itemInfoLabel.setLocation(30, 10);
		itemInfoLabel.setForeground(Color.CYAN);
		itemInfoLabel.setBackground(Color.BLACK);
		itemInfoLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		itemDescription = new JTextArea(fileModel.getItemDesription().get(0));
		itemDescription.setSize(220,500);
		itemDescription.setLocation(10, 70);
		itemDescription.setForeground(Color.WHITE);
		itemDescription.setBackground(Color.BLACK);
		itemDescription.setFont(new Font("Calibri", Font.PLAIN, 16));
		itemDescription.setLineWrap(true);
		itemDescription.setWrapStyleWord(true);
		

		itemInfoPanel.add(itemDescription);
		
		itemInfoPanel.add(itemInfoLabel);
		//itemInfoPanel.add(itemDescription);
		
		
		navMenuPanel = new NavigationPanelView();
		this.add(navMenuPanel);
		this.add(itemViewPanel);
		this.add(imagePanel);
		this.add(itemInfoPanel);
		itemViewModel.addObserver(this);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.itemViewModel = (ItemModel) o;
		if (itemViewModel.message == "SubItemTypeListChanged") {
	
			subItemType.removeAllItems();
			
			String[] list = (String[]) itemViewModel.getSubItemList().toArray(new String[itemViewModel.getSubItemList().size()]);
			subItemType.setModel(new DefaultComboBoxModel(list));
			itemViewPanel.revalidate();
			itemViewPanel.repaint();
		} else if (itemViewModel.message == "ImageChanged") {
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
		else if(itemViewModel.message=="DescriptionChanged")
		{
			itemDescription.setText(itemViewModel.getItemDecsription());
		}
	}
}
