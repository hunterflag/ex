package tw.idv.hunterchen.utility.properties;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.Properties;

import org.junit.Test;

import tw.idv.hunterchen.utility.DevTool;

public class PropertiesUtilityTest {

//	@Test
	public void getPropertiesFromClassPathTest() {
		Properties props = PropertiesUtility.getPropertiesFromClassPath("sample.properties");
		assertEquals("dev", props.getProperty("app.mode"));
		assertEquals("Hunter Chen", props.getProperty("app.info.creator.name"));
		PropertiesUtility.showAllProperties(props);
	}

	@Test
	public void getPropertiesFromFilePathTest() {
//		Properties props = PropertiesUtility.getPropertiesFromFilePath("/Users/chenhuanzhang/dev/source/java/ex/java_maven_project/target/test-classes/sample.properties"); //絕對路徑
//		Properties props = PropertiesUtility.getPropertiesFromFilePath("~/dev/source/java/ex/java_maven_project/target/test-classes/sample.properties");//想對路徑, 但沒有 ~
		DevTool.showMessages(String.valueOf(Paths.get(".").toAbsolutePath()));
		Properties props = PropertiesUtility.getPropertiesFromFilePath("./target/test-classes/sample.properties");	//『當前資料夾』指『專案資料夾
		if (props != null) {
			assertEquals("dev", props.getProperty("app.mode"));
			assertEquals("Hunter Chen", props.getProperty("app.info.creator.name"));
			PropertiesUtility.showAllProperties(props);
		} else {
		DevTool.showMessages("NULL properties");
		}
	}

//	@Test
	public void lootGetPropertiesFromClassPathTest() {
		PropertiesUtilityTest test = new PropertiesUtilityTest();
		for (int i = 0; i < 1000; i++) {
			DevTool.showMessages("loop counter", i + 1 + "");
			test.getPropertiesFromClassPathTest();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
