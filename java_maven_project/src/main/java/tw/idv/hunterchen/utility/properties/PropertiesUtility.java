package tw.idv.hunterchen.utility.properties;

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
	
}
