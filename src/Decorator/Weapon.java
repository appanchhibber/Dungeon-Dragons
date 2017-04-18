package Decorator;

import java.util.ArrayList;

import com.SOEN6441_DND.Model.CharacterModel;

public abstract class Weapon {
	public CharacterModel enemyModel;
	public int enchantedValue;
	public abstract CharacterModel getEffectedEnemy();
}
