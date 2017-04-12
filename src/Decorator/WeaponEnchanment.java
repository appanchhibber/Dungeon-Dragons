package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.ItemModel;

public  abstract class WeaponEnchanment extends ItemModel{
	public abstract ArrayList<String> addToEnchantList(String enchantment);
	public abstract WeaponEnchanment adaptToLevel(int level);
	public abstract String lastWeaponID();
	public abstract int getEnchantmentValue();
}
