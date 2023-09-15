package tw.idv.hunterchen.lab.string;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_indexOf_and_lastIndexOf {

	public static void main(String[] args) {
		String testStr="0.2.4.6.8.a";
		DevTool.showMessages(testStr);
		DevTool.showMessages("從頭開始找最後一個", String.valueOf(testStr.indexOf(".")));
		DevTool.showMessages("從0開始找最後一個", String.valueOf(testStr.indexOf(".", 0)));
		DevTool.showMessages(String.valueOf(testStr.indexOf(".", 1)));
		DevTool.showMessages(String.valueOf(testStr.indexOf(".", 2)));

		DevTool.showMessages("從尾開始、倒著找最到一個", String.valueOf(testStr.lastIndexOf(".")));
		DevTool.showMessages("從末開始、倒著找最到一個", String.valueOf(testStr.lastIndexOf(".", testStr.length()-1)));
		DevTool.showMessages(String.valueOf(testStr.lastIndexOf(".", 1)));
//		DevTool.showMessages(String.valueOf(testStr.lastIndexOf(".", -1)));
		DevTool.showMessages(String.valueOf(testStr.lastIndexOf(".", 2)));
	}

}
