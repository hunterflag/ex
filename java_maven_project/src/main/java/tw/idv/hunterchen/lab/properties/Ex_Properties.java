package tw.idv.hunterchen.lab.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Properties {
	
	// 顯示所有的
	public void showAllProperties(Properties props) {
		Set<String> propertyNames = props.stringPropertyNames();
		for (String name : propertyNames) {
			DevTool.showMessages(name, props.getProperty(name, "NO VALUE"));
		}
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		Ex_Properties ex_Properties = new Ex_Properties();	
		Properties props = System.getProperties();
		ex_Properties.showAllProperties(props);
		// File f = new File("Ex_Properties.properties");
//		File f = new File("\\tw\\idv\\hunterchen\\lab\\properties\\Ex_Properties.properties");
//		File f = new File("/dev.source//test/src/main/resources/tw/idv/hunterchen/lab/properties/Ex_Properties.properties");
//		File f = new File("/tw/idv/hunterchen/lab/properties/Ex_Properties.properties");
//		File f = new File("tw/idv/hunterchen/lab/properties/Ex_Properties.properties");

		/*
		 * File的檔案位置是 System Path
		 */
//		File f = new File("d:/temp/Ex_Properties.properties");
//		File f = new File("/temp/Ex_Properties.properties");
		// 執行時的 path (就是該專案目錄)
		String currentFolder = Paths.get(".").toAbsolutePath().getParent().toString();
		DevTool.showMessages(currentFolder);
		// 該專案的classpath位置 (但部署時又該在哪裡？)
		String classPath = currentFolder + "/target/classes/";
		// 在執行時, properties檔的部署位置
		String filePath = classPath + "/tw/idv/hunterchen/lab/properties/Ex_Properties.properties";
		File file = new File(filePath);
		
		/* 在執行時, 原始 properties檔在專案的位置
		 * 測試時, 原始檔同時在此處, 所以也可取得檔案, 容易被誤以為正確,  
		 * 實則不然, 因為部署後原始環境並不在, 執行時就會找不到而出錯 
		 */
//		String filePath = "/src/main/resources/tw/idv/hunterchen/lab/properties/Ex_Properties.properties";
//		File f = new File(currentFolder+"/"+filePath);
//				"D:/dev.source/lab/project/lab/java_maven_project/src/main/resources/tw/idv/hunterchen/lab/properties/Ex_Properties.properties");

		FileInputStream fis = new FileInputStream(file);
//		BufferedReader bufferedReader = new BufferedReader(new FileReader());
		Properties properties = new Properties();
		// 設定 property.單個鍵值組
		properties.put("keyName", "keyValue");
		// 設定 property.從檔案輸入多個鍵值組
		properties.load(fis);

		// 取出鍵值
		System.out.println(properties.getProperty("demo.chinese"));
	}

}
