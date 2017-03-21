package Builder;

import com.SOEN6441_DND.Model.AbilityModel;

/**
 * Type of charater to be build using the builder pattern.
 * @author Paras Malik
 *
 */
public class TankCharacterBuilder extends CharacterBuilder{

	public TankCharacterBuilder(AbilityModel scoreModel,int[] sc) {
		// TODO Auto-generated constructor stub
		setAbilityModel(scoreModel);
		score=sc;
	}
	@Override
	public void buildStrength() {
		// TODO Auto-generated method stub
		characterScore.setStrength(score[2]);
	}

	@Override
	public void buildDexterity() {
		// TODO Auto-generated method stub
		characterScore.setDexterity(score[1]);
	}

	@Override
	public void buildConstitution() {
		// TODO Auto-generated method stub
		characterScore.setConstitution(score[0]);
	}

	@Override
	public void buildIntelligence() {
		// TODO Auto-generated method stub
		characterScore.setIntelligence(score[3]);
	}

	@Override
	public void buildWisdom() {
		// TODO Auto-generated method stub
		characterScore.setWisdom(score[5]);
	}

	@Override
	public void buildCharisma() {
		// TODO Auto-generated method stub
		characterScore.setCharisma(score[4]);
	}

}
