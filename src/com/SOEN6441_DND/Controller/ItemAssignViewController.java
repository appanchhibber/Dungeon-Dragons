package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Views.ItemAssignView;
import com.SOEN6441_DND.Views.View;

/**
 * This class is a controller for the item assign view. It performs all Item
 * related operations Like add enchantment bonus, add and remove item from
 * character and back pack.
 * 
 * @author Punit Trivedi
 *
 */
public class ItemAssignViewController implements ActionListener {
	public CharacterModel characterModel;
	public ItemAssignView itemAssignView;

	/**
	 * Default construtor for item assign view.
	 */
	public ItemAssignViewController() {
	}

	/**
	 * Constructor for item assign View
	 * 
	 * @param view
	 */
	public ItemAssignViewController(ItemAssignView view) {
		// TODO Auto-generated constructor stub
		itemAssignView = view;
	}

	/**
	 * Action Listener
	 */
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
							characterModel.addOwnedItems("Helmet", itemAssignView.fileIO.readSingleItem(item, "Helmet"));
							characterModel.setHelmetFlag(item);
							characterModel.setArmorClass(
									(characterModel.getOwnedItems().get("Helmet").getEnchantValue())
											+ characterModel.getArmorClass());

						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Armor": {
						if (characterModel.getArmorFlag() == null) {					
							characterModel.addOwnedItems("Armor", itemAssignView.fileIO.readSingleItem(item, "Armor"));
							characterModel.setArmorFlag(item);
							characterModel.setArmorClass(
									(characterModel.getOwnedItems().get("Armor").getEnchantValue())
											+ characterModel.getArmorClass());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Shield": {
						if (characterModel.getShieldFlag() == null) {
							characterModel.addOwnedItems("Shield", itemAssignView.fileIO.readSingleItem(item, "Shield"));
							characterModel.setShieldFlag(item);
							characterModel.setArmorClass(
									(characterModel.getOwnedItems().get("Shield").getEnchantValue())
											+ characterModel.getArmorClass());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Belt": {
						if (characterModel.getBeltFlag() == null) {
							
							characterModel.addOwnedItems("Belt", itemAssignView.fileIO.readSingleItem(item, "Belt"));
							characterModel.setBeltFlag(item);
							characterModel.getAbilityModifier().setConstitution(characterModel.getAbilityModifier()
									.getConstitution()
									+ (characterModel.getOwnedItems().get("Belt").getEnchantValue()));
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Boots": {
						if (characterModel.getBootFlag() == null) {
							characterModel.addOwnedItems("Boots", itemAssignView.fileIO.readSingleItem(item, "Boots"));
							characterModel.setBootFlag(item);
							characterModel.setArmorClass(
									(characterModel.getOwnedItems().get("Boots").getEnchantValue())
											+ characterModel.getArmorClass());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Ring": {
						if (characterModel.getRingFlag() == null) {
							characterModel.addOwnedItems("Ring", itemAssignView.fileIO.readSingleItem(item, "Ring"));
							characterModel.setRingFlag(item);
							characterModel.setArmorClass(
									(characterModel.getOwnedItems().get("Ring").getEnchantValue())
											+ characterModel.getArmorClass());
						} else {
							JOptionPane.showMessageDialog(null, "This Item is already assign");
						}
						break;
					}
					case "Weapon": {
						if (characterModel.getWeaponFlag() == null) {
							characterModel.addOwnedItems("Weapon", itemAssignView.fileIO.readSingleItem(item, "Weapon"));
							characterModel.setWeaponFlag(item);
							characterModel.setDamageBonus(characterModel.getOwnedItems().get("Weapon").getEnchantValue()+ characterModel.getAbilityModifier().getStrength());
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
				if (removeAssignItem(characterModel.getWeaponFlag())) {
					characterModel.setWeaponFlag(null);
				}
			}

		} else if (e.getSource() == itemAssignView.helmetButton) {
			if (characterModel.getHelmetFlag() != null) {
				if (removeAssignItem(characterModel.getHelmetFlag())) {
					characterModel.setHelmetFlag(null);
				}
			}
		} else if (e.getSource() == itemAssignView.armorButton) {
			if (characterModel.getArmorFlag() != null) {
				if (removeAssignItem(characterModel.getArmorFlag())) {
					characterModel.setArmorFlag(null);
				}
			}
		} else if (e.getSource() == itemAssignView.ringButton) {
			if (characterModel.getRingFlag() != null) {
				if (removeAssignItem(characterModel.getRingFlag())) {
					characterModel.setRingFlag(null);
				}
			}
		} else if (e.getSource() == itemAssignView.beltButton) {
			if (characterModel.getBeltFlag() != null) {
				if (removeAssignItem(characterModel.getBeltFlag())) {
					characterModel.setBeltFlag(null);
				}
			}
		} else if (e.getSource() == itemAssignView.shieldButton) {
			if (characterModel.getShieldFlag() != null) {
				if (removeAssignItem(characterModel.getShieldFlag())) {
					characterModel.setShieldFlag(null);
				}
			}
		} else if (e.getSource() == itemAssignView.bootButton) {
			if (characterModel.getBootFlag() != null) {
				if (removeAssignItem(characterModel.getBootFlag())) {
					characterModel.setBootFlag(null);
				}
			}

		}
	}
	/**
	 * This method removes assigned item
	 * 
	 * @param item
	 * @return
	 */
	public boolean removeAssignItem(String item) {
		int enchantBonus = 0;
		String itemType = "";
		String image = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}
		}
		if (characterModel.getBackPackCounter() < 10 && !characterModel.getBackPackItems().contains(item)) {
			characterModel.addBackPackItems(item);
			characterModel.setBackPackCounter(characterModel.getBackPackCounter() + 1);
			if (itemType.equals("Weapon")) {
				characterModel.setDamageBonus(characterModel.getDamageBonus()-(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel())));
			} else if (itemType.equals("Belt")) {
				characterModel.getAbilityModifier()
						.setConstitution(characterModel.getAbilityModifier()
								.getConstitution()- (enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel())));
			} else if (itemType.equals("Boots") || itemType.equals("Armor") || itemType.equals("Ring") || itemType.equals("Shield") || itemType.equals("Helmet") ){
				characterModel.setArmorClass(characterModel.getArmorClass()- (enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel())));
			}
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Please make space in your BackPack.");
			return false;
		}
	}

	public String characterHelmetWearCheck() {
		int enchantBonus = 0;
		String item = "new hemlParas";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Helmet")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return "Helmet is already assigned";
				}
			}
		}
		return "Helmet assigned";
	}

	public String characterArmorWearCheck() {
		int enchantBonus = 0;
		String item = "My Arm";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Armor")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return "Armor is already assigned";
				}
			}
		}
		return "Armor assigned";
	}

	public String characterShieldWearCheck() {
		int enchantBonus = 0;
		String item = "My Shield";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Shield")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return "Shield is already assigned";
				}
			}
		}
		return "Shield assigned";
	}

	public String characterBeltWearCheck() {
		int enchantBonus = 0;
		String item = "My Belt";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Belt")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return "Belt is already assigned";
				}
			}
		}
		return "Belt assigned";
	}

	public String characterBootsWearCheck() {
		int enchantBonus = 0;
		String item = "My Boot";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Boots")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return "Boots is already assigned";
				}
			}
		}
		return "Boots assigned";
	}

	public String characterRingWearCheck() {
		int enchantBonus = 0;
		String item = "My Ring";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Ring")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return "Ring is already assigned";
				}
			}
		}
		return "Ring assigned";
	}

	public CharacterModel characterWeaponCheckAbility() {
		int enchantBonus = 0;
		String item = "My Axe2";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Weapon")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return characterModel;
				}
			}
		}
		return characterModel;
	}

	public CharacterModel characterHelmetCheckAbility() {
		int enchantBonus = 0;
		String item = "new hemlParas";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Helmet")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return characterModel;
				}
			}
		}
		return characterModel;
	}

	public CharacterModel characterArmorCheckAbility() {
		int enchantBonus = 0;
		String item = "My Arm";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Armor")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return characterModel;
				}
			}
		}
		return characterModel;
	}

	public CharacterModel characterShieldCheckAbility() {
		int enchantBonus = 0;
		String item = "My Shield";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Shield")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return characterModel;
				}
			}
		}
		return characterModel;
	}

	public CharacterModel characterBeltCheckAbility() {
		int enchantBonus = 0;
		String item = "My Belt";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Belt")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return characterModel;
				}
			}
		}
		return characterModel;
	}

	public CharacterModel characterBootsCheckAbility() {
		int enchantBonus = 0;
		String item = "My Boot";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Boots")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return characterModel;
				}
			}
		}
		return characterModel;
	}

	public CharacterModel characterRingCheckAbility() {
		int enchantBonus = 0;
		String item = "My Ring";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Ring")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setArmorClass(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getArmorClass());

				}

				else {
					return characterModel;
				}
			}
		}
		return characterModel;
	}

	public String characterWeaponWearCheck() {
		int enchantBonus = 0;
		String item = "My Axe2";
		String itemType = "";
		for (int i = 0; i < 7; i++) {
			try {
				if (itemAssignView.items[i].get(item).toArray() != null) {
					itemType = itemAssignView.items[i].get(item).toArray()[1].toString();
					enchantBonus = Integer.parseInt((itemAssignView.items[i].get(item).toArray()[3].toString()));
					break;
				}
			} catch (NullPointerException ex) {
				// TODO: handle exception
			}

			if (itemType.equals("Weapon")) {
				if (characterModel.getHelmetFlag() == null) {
					characterModel.setHelmetFlag(item);
					characterModel.removeBackPackItems(item);
					characterModel.setBackPackCounter((characterModel.getBackPackCounter() - 1));
					characterModel.setDamageBonus(
							(enchantBonus + characterModel.calculateEnchanment(characterModel.getLevel()))
									+ characterModel.getDamageBonus());

				}

				else {
					return "Weapon is already assigned";
				}
			}
		}
		return "Weapon assigned";
	}

	

}
