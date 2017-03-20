package com.SOEN6441_DND.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CampaignControllerTest.class,
				CharacterScControllerTest.class,
				ControllerTest.class,
				DiceRollTest.class,
				FileIOTest.class,
				ItemControllerTest.class,
				MapControllerTest.class})
public class DnDTestSuite {

}
