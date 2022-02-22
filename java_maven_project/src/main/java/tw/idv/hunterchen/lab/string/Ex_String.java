package tw.idv.hunterchen.lab.string;

import java.util.Locale;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_String {

	public static void main(String[] args) {
		String str="";
		DevTool.showMessages("原字串" , str, "|");
		DevTool.showMessages("isEmpty()", "是空的?" , String.valueOf(str.isEmpty()));
		// Mac 無法使用? 是哪裡的版本差異? JRE?
//		DevTool.showMessages("isBlank()", "是空白?" , String.valueOf(str.isBlank()));

		str="tw.idv.hunterchen_txt";
		DevTool.showMessages("原字串" , str, "|");
		DevTool.showMessages("isEmpty()", "是空的?" , String.valueOf(str.isEmpty()));
//		DevTool.showMessages("isBlank()", "是空白?" , String.valueOf(str.isBlank()));
		DevTool.showMessages("startsWith()", "以xxx開頭?" , 			 String.valueOf(str.startsWith("tw")));
		DevTool.showMessages("startsWith()", "從第n位開始, 以xxx開頭?" , String.valueOf(str.startsWith("tw", 0)));
		DevTool.showMessages("endsWith()", 	 "以xxx結尾?" , 			 String.valueOf(str.endsWith(".txt")));
		DevTool.showMessages("split()", 	 "以xxx切割?" , 			 str.split("\\.")[0]);
		DevTool.showMessages("split()", 	 "以xxx切割?" , 			 str.split("[\\._]")[0], str.split("[\\._]")[3]);
		
		str="   This is a Book!  ";
		DevTool.showMessages("原字串" , str, "|");
		DevTool.showMessages("trim()", 		  "除去左右外圍空白" , str.trim());
		DevTool.showMessages("toUpperCase()", "轉大寫" , 		   str.toUpperCase());
		DevTool.showMessages("toLowerCase()", "轉小寫" , 		   str.toLowerCase());
		DevTool.showMessages("()", "" , str.toUpperCase(new Locale("中文"+str)));
	}

}
