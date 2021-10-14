package tw.idv.hunterchen.utility;

import java.util.Date;

public class DebugTool {
	public static void showMessage(String message) {
		message = (message != null ? message : "未傳入訊息"); 
		String result= "\t-->[" + new Date() + "]: " + message ;
		System.out.println(result);
	}
	public static void showMessage() {
		showMessage(null);
	}
	
}
