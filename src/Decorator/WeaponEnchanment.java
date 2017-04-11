package Decorator;

import java.util.ArrayList;

public  abstract class WeaponEnchanment {
	public abstract ArrayList<String> addToEnchantList(String enchantment);
	public abstract WeaponEnchanment adaptToLevel(int level);
	public abstract String lastWeaponID();
	public abstract int getEnchantmentValue();
}
