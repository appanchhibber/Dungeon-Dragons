package Builder;

import java.util.Random;

import com.SOEN6441_DND.Controller.CharacterSceneController;
import com.SOEN6441_DND.Model.AbilityModel;
import com.SOEN6441_DND.Model.CharacterModel;

public abstract class CharacterBuilder {

	protected AbilityModel characterScore;
	public CharacterSceneController characterSceneController;
	protected int score[] = new int[6];
	
	public void setAbilityModel(AbilityModel model){
		characterScore = model;
	}
	
		
	
	public abstract void buildStrength();
	public abstract void buildDexterity();
	public abstract void buildConstitution();
	public abstract void buildIntelligence();
	public abstract void buildWisdom();
	public abstract void buildCharisma();
}