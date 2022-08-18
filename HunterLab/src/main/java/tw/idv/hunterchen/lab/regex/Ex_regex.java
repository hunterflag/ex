package tw.idv.hunterchen.lab.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex_regex {
	public static void main(String[] args) {
		String regex="\\d+";
		String input="abc123def456";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) {
			System.out.printf("%s\n"
					, matcher.group()
				);
			
		}else {
			System.out.printf("no match \n"
//					, matcher.group()
				);
			
		}
		
	}
}
