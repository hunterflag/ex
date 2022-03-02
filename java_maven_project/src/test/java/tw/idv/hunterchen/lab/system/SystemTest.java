package tw.idv.hunterchen.lab.system;

import java.util.Map;
import java.util.Properties;

import org.junit.Test;

import tw.idv.hunterchen.utility.properties.PropertiesUtility;

public class SystemTest {
	@Test
	public void compare_with_getEnv_and_getProperties() {
		Map<String, String> env = System.getenv();
		
		Properties props = System.getProperties();
		PropertiesUtility.showAllProperties(props);
	}
}
