package Decorator;

import java.util.ArrayList;

public class Slaying extends WeaponDecorator {
	public Slaying(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}

	@Override
	public ArrayList<String> getEffects() {
		super.getEffects().add("Slaying");
		return super.getEffects();
	}
	
}
