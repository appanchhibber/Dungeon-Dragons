package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public abstract class Weapon {
	public ArrayList<String> effectList;

	public abstract ArrayList<String> getEffects();
}
