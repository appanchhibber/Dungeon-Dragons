package com.SOEN6441_DND.Controller;

import com.SOEN6441_DND.Model.AbilityModel;
import com.SOEN6441_DND.Model.CharacterModel;

/**
 * The class for the fighter class
 * @author Paras Malik
 *
 */
public abstract class FighterBuilder {
		private AbilityModel fighter;		
		 abstract void buildStrength(int strength); 
		 abstract void buildDexterity(int dexterity) ;
		 abstract void buildConstitution(int constitution);
		 abstract void buildWisdom(int wisdom);
		 abstract void buildCharisma(int charisma);
}
