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
 *
 */
public class ItemScene extends View implements Observer {

	public String mode;
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
	public JLabel weaponTypeLabel;
	public JLabel weaponRangeLabel;
	public JLabel weaponEnchantment;
	
	public JCheckBox addChest;
	public JTextArea itemDescription;
	public JLabel itemNewName;

	public JComboBox savedItemNames;
	// TextField
	public JTextField nameField;
	public JTextField weaponType;
	public JTextField weaponRange;

	// Controllers
	public ItemSceneController itemController;

	// ImageIcon
	ImageIcon itemImage;
	
	//Checkbox
	public JCheckBox freezing;
	public JCheckBox burning;
	public JCheckBox slaying;
	public JCheckBox frightening;
	public JCheckBox pacifying;

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
		itemTypeLabel.setLocation(30, 10);
		itemTypeLabel.setForeground(Color.WHITE);

		itemType = new JComboBox();
		itemType.setSize(140, 25);
		itemType.setLocation(150, 10);

	
		itemLabel = new JLabel("Select Item:");
		itemLabel.setSize(80, 20);
		itemLabel.setLocation(30, 60);
		itemLabel.setForeground(Color.WHITE);

		subItemType = new JComboBox();
		subItemType.setSize(140, 25);
		subItemType.setLocation(150, 60);

		
		nameLabel = new JLabel("Set Name :");
		nameLabel.setSize(100, 30);
		nameLabel.setLocation(30, 120);
		nameLabel.setForeground(Color.WHITE);
		
		nameField = new JTextField();
		nameField.setSize(140, 25);
		nameField.setLocation(150, 120);
		
		itemNewName = new JLabel("Set new Name");
		itemNewName.setSize(130, 30);
		itemNewName.setLocation(30, 165);
		itemNewName.setForeground(Color.WHITE);
		itemNewName.setVisible(false);
		
		savedItemNames=new JComboBox<>();
		savedItemNames.setSize(140, 25);
		savedItemNames.setLocation(150, 120);
		savedItemNames.setVisible(false);
		
		weaponTypeLabel = new JLabel("Weapon Type : ");
		weaponTypeLabel.setSize(100, 30);
		weaponTypeLabel.setLocation(30, 175);
		weaponTypeLabel.setForeground(Color.WHITE);
		weaponTypeLabel.setVisible(false);
		
		weaponType = new JTextField();
		weaponType.setSize(120, 20);
		weaponType.setLocation(150, 175);
		weaponType.setForeground(Color.BLUE);
		weaponType.setEditable(false);
		weaponType.setVisible(false);
		
		weaponRangeLabel = new JLabel("Weapon Range : ");
		weaponRangeLabel.setSize(100, 30);
		weaponRangeLabel.setLocation(30, 210);
		weaponRangeLabel.setForeground(Color.WHITE);
		weaponRangeLabel.setVisible(false);
		
		weaponRange = new JTextField();
		weaponRange.setSize(120, 20);
		weaponRange.setLocation(150, 210);
		weaponRange.setForeground(Color.BLUE);
		weaponRange.setEditable(false);
		weaponRange.setVisible(false);
		
		weaponEnchantment = new JLabel("Add Weapon Enchantment");
		weaponEnchantment.setSize(150, 30);
		weaponEnchantment.setLocation(60, 260);
		weaponEnchantment.setForeground(Color.MAGENTA);
		weaponEnchantment.setVisible(false);
		
		freezing = new JCheckBox("Freezing");
		freezing.setLocation(20, 280);
		freezing.setSize(100, 30);
		freezing.setOpaque(false);
		freezing.setForeground(Color.WHITE);
		freezing.setSelected(false);
		freezing.setVisible(false);
		
		burning = new JCheckBox("Burning");
		burning.setLocation(125, 280);
		burning.setSize(100, 30);
		burning.setOpaque(false);
		burning.setForeground(Color.WHITE);
		burning.setSelected(false);
		burning.setVisible(false);
		
		slaying = new JCheckBox("Slaying");
		slaying.setLocation(230, 280);
		slaying.setSize(100, 30);
		slaying.setOpaque(false);
		slaying.setForeground(Color.WHITE);
		slaying.setSelected(false);
		slaying.setVisible(false);
		
		frightening = new JCheckBox("Frightening");
		frightening.setLocation(40, 300);
		frightening.setSize(100, 30);
		frightening.setOpaque(false);
		frightening.setForeground(Color.WHITE);
		frightening.setSelected(false);
		frightening.setVisible(false);
		
		pacifying = new JCheckBox("Pacifying");
		pacifying.setLocation(150, 300);
		pacifying.setSize(100, 30);
		pacifying.setOpaque(false);
		pacifying.setForeground(Color.WHITE);
		pacifying.setSelected(false);
		pacifying.setVisible(false);
		
		enchantLabel = new JLabel("Enchantment Value:");
		enchantLabel.setSize(210, 20);
		enchantLabel.setLocation(30, 350);
		enchantLabel.setForeground(Color.WHITE);
		
		enchantList = new JComboBox();
		enchantList.setSize(60, 20);
		enchantList.setLocation(180, 350);
		
		addChest=new JCheckBox("Add To Tressure");
		addChest.setSize(210, 30);
		addChest.setOpaque(false);
		addChest.setForeground(Color.WHITE);
		addChest.setLocation(30, 390);
		
		
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
		itemViewPanel.add(itemNewName);
		itemViewPanel.add(weaponType);
		itemViewPanel.add(weaponTypeLabel);
		itemViewPanel.add(weaponRangeLabel);
		itemViewPanel.add(weaponRange);
		itemViewPanel.add(weaponEnchantment);
		itemViewPanel.add(freezing);
		itemViewPanel.add(burning);
		itemViewPanel.add(pacifying);
		itemViewPanel.add(frightening);
		itemViewPanel.add(slaying);
		
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
		 this.mode = mode;
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
				this.mode = mode;
				itemType.setSelectedIndex(itemTypeList.valueOf(itemViewModel.getItemType()).ordinal());
				itemType.setForeground(Color.BLACK);
				itemType.setEnabled(false);
				subItemType.setModel(itemViewModel.getSavedItemTypeList());
				nameLabel.setText("Name");
				nameField.setLocation(150, 165);
				nameField.setVisible(true);
				itemNewName.setVisible(true);
				savedItemNames.setModel(itemViewModel.getSavedItemNameList());
				savedItemNames.setVisible(true);
				if(itemViewModel.getItemType().equalsIgnoreCase("weapon")){
				weaponTypeLabel.setVisible(true);
				weaponTypeLabel.setLocation(20, 210);
				weaponType.setText((String) itemViewModel.getWeaponTypeList().getElementAt(savedItemNames.getSelectedIndex()));
				weaponType.setLocation(150, 210);
				weaponType.setVisible(true);
				weaponRangeLabel.setLocation(20, 240);
				weaponRangeLabel.setVisible(true);			
				weaponRange.setText((String) itemViewModel.getWeaponRangeList().getElementAt(savedItemNames.getSelectedIndex()));
				weaponRange.setLocation(150, 240);
				weaponRange.setVisible(true);
				weaponEnchantment.setVisible(true);
				weaponEnchantment.setLocation(60, 280);
				freezing.setVisible(true);
				freezing.setLocation(30, 300);
				pacifying.setVisible(true);
				pacifying.setLocation(60, 320);
				frightening.setVisible(true);
				frightening.setLocation(160, 320);
				slaying.setVisible(true);
				slaying.setLocation(220, 300);
				burning.setVisible(true);
				burning.setLocation(140, 300);
				}
				enchantLabel.setLocation(30, 380);
				enchantList.setLocation(180, 380);
				addChest.setLocation(30, 410);
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
		freezing.addActionListener(itemController);
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
		} 
		else if(itemViewModel.message == "itemType changed"){
		
			if(!itemType.getSelectedItem().toString().equalsIgnoreCase("weapon")){
				weaponTypeLabel.setVisible(false);
				weaponType.setVisible(false);
				weaponRangeLabel.setVisible(false);
				weaponRange.setVisible(false);
				weaponEnchantment.setVisible(false);
				freezing.setVisible(false);
				burning.setVisible(false);
				frightening.setVisible(false);
				slaying.setVisible(false);
				pacifying.setVisible(false);
			}
		}
		else if (itemViewModel.message == "ImageChanged") {
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

		else if(itemViewModel.message == "weaponType changed"){
			weaponTypeLabel.setVisible(true);
			weaponType.setVisible(true);
			weaponType.setText(itemViewModel.getWeaponType());
			weaponEnchantment.setVisible(true);
			freezing.setVisible(true);
			burning.setVisible(true);
			frightening.setVisible(true);
			slaying.setVisible(true);
			pacifying.setVisible(true);
			}
	
		else if(itemViewModel.message == "weaponRange changed"){
			weaponRangeLabel.setVisible(true);
			weaponRange.setVisible(true);
			weaponRange.setText(itemViewModel.getWeaponRange());
		}
	}
}
