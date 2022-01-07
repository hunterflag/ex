package tw.idv.hunterchen.lab.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Ex_Properties {

	public static void main(String[] args) throws IOException {
		
		//		File f = new File("Ex_Properties.properties");
//		File f = new File("\\tw\\idv\\hunterchen\\lab\\properties\\Ex_Properties.properties");
//		File f = new File("/dev.source//test/src/main/resources/tw/idv/hunterchen/lab/properties/Ex_Properties.properties");
//		File f = new File("/tw/idv/hunterchen/lab/properties/Ex_Properties.properties");
//		File f = new File("tw/idv/hunterchen/lab/properties/Ex_Properties.properties");

		/*
		 * File的檔案位置是 System Path
		 */
//		File f = new File("d:/temp/Ex_Properties.properties");
//		File f = new File("/temp/Ex_Properties.properties");
		File f = new File("D:/dev.source/lab/project/lab/java_maven_project/src/main/resources/tw/idv/hunterchen/lab/properties/Ex_Properties.properties");

		FileInputStream fis = new FileInputStream(f);
//		BufferedReader bufferedReader = new BufferedReader(new FileReader());
		Properties properties = new Properties();
		properties.load(fis);
		
		System.out.println(properties.getProperty("demo.chinese"));
	}

}
