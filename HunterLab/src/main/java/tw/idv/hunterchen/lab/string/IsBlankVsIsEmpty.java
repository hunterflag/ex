package tw.idv.hunterchen.lab.string;

import tw.idv.hunterchen.utility.DevTool;

public class IsBlankVsIsEmpty {
	/*
	 * isEmpty(): true = length=0  ""
	 * isBlank(): true = length=0  "" 或 white space 都算  java 11 才有
	 */
	public static void main(String[] args) {
		String[] list={"", "  ", "anything", "\t"};
		for (String string : list) {
			DevTool.showMessages("["+string+"]", 
//						"isBlank()="+String.valueOf(string.isBlank()),
						""+string.length(), 
						"isEmpty()="+String.valueOf(string.isEmpty())
			); 
		}
	}
}
