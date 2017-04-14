package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public  abstract class WeaponDecorator extends Weapon {

	protected final  Weapon decoratedWeapon;
	
	public WeaponDecorator(Weapon weapon){
		this.decoratedWeapon=weapon;
	}

	@Override
	public ArrayList<String> getEffects() {
		// TODO Auto-generated method stub
		return decoratedWeapon.getEffects();
	}

	

}
