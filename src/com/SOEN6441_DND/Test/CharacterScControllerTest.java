package com.SOEN6441_DND.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Dimension;

import org.dom4j.DocumentException;

import com.SOEN6441_DND.Controller.CharacterSceneController;
import com.SOEN6441_DND.Controller.ItemAssignViewController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;

/**
 * This test class contains test cases related to character class.
 * @author Paras Malik
 *
 */
public class CharacterScControllerTest {

	CharacterSceneController characterController;
	CharacterModel characterModel;
	
	@Before
	/**
	 * This method used initialize instances used in the test cases.
	 */
	public void initialize(){
		characterController = CharacterSceneController.getInstance();
	    characterModel = new CharacterModel();
	}
	@Test
	/**
	 * Method tests the loading of character on the map.
	 * @throws DocumentException
	 */
	public void testLoadCharacter() throws DocumentException{
		FileOperationModel operationModel = new FileOperationModel();
		characterModel = operationModel.loadCharacter("Paras");
		assertNotNull(characterModel);
	}

	@Test
	/**
	 * Method tests the movement of character on the map.
	 */
	public void testCharacterMovement(){
		String expected = "LocationUpdate";
		String actual = characterModel.characterMovecheck(new Dimension(10,10));
		assertEquals(expected, actual);;
	}

	@Test
	/**
	 * Method tests the character cannot wear more that one helmet.
	 */
	public void testCharacterHelmetWearCheck(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		String actual = assignViewController.characterHelmetWearCheck();
		String expected = "Helmet assigned";
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * Method tests the character cannot wear more that one helmet.
	 */
	public void testCharacterArmorWearCheck(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		String actual = assignViewController.characterArmorWearCheck();
		String expected = "Armor assigned";
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * Method tests the character cannot wear more that one helmet.
	 */
	public void testCharacterBeltWearCheck(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		String actual = assignViewController.characterBeltWearCheck();
		String expected = "Belt assigned";
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * Method tests the character cannot wear more that one helmet.
	 */
	public void testCharacterBootsWearCheck(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		String actual = assignViewController.characterBootsWearCheck();
		String expected = "Boots assigned";
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * Method tests the character cannot wear more that one helmet.
	 */
	public void testCharacterRingWearCheck(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		String actual = assignViewController.characterRingWearCheck();
		String expected = "Ring assigned";
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * Method tests the character cannot wear more that one helmet.
	 */
	public void testCharacterShieldWearCheck(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		String actual = assignViewController.characterShieldWearCheck();
		String expected = "Shield assigned";
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * Method tests the character cannot wear more that one helmet.
	 */
	public void testCharacterWeaponWearCheck(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		String actual = assignViewController.characterWeaponWearCheck();
		String expected = "Weapon assigned";
		assertEquals(expected, actual);
	}

	@Test
	public void testCharacterHelmetCheckAbility(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		assertNull(assignViewController.characterHelmetCheckAbility());
	}

	@Test
	public void testCharacterBeltCheckAbility(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		assertNull(assignViewController.characterBeltCheckAbility());
	}
	@Test
	public void testCharacterBootsCheckAbility(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		assertNull(assignViewController.characterBootsCheckAbility());
	}
	@Test
	public void testCharacterWeaponCheckAbility(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		assertNull(assignViewController.characterWeaponCheckAbility());
	}
	@Test
	public void testCharacterRingCheckAbility(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		assertNull(assignViewController.characterRingCheckAbility());
	}

	@Test
	public void testCharacterArmorCheckAbility(){
		ItemAssignViewController assignViewController = new ItemAssignViewController();
		assertNull(assignViewController.characterArmorCheckAbility());
	}
}
