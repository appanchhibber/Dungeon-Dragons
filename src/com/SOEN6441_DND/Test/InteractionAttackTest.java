package com.SOEN6441_DND.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.SOEN6441_DND.Model.CharacterModel;

import Strategy.HumanStrategy;

public class InteractionAttackTest {

	HumanStrategy strategy;
	
	@Before
	public void initialize(){
		strategy = new HumanStrategy();
	}

	@Test
	public void testCheckAttackHit(){
		CharacterModel characterModel = new CharacterModel();
		String expected = "no attack";
		String actual;
		int diceResult = strategy.rollDice();
		characterModel.setArmorClass(2);
		int armorClassTest = characterModel.getArmorClass();
		if(armorClassTest<diceResult){
			actual = "no attack";
			assertEquals(expected, actual);
		}
		else{
		actual = "attack successful";
		assertEquals(expected, actual);
		}
	}
}
