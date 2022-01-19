package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit_Sample { 
	Logger logger = Logger.getLogger("dd");
	@Before
	public void beforeEveryTest() {
		System.out.println("====start====");
	}
	
	@After
	public void afterEveryTest() {
		System.out.println("====after====");
	}
	
	@Test
	public void showAllField_junit() {
//		assertTrue(ShowTool.showAllFields(123L));
//		assertTrue(ShowTool.showAllFields(logger));
		
//		File file = new File("");
//		assertTrue(ShowTool.showAllFields(file));


		
//		assertTrue(ShowTool.showAllFields(file));
	}
	
	@Test
	public void showSystem_Junit() {
		ShowTool.showSystem();
	}
}
