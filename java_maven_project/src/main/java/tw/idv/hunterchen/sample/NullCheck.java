package tw.idv.hunterchen.sample;

import java.io.IOError;
import java.io.IOException;

public class NullCheck {

	public static void main(String[] args) {
		
		String str=null;		
		
		str = (str==null) ? "defaultValue" : str;
		try {
			
			if (str==null || "".equals(str)) {
//				throw NullPointerException;
			}
		} 
//		catch(IOException ex) {
			
//		}
		finally {
			
		}
		

	}

}
