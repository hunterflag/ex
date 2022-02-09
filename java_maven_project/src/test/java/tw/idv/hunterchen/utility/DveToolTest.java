package tw.idv.hunterchen.utility;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DveToolTest {
	private static final Logger logger = Logger.getLogger("dd");
	@Before
	public void beforeEveryTest() {
		logger.info("====start====");
	}
	
	@After
	public void afterEveryTest() {
		DevTool.showMessages("====after====");
	}
	
	@Test
	public void showAllField_junit() {
//		assertTrue(ShowTool.showAllFields(123L));
//		assertTrue(ShowTool.showAllFields(logger));
		
		File file = new File("");
		assertTrue(DevTool.showAllFields(file));


		
//		assertTrue(ShowTool.showAllFields(file));
	}
	
	@Test
	public void showSystem_Junit() {
		DevTool.showSystem();
	}
}
