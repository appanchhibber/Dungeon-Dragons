package Builder;

import com.SOEN6441_DND.Model.CharacterModel;

public class Explorer {
	private CharacterBuilder builder;
	
	public void setBuilder(CharacterBuilder newCharacterBuilder){
		builder=newCharacterBuilder;
	}
	
	public void constructCharacter(){
		builder.buildStrength();
		builder.buildCharisma();
		builder.buildConstitution();
		builder.buildDexterity();
		builder.buildWisdom();
		builder.buildIntelligence();
	}
	
	public CharacterModel getCharacter(){
		return builder.getCharacter();
	}

}
