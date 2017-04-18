package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public class Freezing extends WeaponDecorator{
	public Freezing(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}

	@Override
	public CharacterModel getEffectedEnemy() {
		super.enemyModel.freezed=true;
		super.enemyModel.freezeTimes=super.enchantedValue;
		return super.getEffectedEnemy();
	}

	
}
