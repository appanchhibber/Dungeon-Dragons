package Decorator;

import java.util.ArrayList;

public class Burning extends WeaponDecorator {
	
	public Burning(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}
	@Override
	public ArrayList<String> getEffects() {
		// TODO Auto-generated method stub
		super.getEffects().add("Burning");
		return super.getEffects();
	}

}
