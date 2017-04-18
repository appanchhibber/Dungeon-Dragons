package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public class Burning extends WeaponDecorator {
	
	public Burning(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}
	@Override
	public CharacterModel getEffectedEnemy() {
		super.decoratedWeapon.enemyModel.burned=true;
		super.decoratedWeapon.enemyModel.burnedValue=5*super.decoratedWeapon.enchantedValue;
		super.decoratedWeapon.enemyModel.burnedTimes=3;
		System.out.println("Inside burning");
		return super.getEffectedEnemy();
	}

	

}
