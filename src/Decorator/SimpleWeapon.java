package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public class SimpleWeapon extends Weapon {
	
	public SimpleWeapon(CharacterModel enemy,int enchantedvalue){
		this.enemyModel=enemy;
		this.enchantedValue=enchantedvalue;
	}
	
	@Override
	public CharacterModel getEffectedEnemy() {
		// TODO Auto-generated method stub
		return enemyModel;
	}
}
