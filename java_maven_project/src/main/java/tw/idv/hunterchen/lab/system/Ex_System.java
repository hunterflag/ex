package tw.idv.hunterchen.lab.system;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import tw.idv.hunterchen.utility.StringTool;
import tw.idv.hunterchen.utility.DevTool;

public class Ex_System {
	private int len=40;
	private int counter=0;
	
	//取得當前路徑
	public String getCurrentPath() {
		String result="";
		//法.a
		result=System.getProperty("user.dir");
		
		//法.b
//		result=Paths.get("").toAbsolutePath().toString();
		//法.c
//		try {
//			result = new File(".").getCanonicalPath();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return result;
		
	}
	
	public void showEnvironmentVariables() {
		DevTool.showMessages("系統環境變數", StringTool.genDivider(40));
		
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
		/*1.a.法
		 * 
		counter=0;
		DevTool.showMessages("系統內建特性(依原排序)", StringTool.genDivider(40));
		for (String key : properties.stringPropertyNames()) {
			counter++;
			System.out.printf("%2d, %-"+ len+ "s :\t %s \n"
					, counter
					, key
					, properties.getProperty(key)
					);
		}
		 */
		
		/* 1.b.法
		 * 
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
		 */
		
		//1.c.依key排序
		DevTool.showMessages("系統內建特性(依key字母排序)", StringTool.genDivider(40));
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
	
	public void showTime() throws InterruptedException {
		Long startTime=0L;
		Long endTime=0L;
		Long diffTime=0L;
		
		DevTool.showMessages("取得當前日期、時間(系統、毫秒)", StringTool.genDivider(40));
		startTime=System.currentTimeMillis();
		Thread.sleep(1000);
		endTime=System.currentTimeMillis();
		diffTime=endTime-startTime;
		DevTool.showMessages("1970-01-01 ms");
		DevTool.showMessages("currentTimeMillis()", String.valueOf(new DecimalFormat().format(startTime)));
		DevTool.showMessages("currentTimeMillis()", String.valueOf(new DecimalFormat().format(endTime)));
		DevTool.showMessages("秒差(ms)", String.valueOf(new DecimalFormat().format(diffTime)));
		
		DevTool.showMessages("取得當前日期、時間(人類)", StringTool.genDivider(40));
		DevTool.showMessages("java.sql.Timestamp", String.valueOf(new java.sql.Timestamp(startTime)));
		DevTool.showMessages("java.sql.Time", String.valueOf(new java.sql.Time(startTime)));
		DevTool.showMessages("java.sql.Date", String.valueOf(new java.sql.Date(startTime)));
		DevTool.showMessages("java.util.Date", String.valueOf(new java.util.Date(startTime)));
		DevTool.showMessages("java.util.Date", String.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new java.util.Date(startTime))));
		
		DevTool.showMessages("取得當前日期、時間(系統、奈秒)", StringTool.genDivider(40));
		startTime=System.nanoTime();
		Thread.sleep(1000);
		endTime=System.nanoTime();
		diffTime=endTime-startTime;
		DevTool.showMessages("nanoTime()", String.valueOf(new DecimalFormat().format(startTime)));
		DevTool.showMessages("nanoTime()", String.valueOf(new DecimalFormat().format(endTime)));
		DevTool.showMessages("秒差(ns)", String.valueOf(new DecimalFormat().format(diffTime)));

		DevTool.showMessages("奈秒級用在科學的精密時間差, 不適合當作日期", StringTool.genDivider(40));
		DevTool.showMessages("java.sql.Timestamp", String.valueOf(new java.sql.Timestamp(startTime)));
		DevTool.showMessages("java.sql.Time", String.valueOf(new java.sql.Time(startTime)));
		DevTool.showMessages("java.sql.Date", String.valueOf(new java.sql.Date(startTime)));
		DevTool.showMessages("java.util.Date", String.valueOf(new java.util.Date(startTime)));
		DevTool.showMessages("java.util.Date", String.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new java.util.Date(startTime))));
	}
	
	public static void main(String[] args) throws InterruptedException {
		Ex_System system = new Ex_System();
		

		system.showTime();
		DevTool.showMessages("currentPath", system.getCurrentPath());
		DevTool.showMessages("currentPath", system.getCurrentPath());
		system.showEnvironmentVariables();
		
		
		
		// 系統內建
		system.showSystemProperties();
//		System.out.println(System.getProperty("user.name"));
//		System.out.println(System.getProperty("java.home"));
//		System.out.println(System.getProperty("os.name"));
//		System.out.println(System.getProperty("os.version"));

	}

}
