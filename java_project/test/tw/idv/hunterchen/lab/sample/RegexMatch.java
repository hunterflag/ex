package tw.idv.hunterchen.lab.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import tw.idv.hunterchen.utility.DebugTool;

public class RegexMatch {
	@Test
	public void testRegex() {
		DebugTool.showMessage("...Start...");
		String regex=".*aa.*";
		String regex1="abc";
		String testStr1="ABCa aabcaac";
		String testStr2="zxca ababcAc";
		// 檢查有沒有 "aa"
		DebugTool.showMessage(String.valueOf(testStr1.contains("aa")));
		DebugTool.showMessage(String.valueOf(testStr1.matches(regex)));
		DebugTool.showMessage(String.valueOf(Pattern.matches(regex, testStr1)));
		
		/*
		 * 1.以 regex 建立 匹配式
		 * 2.以 testStr 建立 該批配式的比對器
		 * 3.從 比對器 中取出結果 
		 */
		Pattern pattern = Pattern.compile(regex);
		pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(testStr1);
		DebugTool.showMessage(10, String.valueOf(matcher.matches()));
		matcher = pattern.matcher(testStr1);
		DebugTool.showMessage(11, String.valueOf(matcher.matches()));
//		DebugTool.showMessage(12, String.valueOf(matcher.group()));
		DebugTool.showMessage(13, String.valueOf(matcher.groupCount()));
//		DebugTool.showMessage(14, String.valueOf(matcher.start()));
//		DebugTool.showMessage(15, String.valueOf(matcher.end()));
		
		regex="[a-z]*";
		testStr1="ababcabcdabcde";
		System.out.println(testStr1.matches(regex));
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(testStr1);
		if(matcher.groupCount()==0) {
			DebugTool.showMessage(100, "Not Found!");		
		}else {
			for(int i=0; i<matcher.groupCount(); i++) {
				DebugTool.showMessage(100+i, matcher.group(i));		
			}
		}
	
	}

}
