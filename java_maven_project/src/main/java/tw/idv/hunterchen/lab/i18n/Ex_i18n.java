package tw.idv.hunterchen.lab.i18n;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import tw.idv.hunterchen.utility.ShowTool;
public class Ex_i18n {
	
	public static void main(String[] args) throws IOException {
		// 準備 .properties 檔
		// 設定要使用的區域
//		Locale locale = new Locale("en", "US");
//		System.out.println(locale.getDisplayLanguage() + locale.getCountry());

		/* ResourceBundle 的路徑寫法
		 * 1.不能寫副檔名 (.properties)
		 * 2.相對於classpath root; 不是 class所在的 path
		 */
//		ResourceBundle resource = ResourceBundle.getBundle("message");	// 這是 classpath root, 不是 class所在的 path
		ResourceBundle resource = ResourceBundle.getBundle("tw/idv/hunterchen/lab/i18n/message");
//		ResourceBundle resource = ResourceBundle.getBundle("tw/idv/hunterchen/lab/i18n/message", locale);
		//目前的Local
		Locale defaultLocale = Locale.getDefault();
		ShowTool.showAllFields(defaultLocale);
		
		System.out.println( resource.getString("demo.language"));

		//在 locale 中沒有的 key, 上溯至 base 檔找
		System.out.println( resource.getString("demo.lang"));
		
		
		//在 locale 中沒有的 key, 上溯至 base 檔也找不到, 就會出現 MissingResourceExpection, 不是 null
		try{
			// 此 if 其實無效, 因為第一次取值就產生 ex
			if (resource.getString("noExist") != null) {
				System.out.println( resource.getString("noExist"));
			}
		
		} catch(MissingResourceException ex) {
			System.out.println("在 locale 中沒有的 key, 上溯至 base 檔也找不到, 就會出現 MissingResourceExpection, 不是 null");
			
		}
	}

}
