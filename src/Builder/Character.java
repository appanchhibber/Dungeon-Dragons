package Builder;

/**
 * Product class of the builder pattern
 * @author Paras Malik
 *
 */
public class Character {

	private int Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma;
	
	/**
	 * Setting the strength for fighter
	 * @param newStrength
	 */
	public void setStrength(int newStrength){
		Strength = newStrength;
	}
	/**
	 * Setting the dexterity for fighter
	 * @param newDexterity
	 */
	public void setDexterity(int newDexterity){
		Dexterity = newDexterity;
	}
	
	/**
	 * Setting the constitution for fighter
	 * @param newConstitution
	 */
	public void setConstitution(int newConstitution){
		Constitution = newConstitution;
	}
	
	/**
	 * Setting the intelligence for fighter
	 * @param newIntelligence
	 */
	public void setIntelligence(int newIntelligence){
		Intelligence = newIntelligence;
	}
	
	/**
	 * Setting the wisdom for fighter
	 * @param newWisdom
	 */
	public void setWisdom(int newWisdom){
		Wisdom = newWisdom;
	}
	
	/**
	 * Setting the charisma for fighter
	 * @param newCharisma
	 */
	public void setCharisma(int newCharisma){
		Charisma = newCharisma;
	}
	
	public int getStrength(){
		return Strength;
	}
	public int getDexterity(){
		return Dexterity;
	}
	public int getConstitution(){
		return Constitution;
	}
	public int getIntelligence(){
		return Intelligence;
	}
	public int getWisdom(){
		return Wisdom;
	}
	public int getCharisma(){
		return Charisma;
	}
}