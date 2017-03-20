package com.SOEN6441_DND.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.SOEN6441_DND.Controller.CharacterSceneController;

public class CharacterScControllerTest {

	CharacterSceneController characterController;
	
	@Before
	public void initialize(){
		characterController = CharacterSceneController.getInstance();
	}

	@Test
	public void testModifierCalculator(){
		int score = 13;
		int output = characterController.modifierCalculator(score);
		int expected = 1;
		assertEquals(expected, output);
	}
}
