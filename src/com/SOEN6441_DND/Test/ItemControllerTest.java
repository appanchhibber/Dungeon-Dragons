package com.SOEN6441_DND.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;

public class ItemControllerTest {
	FileOperationModel fileOperationModel;
	@Before
	public void initialize(){
		 fileOperationModel = new FileOperationModel();
	}


	@Test
	public void testReadItemSaveFile(){
		File file = new File("itemSave/Armor.xml");
		ItemModel model = fileOperationModel.readItemSaveFile(file);
		assertNotNull(model);
	}

	@Test
	public void testReadSaveItemFile(){
		File file = new File("itemSave/Armor.xml");
		Map<String, ArrayList<String>> obj = fileOperationModel.readSaveItemFile(file);
		assertNotNull(obj);
	}

	@Test
	public void readItemFile(){
		File file = new File("itemSave/Belt.xml");
		ItemModel itemModel = fileOperationModel.readItemFile(file);
		assertNotNull(itemModel);
	}
}
