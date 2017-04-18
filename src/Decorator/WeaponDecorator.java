package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public  abstract class WeaponDecorator extends Weapon {

	protected final Weapon decoratedWeapon;
	
	public WeaponDecorator(Weapon weapon){
		this.decoratedWeapon=weapon;
		this.enemyModel=weapon.enemyModel;
		this.enchantedValue=weapon.enchantedValue;
		System.out.println("From the Decorator:"+weapon.enemyModel.getName());
	} 

	@Override
	public CharacterModel getEffectedEnemy() {
		return decoratedWeapon.getEffectedEnemy();
	}

	

	

}
