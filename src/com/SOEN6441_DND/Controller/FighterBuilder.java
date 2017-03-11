package com.SOEN6441_DND.Controller;

import com.SOEN6441_DND.Model.AbilitiyModel;
import com.SOEN6441_DND.Model.CharacterModel;

public abstract class FighterBuilder {
		private AbilitiyModel fighter;		
		 abstract void buildStrength(int strength); 
		 abstract void buildDexterity(int dexterity) ;
		 abstract void buildConstitution(int constitution);
		 abstract void buildWisdom(int wisdom);
		 abstract void buildCharisma(int charisma);
}
