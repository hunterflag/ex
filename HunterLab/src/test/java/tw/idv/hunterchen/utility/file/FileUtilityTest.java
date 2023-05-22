package tw.idv.hunterchen.utility.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.Test;

import tw.idv.hunterchen.utility.DevTool;


public class FileUtilityTest {
	static String fileName = "d:\\temp\\XXX.txt";
	
	
	@BeforeClass
	public static void beforeClass() {
		fileName = "d:\\temp\\files\\newDir2\\";
	}
	
	@Test
	public void cleanFolderTest() {
		String basePath = "d:\\temp\\files\\newDir2\\";
		
		try (Stream<Path> sp = Files.list(Paths.get(basePath))){
//			Stream<Path> sp = Files.list(Paths.get(basePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertFalse(FileUtility.forceRemoveFolder(null));
		assertFalse(FileUtility.forceRemoveFolder(""));
		assertFalse(FileUtility.forceRemoveFolder(basePath+"ddd"));
		assertFalse(FileUtility.forceRemoveFolder(basePath+"sample.json"));
//		assertTrue(FileUtility.cleanFolder(basePath));
	}
	
	
//	@Test
	public void getMainN_test() {
		assertEquals("XXX", FileUtility.getMainName(fileName));
		assertEquals("txt", FileUtility.getExtendName(fileName));
		
//		assertTrue("sssss", FileUtility.renameOrMove(fileName, "d:\\temp\\YYY.ccc"));
	}
}
