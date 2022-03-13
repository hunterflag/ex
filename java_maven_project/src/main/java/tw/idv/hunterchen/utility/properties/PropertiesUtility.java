package tw.idv.hunterchen.utility.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import tw.idv.hunterchen.utility.DevTool;


public class PropertiesUtility {
	
	public static void showAllProperties(Properties props) {
		Set<String> propertyNames = props.stringPropertyNames();
		for (String name : propertyNames) {
			DevTool.showMessages(name, props.getProperty(name, "NO VALUE"));
		}
	}
	

	public static Properties getPropertiesFromClassPath(String file) {
		Properties properties=null;
		try {
			InputStream inputStream = PropertiesUtility.class.getClassLoader().getResourceAsStream(file);
			properties = new Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static Properties getPropertiesFromFilePath(String file) {
		Properties properties=null;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			properties = new Properties();
			properties.load(bufferedReader);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
		}
		return properties;
	}
	
	
}
