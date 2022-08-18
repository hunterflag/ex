package tw.idv.hunterchen.lab.string;

import tw.idv.hunterchen.utility.DevTool;

public class NullAndEmptyString {

	public static void main(String[] args) {
		String nullString = null;
		String emptyString="";
		String blankString=" ";
		
//		DevTool.showMessages("nullString",  "["+nullString+"]", nullString.hashCode(), "null 就是沒有 hashcode, id");
		DevTool.showMessages("nullString",  "["+nullString+"]", "null 就是沒有 hashcode, id");
		DevTool.showMessages("emptyString", "["+emptyString+"]", ""+emptyString.hashCode());
		DevTool.showMessages("blankString", "["+blankString+"]", ""+blankString.hashCode());
	}
	
	void localMethod() {
		String nullString = null;
		String emptyString="";
		String blankString=" ";
		
		DevTool.showMessages("nullString", nullString);
	}

}
