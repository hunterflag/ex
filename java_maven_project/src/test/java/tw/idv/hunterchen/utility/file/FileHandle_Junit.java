package tw.idv.hunterchen.utility.file;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FileHandle_Junit {
	@Test
	public void getMainN_test() {
		String fileName = "d:\\temp\\XXX.txt";
//		assertEquals("XXX", FileUtility.getMainName(fileName));
//		assertEquals("txt", FileUtility.getExtendName(fileName));
		
		assertTrue(FileUtility.renameOrMove(fileName, "d:\\temp\\YYY.ccc"));
	}
}
