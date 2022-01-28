package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SftpClient_JUnit { 
	Logger logger = Logger.getLogger(this.getClass().getName());
	static final String mDivider = StringTool.genDivider();
	
	@BeforeClass
	public static void beforeClass() {
		ShowTool.showMessages(mDivider, "before class...", mDivider);
		//TODO
		ShowTool.showMessages(mDivider, "class start...", mDivider);
	}
	@Test
	public void xxx_ut() {
		ShowTool.showMessages(mDivider, "test start...", mDivider);
//		assertEquals("expect", "result");
		assertNotEquals("expect", "result");
		assertTrue(true);
		assertFalse(false);
		ShowTool.showMessages(mDivider, "test end", mDivider);
	}
	
	@Test
	public void showSystem_ut() {
		ShowTool.showSystem();
	}
	
	@Before
	public void beforeEveryTest() {
		ShowTool.showMessages(mDivider, "before test...", mDivider);
	}
	
	@After
	public void afterEveryTest() {
		ShowTool.showMessages(mDivider, "after test...", mDivider);
	}

	
	@AfterClass
	public static void afterClass() {
		ShowTool.showMessages(mDivider, "class end and after class...", mDivider);
		ShowTool.showMessages(mDivider, "after class", mDivider);
	}
}
