package com.SOEN6441_DND.Test;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.DefaultListModel;

import org.junit.Before;
import org.junit.Test;

import com.SOEN6441_DND.Controller.CampaignViewController;
import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.FileOperationModel;

/**
 * This test class contains test cases related to campaign.
 * @author Paras Malik
 *
 */
public class CampaignControllerTest {

	CampaignViewController campaignController;
	FileOperationModel ioModel;
	@Before
	public void initialize(){
		campaignController = new CampaignViewController();
		ioModel=new FileOperationModel();
	}

	@Test
	public void testOpenCampaignFile(){
		CampaignModel campaignModel=ioModel.readCampaignFile(new File("campaign/hello.xml"));
		assertNotNull(campaignModel);
	
	}

	@Test
	public void testAllCampaignFileLoad(){
		DefaultListModel list=ioModel.getAllFolderFile("campaign/");
		assertNotNull(list);
		
		
	}

	@Test
	public void testReadCampaignFile(){
		FileOperationModel fileOperationModel = new FileOperationModel();
		File file = new File("campaign/main.xml");
		CampaignModel campaignModel = fileOperationModel.readCampaignFile(file);
		assertNotNull(campaignModel);
	}
}
