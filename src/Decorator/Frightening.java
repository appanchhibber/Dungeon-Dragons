package Decorator;

import java.util.ArrayList;

public class Frightening extends WeaponDecorator {
	public Frightening(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}

	@Override
	public ArrayList<String> getEffects() {
		super.getEffects().add("Frightening");
		return super.getEffects();
	}
	
}
