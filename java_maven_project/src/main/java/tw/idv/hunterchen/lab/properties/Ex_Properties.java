package tw.idv.hunterchen.lab.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Ex_Properties {

	public static void main(String[] args) throws IOException {
		
		
		/* ResourceBundle 的路徑寫法
		 * 1.不能寫副檔名 (.properties)
		 * 2.相對於classpath
		 */
//		ResourceBundle resource = ResourceBundle.getBundle("tw/idv/hunterchen/lab/Ex");
		ResourceBundle resource = ResourceBundle.getBundle("tw/idv/hunterchen/lab/properties/message");
		System.out.println( resource.getString("demo.string"));
		
		
		/*
		//		File f = new File("Ex_Properties.properties");
		File f = new File("/tw/idv/hunterchen/lab/Ex.properties");
		FileInputStream fis = new FileInputStream(f);
//		BufferedReader bufferedReader = new BufferedReader(new FileReader());
		Properties properties = new Properties();
		properties.load(fis);
		
		System.out.println(properties.getProperty("demo.chinese"));
		*/
	}

}
