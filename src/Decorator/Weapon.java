package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.ItemModel;

public class Weapon extends WeaponDecorator {
public ItemModel itemModel;
	public Weapon(WeaponEnchanment weaponEnchanment,ItemModel model) {
		super(weaponEnchanment);
		this.itemModel=model;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> addToEnchantList(String enchantment) {
		// TODO Auto-generated method stub
		return super.addToEnchantList(enchantment);
	}

	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return super.getEnchantmentValue();
	}

	@Override
	public WeaponEnchanment adaptToLevel(int level) {
		// TODO Auto-generated method stub
		return super.adaptToLevel(level);
	}

	@Override
	public String lastWeaponID() {
		// TODO Auto-generated method stub
		return super.lastWeaponID();
	}

}
