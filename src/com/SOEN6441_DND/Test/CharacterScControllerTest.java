package com.SOEN6441_DND.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.dom4j.DocumentException;

import com.SOEN6441_DND.Controller.CharacterSceneController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;

/**
 * This test class contains test cases related to character class.
 * @author Paras Malik
 *
 */
public class CharacterScControllerTest {

	CharacterSceneController characterController;
	
	@Before
	public void initialize(){
		characterController = CharacterSceneController.getInstance();
	}
	@Test
	public void testLoadCharacter() throws DocumentException{
		CharacterModel characterModel = new CharacterModel();
		FileOperationModel operationModel = new FileOperationModel();
		characterModel = operationModel.loadCharacter("Paras");
		assertNotNull(characterModel);
	}
}
