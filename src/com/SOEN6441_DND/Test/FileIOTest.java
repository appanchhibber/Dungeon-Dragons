package com.SOEN6441_DND.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import org.junit.Before;
import org.junit.Test;

import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Views.CharacterScene;

public class FileIOTest {
	FileOperationModel fileIo;
	
	@Before
	public void initialize(){
	 fileIo = new FileOperationModel();
	}
	
	@Test
	public void testSetCharacterFile(){
		
		File file1Expected = new File("characters/Punit.xml");
		File file2Output;
		file2Output = fileIo.setCharacterFile("Punit");
		assertEquals(file1Expected, file2Output);
		
	}


	@Test
	public void testSetFile(){
		File file1Expected = new File("items/Armor.xml");
		File file2Output;
		file2Output = fileIo.setFile("Armor");
		assertEquals(file1Expected, file2Output);
		
	}
	
	@Test
	public void testGetCharacterImagePath(){
		String expected = "image/Human.jpg";
		String output = fileIo.getCharacterImagePath("Paras");
		assertEquals(expected, output);
		
	}

	@Test
	public void testCreateCampaignFile(){
		String expected = "Campaign Saved Successfully";
		File file = new File("campaign/mainmapfile.xml");
		ArrayList list = new ArrayList();
		list.add("k");
		String output = fileIo.createCampaignFile(file, list);
		assertEquals(expected, output);
		
	}

	@Test
	public void testReturnFilesFolder(){
		DefaultListModel defaultListModel;
		defaultListModel = fileIo.getAllFolderFile("itemSave");

		assertNotNull(defaultListModel);
	}
}
