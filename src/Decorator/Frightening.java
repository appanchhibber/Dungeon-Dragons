package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public class Frightening extends WeaponDecorator {
	public Frightening(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}

	@Override
	public CharacterModel getEffectedEnemy() {
		// TODO Auto-generated method stub
		super.enemyModel.frightened=true;
		return super.getEffectedEnemy();
	}

	
	
}
