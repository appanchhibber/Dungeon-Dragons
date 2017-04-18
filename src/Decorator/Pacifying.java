package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public class Pacifying extends WeaponDecorator {
	public Pacifying(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}

	@Override
	public CharacterModel getEffectedEnemy() {
		super.enemyModel.setBehaviour("Friendly");
		System.out.println(super.enemyModel.getName()+" is now Friendly");
		return super.getEffectedEnemy();
	}

	
	
}
