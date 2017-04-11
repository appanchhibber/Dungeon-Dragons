package Decorator;

import java.util.ArrayList;

public class WeaponDecorator extends WeaponEnchanment {

	private WeaponEnchanment decoratedWeapon;
	
	public WeaponDecorator(WeaponEnchanment weaponEnchanment){
		this.decoratedWeapon=weaponEnchanment;
	}
	@Override
	public ArrayList<String> addToEnchantList(String enchantment) {
		// TODO Auto-generated method stub
		return decoratedWeapon.addToEnchantList(enchantment);
	}

	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return decoratedWeapon.getEnchantmentValue();
	}
	@Override
	public WeaponEnchanment adaptToLevel(int level) {
		// TODO Auto-generated method stub
		return decoratedWeapon.adaptToLevel(level);
	}


	@Override
	public String lastWeaponID() {
		// TODO Auto-generated method stub
		return decoratedWeapon.lastWeaponID();
	}

}
