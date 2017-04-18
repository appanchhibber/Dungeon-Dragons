package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public class Slaying extends WeaponDecorator {
	public Slaying(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}

	@Override
	public CharacterModel getEffectedEnemy() {
		super.enemyModel.setHitPoints(0);
		return super.getEffectedEnemy();
	}

	
	
}
