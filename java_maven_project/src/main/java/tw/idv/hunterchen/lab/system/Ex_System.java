package tw.idv.hunterchen.lab.system;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex_System {
	private int len=40;
	private int counter=0;

	public void showCurrency() {
			Path path = Paths.get("");
			String absPath = path.toAbsolutePath().toString();
			System.out.println(absPath);
	}
	
	public void showEnvironmentVariables() {
		String keyName = "";
		
		//1.取出全部環境變數、值
		Map<String, String> map = System.getenv();
		Set<String> keySet = map.keySet();
		
		//2.取出環境變數名稱、逐一取值
		/* 2.a.法
		 * 
		 */
		counter=0;
		for(String key : keySet) {
			counter++;
			System.out.printf("%2d, %"+ len+ "s :\t %s \n"
					, counter, key
					, map.get(key)
				);
		}
		
		/* 2.b.法 
		counter=0;
		Iterator<String> ite = keySet.iterator();
		while(ite.hasNext()) {
			counter++;
			keyName = ite.next();
			System.out.printf("%2d, %"+ len+ "s :\t %s \n"
					, counter
					, keyName
					, map.get(keyName)
				);
		}//end fo while
		*/

	}//end of method()
	
	public void showSystemProperties() {
		Properties properties = System.getProperties();
		
		//1.遍歷
		//1.a.法
		counter=0;
		for (String key : properties.stringPropertyNames()) {
			counter++;
			System.out.printf("%2d, %-"+ len+ "s :\t %s \n"
					, counter
					, key
					, properties.getProperty(key)
					);
		}
		
		//1.b.法
		Enumeration<Object> keys = properties.keys();
		counter=0;
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = properties.getProperty(key);
			counter++;
			System.out.printf("%2d, %-"+ len+ "s :\t %s \n"
					, counter
					, key
					, value
					);
			
		}
		
		//1.c.依key排序
		SortedMap sortedMap = new TreeMap(properties);
		Set keySet = sortedMap.keySet();
		Iterator iterator = keySet.iterator();
		counter=0;
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = properties.getProperty(key);
			counter++;
			System.out.printf("%2d, %-"+ len+ "s :\t %s \n"
					, counter
					, key
					, value
					);
			
		}
		
	
	}
	
	
	public static void main(String[] args) {
		Ex_System system = new Ex_System();
	
		system.showCurrency();
		system.showEnvironmentVariables();
		system.showSystemProperties();
		
		
		
		// 系統內建
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));

	}

}
