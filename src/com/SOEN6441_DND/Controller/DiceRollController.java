package com.SOEN6441_DND.Controller;
/**
 * This Class calculates Dice Rolls Value based on different types of dice Ex. 4d6, 6d8 etc..
 * @author Punit Trivedi
 * @author Appan Chhibber
 *
 */
public class DiceRollController {
	
	public int counter;//No of times Dice should roll. Ex. 4d6  Counter = 4;
	public int maxDiceValue; //Maximum value of Single Dice. Ex. 4d6  maxDiceValue = 6;
	public int maxTotal;
	public int minTotal;
	public int diceResult;

	/**
	 * This constructor inputs takes input the dice value and counter to be
	 * used for calculating the result of the dice rolled.
	 * 
	 * @param counter
	 * @param maxDiceValue
	 */
	public DiceRollController(int counter,int maxDiceValue) {
		this.counter=counter;
		this.maxDiceValue=maxDiceValue;
		this.maxTotal=counter*maxDiceValue;
		this.minTotal=counter;
		this.diceResult=0;
	}
	
	/**
	 * This function calculates the dice result based on the random number generated
	 * by random() function
	 * 
	 * @return diceResult Returns the calculated the dice rolled value.
	 */
	public int getDiceRollResult(){
		
		diceResult=(int)(Math.random() * (maxTotal+1)); 
		if(diceResult<4){
			diceResult+=minTotal;
		}
		return diceResult;
	}
	
	/**
	 * 
	 * Setting the counter
	 * @param counter
	 */
	public void setCounter(int counter){
		this.counter=counter;
	}
	
	/**
	 * Setting the max dice value
	 * @param maxDiceValue
	 */
	public void maxDiceValue(int maxDiceValue){
		this.maxDiceValue=maxDiceValue;
	}
	
	

}
