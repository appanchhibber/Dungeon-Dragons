package com.SOEN6441_DND.Controller;
/**
 * This Class calculates Dice Rolls Value based on different types of dice Ex. 4d6, 6d8 etc..
 * @author Punit Trivedi
 * @author Appan Chhibber
 *
 */
public class DiecRollController {
	
	public int counter;//No of times Dice should roll. Ex. 4d6  Counter = 4;
	public int maxDiceValue; //Maximum value of Single Dice. Ex. 4d6  maxDiceValue = 6;
	public int maxTotal;
	public int minTotal;
	public int diceResult;

	public DiecRollController(int counter,int maxDiceValue) {
		this.counter=counter;
		this.maxDiceValue=maxDiceValue;
		this.maxTotal=counter*maxDiceValue;
		this.minTotal=counter;
		this.diceResult=0;
	}
	public int getDiceRollResult(){
		
		diceResult=minTotal+(int)(Math.random() * maxTotal); 
		if(diceResult>24){
			diceResult-=minTotal;
		}
		return diceResult;
	}
	public void setCounter(int counter){
		this.counter=counter;
	}
	public void maxDiceValue(int maxDiceValue){
		this.maxDiceValue=maxDiceValue;
	}
	
	

}
