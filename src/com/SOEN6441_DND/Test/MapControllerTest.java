package com.SOEN6441_DND.Test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;

/**
 * This class contains test cases related to map functionality.
 * @author Paras Malik
 *
 */
public class MapControllerTest {
	
	FileOperationModel operationModel;
	@Before
	public void intialize(){
		operationModel = new FileOperationModel();
	}

	@Test
	public void testReadMapFile(){
		File file = new File("maps/Main Map.xml");
		MapModel mapModel = operationModel.readMapFile(file);
		assertNotNull(mapModel);
		
	}
}
