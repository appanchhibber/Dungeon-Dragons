package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;




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
	public JComboBox enchantList;
    public JComboBox chestList;
	// Label
	public JLabel itemTypeLabel;
	public JLabel itemLabel;
	public JLabel imageLabel;
	public JLabel nameLabel;
	public JLabel enchantLabel;
	public JLabel itemInfoLabel;
	public JLabel chestSelectLabel;
	public JCheckBox addChest;
	public JTextArea itemDescription;

	public JComboBox savedItemNames;
	// TextField
	public JTextField nameField;

	// Controllers
	public ItemSceneController itemController;

	// ImageIcon
	ImageIcon itemImage;
	

	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();

		itemViewPanel = new View();
		itemViewPanel.setBackground(Color.BLACK);
		itemViewPanel.setSize(300, 500);
		itemViewPanel.setLocation(320, 70);
		itemViewPanel.setVisible(true);

		itemTypeLabel = new JLabel("Select Item Type:");
		itemTypeLabel.setSize(100, 20);
		itemTypeLabel.setLocation(30, 20);
		itemTypeLabel.setForeground(Color.WHITE);

		itemType = new JComboBox();
		itemType.setSize(140, 40);
		itemType.setLocation(150, 10);

	
		itemLabel = new JLabel("Select Item:");
		itemLabel.setSize(80, 20);
		itemLabel.setLocation(30, 90);
		itemLabel.setForeground(Color.WHITE);

		subItemType = new JComboBox();
		subItemType.setSize(140, 40);
		subItemType.setLocation(150, 80);

		
		nameLabel = new JLabel("Set Name :");
		nameLabel.setSize(100, 30);
		nameLabel.setLocation(30, 170);
		nameLabel.setForeground(Color.WHITE);
		
		nameField = new JTextField();
		nameField.setSize(140, 30);
		nameField.setLocation(150, 170);
		
		savedItemNames=new JComboBox<>();
		savedItemNames.setSize(140, 30);
		savedItemNames.setLocation(150, 170);
		savedItemNames.setVisible(false);
		enchantLabel = new JLabel("Enchantment Value:");
		enchantLabel.setSize(210, 20);
		enchantLabel.setLocation(30, 250);
		enchantLabel.setForeground(Color.WHITE);
		
		enchantList = new JComboBox();
		enchantList.setSize(60, 20);
		enchantList.setLocation(180, 250);
		
		addChest=new JCheckBox("Add To Tressure");
		addChest.setSize(210, 30);
		addChest.setOpaque(false);
		addChest.setForeground(Color.WHITE);
		addChest.setLocation(30, 275);
		
		
		itemViewPanel.add(itemTypeLabel);
		itemViewPanel.add(itemType);
		itemViewPanel.add(itemLabel);
		itemViewPanel.add(subItemType);
		itemViewPanel.add(nameLabel);
		itemViewPanel.add(enchantLabel);
		itemViewPanel.add(nameField);
		itemViewPanel.add(enchantList);
		itemViewPanel.add(addChest);
		itemViewPanel.add(savedItemNames);

		
		imagePanel = new View();
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setSize(300, 475);
		imagePanel.setLocation(10, 70);
		imageLabel = new JLabel();
		imageLabel.setLocation(0, 0);

		imagePanel.add(imageLabel);
		
		itemInfoPanel = new View();
		itemInfoPanel.setBackground(Color.BLACK);
		itemInfoPanel.setSize(220, 500);
		itemInfoPanel.setLocation(625, 70);
		
		itemInfoPanel.setVisible(true);
		
		itemInfoLabel = new JLabel("ITEM DESCRIPTION :");
		itemInfoLabel.setSize(210, 30);
		itemInfoLabel.setLocation(10, 10);
		itemInfoLabel.setForeground(Color.CYAN);
		itemInfoLabel.setBackground(Color.BLACK);
		itemInfoLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		itemDescription = new JTextArea();
		
		itemDescription.setSize(210,500);
		itemDescription.setLocation(10, 70);
		itemDescription.setForeground(Color.WHITE);
		itemDescription.setBackground(Color.BLACK);
		itemDescription.setFont(new Font("Calibri", Font.PLAIN, 16));
		itemDescription.setLineWrap(true);
		itemDescription.setWrapStyleWord(true);
		

		itemInfoPanel.add(itemDescription);
		
		itemInfoPanel.add(itemInfoLabel);
		
		navMenuPanel = new NavigationPanelView();
		
		this.add(navMenuPanel);
		this.add(itemViewPanel);
		this.add(imagePanel);
		this.add(itemInfoPanel);
		

	}

	 public ItemScene(ItemModel model,String mode) {
			itemViewModel = model;
			fileModel = new FileOperationModel();
			itemController = new ItemSceneController(this);

				itemType.setModel(new DefaultComboBoxModel<>( itemTypeList.values()));
				if (itemViewModel.getSubItemList() == null) {
					fileModel.readFile(fileModel.setFile("Helmet"));
					itemViewModel.setSubItemList(fileModel.getItemsName());
				}
				subItemType.setModel(new DefaultComboBoxModel(itemViewModel.subItemList.toArray()));
				
				enchantList.setModel(new DefaultComboBoxModel(itemViewModel.getEnchanListValues()));
				if (itemViewModel.getImage() == null) {
					itemViewModel.setImage("image/LightHelm.jpg");
				}
				itemImage = new ImageIcon(itemViewModel.getImage());
				imageLabel.setIcon(new ImageIcon(
					((itemImage.getImage().getScaledInstance(imagePanel.getWidth(),
							imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
			imageLabel.setSize(imagePanel.getWidth(), imagePanel.getHeight());
			itemDescription.setText(fileModel.getItemDesription().get(0));
			
			if(mode.equalsIgnoreCase("edit")){
				
				itemType.setSelectedItem(itemViewModel.getItemType());
				subItemType.setModel(itemViewModel.getSavedItemTypeList());
				nameField.setVisible(false);
				savedItemNames.setModel(itemViewModel.getSavedItemNameList());
				savedItemNames.setVisible(true);
				HashMap<String,String> enchantLists=itemViewModel.getSavedEnchantValueList();
				enchantList.setSelectedItem(enchantLists.get(savedItemNames.getSelectedItem().toString()));
				imageLabel.setIcon(new ImageIcon(
					((new ImageIcon("image/"+subItemType.getSelectedItem().toString().trim()+".jpg").getImage().getScaledInstance(imagePanel.getWidth(),
							imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
			imageLabel.setSize(imagePanel.getWidth(), imagePanel.getHeight());
			}
			
			
			
		navMenuPanel.saveButton.addActionListener(itemController);
		navMenuPanel.loadButton.addActionListener(itemController);
		itemType.addActionListener(itemController);
		subItemType.addActionListener(itemController);
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

		else if(itemViewModel.message=="UncheckCheckBox"){
		
			chestSelectLabel.setVisible(false);
			chestList.removeAllItems();
			chestList.setVisible(false);
		}
	}
}
