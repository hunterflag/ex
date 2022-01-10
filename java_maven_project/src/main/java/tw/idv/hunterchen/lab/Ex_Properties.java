package tw.idv.hunterchen.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Ex_Properties {

	public static void main(String[] args) throws IOException {
		File f = new File("Ex_Properties.properties");
		FileInputStream fis = new FileInputStream(f);
//		BufferedReader bufferedReader = new BufferedReader(new FileReader());
		Properties properties = new Properties();
		properties.load(fis);
		
		System.out.println(properties.getProperty("demo.chinese"));
		
	}
}

