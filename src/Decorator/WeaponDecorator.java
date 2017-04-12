package Decorator;

import java.util.ArrayList;

public  abstract class WeaponDecorator extends WeaponEnchanment {

	protected final  WeaponEnchanment decoratedWeapon;
	
	public WeaponDecorator(WeaponEnchanment weaponEnchanment){
		this.decoratedWeapon=weaponEnchanment;
	}
	@Override
	public ArrayList<String> addToEnchantList(String enchantment) {
		return decoratedWeapon.addToEnchantList(enchantment);
	}

	@Override
	public int getEnchantmentValue() {
		return decoratedWeapon.getEnchantmentValue();
	}
	@Override
	public WeaponEnchanment adaptToLevel(int level) {
		return decoratedWeapon.adaptToLevel(level);
	}
	@Override
	public String lastWeaponID() {
		return decoratedWeapon.lastWeaponID();
	}

}
