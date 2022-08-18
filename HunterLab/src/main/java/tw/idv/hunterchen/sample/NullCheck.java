package tw.idv.hunterchen.sample;

import java.io.IOError;
import java.io.IOException;

public class NullCheck {

	public void seitch_null() {
		String value=null;
		switch (value) {		// 判斷式 不能為 null
		case "str1": break;
		case "str2": break;
		default: break;	
		}
	}
	
	
	public void string_null(String[] args) {
		
		String str=null;		
		
		str = (str==null) ? "defaultValue" : str;
		try {
			
			if (str==null || "".equals(str)) {
//				throw NullPointerException;
			}
//		} 
//		catch(IOException ex) {
		
		} finally {
			
		}
	}
	
	public static void main(String[] args) {
		NullCheck nullCheck = new NullCheck();
		nullCheck.seitch_null();
		

	}

}
