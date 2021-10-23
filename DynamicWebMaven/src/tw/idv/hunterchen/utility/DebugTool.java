package tw.idv.hunterchen.utility;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @param
 * n: 流水號 
 * t: (+)時間 
 * @since 2021-10-18
 * @author chenhuanzhang
 *
 */
public class DebugTool {
	private static int serialNo=0;
	public static void showMessageWithSerialNo(String message) {
		message = (message != null ? message : "未傳入訊息"); 
		String result= "\t-->[" + ++serialNo + "]: " + message ;
		System.out.println(result);
	}

	public static void showMessage() {
		showMessage(null, null, null);
	}
	public static void showMessage(String message) {
		showMessage(null, message, null);
	}
	public static void showMessage(Integer id, String message) {
		showMessage(id.toString(), message, null);
	}
	public static void showMessage(String id, String message) {
		showMessage(id, message, null);
	}
	public static void showMessage(String id, String message, String decorator) {
		id = (id != null ? id : "");
		message = (message != null ? message : "未傳入訊息");
		decorator = (decorator != null ? decorator : "n").toLowerCase();
		
		String regex="[nM]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(decorator);
		
		
		String strStamp=null;
		switch(decorator) {
		case "n":
			strStamp = String.valueOf(++serialNo);	
			break;
		case "t": 
			strStamp = String.valueOf(new Date());	
			break;
		}
		if(id != "") strStamp=id;
		String result= "\t-->[" + strStamp + "]: " + message ;

		System.out.println(result);
	}

	
}
