package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.logging.Logger;

import org.junit.Test;

public class ShowTool_Junit { 
	Logger logger = Logger.getLogger("dd");
	@Test
	public void showAllField_junit() {
//		assertTrue(ShowTool.showAllFields(123L));
//		assertTrue(ShowTool.showAllFields(logger));
		
		File file = new File("");
		assertTrue(ShowTool.showAllFields(file));

//		assertTrue(ShowTool.showAllFields(file));
	}
}
