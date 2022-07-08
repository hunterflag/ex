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

		String unicodeStr = "567四五六";
		DevTool.showMessages(""+unicodeStr.length());
		for(int index=0; index < unicodeStr.length(); index++) {
			DevTool.showMessages(""+index, ""+unicodeStr.charAt(index));
			DevTool.showMessages(""+index, ""+unicodeStr.codePointAt(index));
		}
		DevTool.showMessages(unicodeStr,unicodeStr,"內容、長度都相同"+unicodeStr.compareTo(unicodeStr));
		DevTool.showMessages(unicodeStr,"0","內容相同、原字串長度>比較字串長度"+unicodeStr.compareTo("0"));
		DevTool.showMessages(unicodeStr,"012","內容相同、原字串長度>比較字串長度"+unicodeStr.compareTo("012"));
		DevTool.showMessages(unicodeStr,unicodeStr+"七","內容相同、原字串長度<比較字串長度"+unicodeStr.compareTo(unicodeStr+"七"));
		DevTool.showMessages(unicodeStr,"1","有不同, 碼位差是 0-1 ="+unicodeStr.compareTo("1"));
		DevTool.showMessages(unicodeStr,"782","有不同, 碼位差是 1-2 = "+unicodeStr.compareTo("782"));
		DevTool.showMessages(unicodeStr,"12","有不同, 碼位差是 0-1 = "+unicodeStr.compareTo("12"));
		DevTool.showMessages(unicodeStr,"2","有不同, 碼位差是 0-2 = "+unicodeStr.compareTo("2"));
		DevTool.showMessages(unicodeStr,"六","有不同, 碼位差是 0-六 = "+unicodeStr.compareTo("六"));
	}

}
