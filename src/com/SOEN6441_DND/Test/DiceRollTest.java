package com.SOEN6441_DND.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Assert.*;
import org.junit.Test;

import com.SOEN6441_DND.Controller.DiceRollController;

public class DiceRollTest {
	DiceRollController diceRollController;

	@Before
	public void initialize(){
	 diceRollController = new DiceRollController(4, 6);
	}


	@Test
	public void testGetDiceRollResult(){
		Integer value = diceRollController.getDiceRollResult();
		if(value<=24){
			assertTrue(true);	
		}
		else{
			assertTrue(false);
		}
		
	}


	@Test
	public void testGetDescSortedDiceResult(){
		int[] sortedRevDiceList = diceRollController.getDescSortedDiceResult();
		assertTrue(sortedRevDiceList.getClass().isArray());	
			
		}
}
