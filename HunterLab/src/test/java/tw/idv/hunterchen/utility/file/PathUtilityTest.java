package tw.idv.hunterchen.utility.file;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tw.idv.hunterchen.utility.DevTool;


public class PathUtilityTest {
	
	@Test
	public void normalizeTest() {
		String testFqdnFileName = "\\temp/XXX.txt\\ddd/ffff";
		String winFqdnFileName = "\\temp\\XXX.txt\\ddd\\ffff";
		String linuxFqdnFileName = "/temp/XXX.txt/ddd/ffff";
	
		String resultFqdnFileName = PathUtility.normalize(testFqdnFileName);
		DevTool.showMessages(resultFqdnFileName);
		
		String osName = System.getProperty("os.name");
		switch (osName) {
			case "Windows 10":
				assertEquals(resultFqdnFileName, winFqdnFileName);
				break;
			default:	
				assertEquals(resultFqdnFileName, linuxFqdnFileName);
		}
		
	}
	
	
}
