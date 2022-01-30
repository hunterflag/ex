package tw.idv.hunterchen.utility.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class FileHandleTest {
	static String fileName = "d:\\temp\\XXX.txt";
	
	
	@BeforeClass
	public static void beforeClass() {
		fileName = "d:\\temp\\XXX.txt";
	}
	
	@Test
	public void getMainN_test() {
		assertEquals("XXX", FileUtility.getMainName(fileName));
		assertEquals("txt", FileUtility.getExtendName(fileName));
		
//		assertTrue("sssss", FileUtility.renameOrMove(fileName, "d:\\temp\\YYY.ccc"));
	}
}
