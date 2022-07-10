package tw.idv.hunterchen.lab.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.utility.DevTool;

@Slf4j
public class Ex_regex {
	public static void main(String[] args) {
		String input="abc123def456";

		String regex="\\d+";
		Pattern pattern = Pattern.compile(regex);
		
		DevTool.showAllMembers(pattern);
		
		Matcher matcher = pattern.matcher(input);
		DevTool.showAllMembers(matcher);

	
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
