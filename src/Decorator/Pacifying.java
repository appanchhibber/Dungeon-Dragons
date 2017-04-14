package Decorator;

import java.util.ArrayList;

public class Pacifying extends WeaponDecorator {
	public Pacifying(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}

	@Override
	public ArrayList<String> getEffects() {
		super.getEffects().add("Pacifying");
		return super.getEffects();
	}
	
}
