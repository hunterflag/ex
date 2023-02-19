package tw.idv.hunterchen.lab.string;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Null_And_EmptyString {

	public static void main(String[] args) {
		String nullString = null;
		String emptyString="";
		String blankString=" ";
		
//		DevTool.showMessages("nullString",  "["+nullString+"]", nullString.hashCode(), "null 就是沒有 hashcode, id");
		DevTool.showMessages("nullString",  "["+nullString+"]", "null 就是沒有 hashcode, id");
		DevTool.showMessages("emptyString", "["+emptyString+"]", ""+emptyString.hashCode());
		DevTool.showMessages("blankString", "["+blankString+"]", ""+blankString.hashCode());
		
		System.out.println("".equals(""));		//true
		System.out.println(null == null);		// true
		System.out.println("".equals(null));	//false		
		/* Syntax error		
		System.out.println(null.equals(""));	//Cannot invoke equals(String) on the primitive type null
		*/
		
		/* Runtime error
		String testString=null;
		System.out.println(testString.equals(null));	// false: 看起來是對, 但執行是錯, 因為 null 沒有方法可以調用 
		System.out.println(testString.equals(""));		// false: 看起來是對, 但執行是錯, 因為 null 沒有方法可以調用 
		*/

	}
	
	void localMethod() {
		String nullString = null;
		String emptyString="";
		String blankString=" ";
		
		DevTool.showMessages("nullString", nullString);
	}

}
