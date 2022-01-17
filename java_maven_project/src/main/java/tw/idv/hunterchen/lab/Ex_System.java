package tw.idv.hunterchen.lab;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex_System {

	public static void showCurrency() {
			Path path = Paths.get("");
			String absPath = path.toAbsolutePath().toString();
			System.out.println(absPath);
	}

	public static void main(String[] args) {
		showCurrency();
		
		int len=40;
		String keyName = "";
		int counter=0;

		//1.取出全部環境變數、值
		Map<String, String> map = System.getenv();
		Set<String> keySet = map.keySet();

		//取出環境變數名稱、逐一取值.法1
		for(String key : keySet) {
			counter++;
			System.out.printf("%2d, %"+ len+ "s :\t %s \n", counter, key, map.get(key));
		}
		
		//取出環境變數名稱、逐一取值.法2
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
			
		}
		
		
		// 系統內建
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.home"));

	}

}
