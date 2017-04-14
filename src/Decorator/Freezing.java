package Decorator;

import java.util.ArrayList;

public class Freezing extends WeaponDecorator{
	public Freezing(Weapon decoratedWeapon){
		super(decoratedWeapon);
	}

	@Override
	public ArrayList<String> getEffects() {
		super.getEffects().add("Freezing");
		return super.getEffects();
	}
	
}
