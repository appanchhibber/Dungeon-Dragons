package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Views.ItemAssignView;

public class ItemAssignViewController implements ActionListener {
	public CharacterModel characterModel;
	public ItemAssignView itemAssignView;

	public ItemAssignViewController(ItemAssignView view) {
		// TODO Auto-generated constructor stub
		itemAssignView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == itemAssignView.addItem) {
			if (itemAssignView.backPackList.getSelectedValue() != null) {
				String item = itemAssignView.backPackList.getSelectedValue().toString();
				int enchantBonus = 0;
				String itemType = "";
				String image = "";
				for (int i = 0; i < 7; i++) {
					try {
						if (itemAssignView.items[i].get(item).toArray() != null) {
							itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
							image = (itemAssignView.items[i].get(item).toArray()[2].toString()).replaceAll("\\s+", "");
							enchantBonus = Integer
									.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
							break;
						}
					} catch (NullPointerException ex) {
						// TODO: handle exception
					}
				}
				if (!itemType.equals("")) {
					ImageIcon itemImage = new ImageIcon("image/" + image + ".jpg");
					switch (itemType) {
					case "Helmet": {
						if (characterModel.getHelmetFlag() == null) {
							characterModel.setHelmetFlag(item);
							itemAssignView.helmetButton.setIcon(new ImageIcon(
									((itemImage.getImage().getScaledInstance(itemAssignView.helmetButton.getWidth(),
											itemAssignView.helmetButton.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
							characterModel.removeBackPackItems(item);
							characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
							characterModel.setArmorClass((enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel())) + characterModel.getArmorClass());

						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Armor": {
						if (characterModel.getArmorFlag() == null) {
							characterModel.setArmorFlag(item);
							characterModel.removeBackPackItems(item);
							characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
							characterModel.setArmorClass((enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel())) + characterModel.getArmorClass());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Shield": {
						if (characterModel.getShieldFlag() == null) {
							characterModel.setShieldFlag(item);
							itemAssignView.shieldButton.setIcon(new ImageIcon(
									((itemImage.getImage().getScaledInstance(itemAssignView.shieldButton.getWidth(),
											itemAssignView.shieldButton.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
							characterModel.removeBackPackItems(item);
							characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
							characterModel.setArmorClass((enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel())) + characterModel.getArmorClass());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Belt": {
						if (characterModel.getBeltFlag() == null) {
							characterModel.setBeltFlag(item);
							itemAssignView.beltButton.setIcon(new ImageIcon(
									((itemImage.getImage().getScaledInstance(itemAssignView.beltButton.getWidth(),
											itemAssignView.beltButton.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
							characterModel.removeBackPackItems(item);
							characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
							characterModel.getAbilityModifier().setConstitution(
									characterModel.getAbilityModifier().getConstitution() + (enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel())));
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Boots": {
						if (characterModel.getBootFlag() == null) {
							characterModel.setBootFlag(item);
							itemAssignView.bootButton.setIcon(new ImageIcon(
									((itemImage.getImage().getScaledInstance(itemAssignView.bootButton.getWidth(),
											itemAssignView.bootButton.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
							characterModel.removeBackPackItems(item);
							characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
							characterModel.setArmorClass((enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel())) + characterModel.getArmorClass());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Ring": {
						if (characterModel.getRingFlag() == null) {
							characterModel.setRingFlag(item);
							itemAssignView.ringButton.setIcon(new ImageIcon(
									((itemImage.getImage().getScaledInstance(itemAssignView.ringButton.getWidth(),
											itemAssignView.ringButton.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
							characterModel.removeBackPackItems(item);
							characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
							characterModel.setArmorClass((enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel())) + characterModel.getArmorClass());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Weapon": {
						if (characterModel.getWeaponFlag() == null) {
							characterModel.setWeaponFlag(item);
							characterModel.removeBackPackItems(item);
							characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
							characterModel
									.setDamageBonus((enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel()))+characterModel.calculateEnchanment(characterModel.getLevel()) + characterModel.getAbilityModifier().getStrength());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}

					}
				}
			}
		} else if (e.getSource() == itemAssignView.backPackAssign) {
			if (itemAssignView.subItemType.getSelectedItem() != null) {
				String item = itemAssignView.subItemType.getSelectedItem().toString();
				if (characterModel.getBackPackCounter() < 11) {
					if (characterModel.getBackPackItems().contains(item)) {
						JOptionPane.showMessageDialog(null, "This Item is already inside the Backpack");
					} else {
						characterModel.setBackPackCounter(characterModel.getBackPackCounter() + 1);
						characterModel.addBackPackItems(item);
					}
				} else {
					JOptionPane.showMessageDialog(null, "You can store only 10 items in your Backpack");
				}
			}

		} else if (e.getSource() == itemAssignView.backPackRemove) {
			if (itemAssignView.backPackList.getSelectedValue() != null) {
				String item = itemAssignView.backPackList.getSelectedValue().toString();
				if (characterModel.getBackPackCounter() > 0) {
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));

				}
			} else {
				JOptionPane.showMessageDialog(null, "Please select an Item to remove.");
			}

		} else if (e.getSource() == itemAssignView.weaponButton) {
			if (characterModel.getWeaponFlag() != null) {
			if(removeAssignItem(characterModel.getWeaponFlag())){
				characterModel.setWeaponFlag(null);
			}	
			}
			
		} else if (e.getSource() == itemAssignView.helmetButton) {
			if (characterModel.getHelmetFlag() != null) {
				if(removeAssignItem(characterModel.getHelmetFlag())){
					characterModel.setHelmetFlag(null);
				}	
				}
		} else if (e.getSource() == itemAssignView.armorButton) {
			if (characterModel.getArmorFlag() != null) {
				if(removeAssignItem(characterModel.getArmorFlag())){
					characterModel.setArmorFlag(null);
				}	
				}
		} else if (e.getSource() == itemAssignView.ringButton) {
			if (characterModel.getRingFlag() != null) {
				if(removeAssignItem(characterModel.getRingFlag())){
					characterModel.setRingFlag(null);
				}	
				}
		} else if (e.getSource() == itemAssignView.beltButton) {
			if (characterModel.getBeltFlag() != null) {
				if(removeAssignItem(characterModel.getBeltFlag())){
					characterModel.setBeltFlag(null);
				}	
				}
		} else if (e.getSource() == itemAssignView.shieldButton) {
			if (characterModel.getShieldFlag() != null) {
				if(removeAssignItem(characterModel.getShieldFlag())){
					characterModel.setShieldFlag(null);
				}	
				}
		} else if (e.getSource() == itemAssignView.bootButton) {
			if (characterModel.getBootFlag() != null) {
				if(removeAssignItem(characterModel.getBootFlag())){
					characterModel.setBootFlag(null);
				}	
				}

		}
	}
	public boolean removeAssignItem(String item){
		int enchantBonus = 0;
		String itemType = "";
		String image = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer
							.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}
		}
		if(characterModel.getBackPackCounter()<10 && ! characterModel.getBackPackItems().contains(item))
		{
			characterModel.addBackPackItems(item);
			characterModel.setBackPackCounter(characterModel.getBackPackCounter()+1);
		if(itemType=="Weapon")
		{			
			characterModel
			.setDamageBonus((characterModel.getDamageBonus()-(enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel()))));
		}
		else if(itemType=="Belt"){
			characterModel.getAbilityModifier().setConstitution((
					characterModel.getAbilityModifier().getConstitution()-(enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel()))));
		}
		else{
			characterModel.setArmorClass((characterModel.getArmorClass()-(enchantBonus+characterModel.calculateEnchanment(characterModel.getLevel()))));
		}
		return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "Please make space in your BackPack.");
			return false;
		}
	}

}
