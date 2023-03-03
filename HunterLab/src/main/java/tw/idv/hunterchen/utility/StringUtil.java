package tw.idv.hunterchen.utility;

import java.nio.charset.Charset;
import java.util.Random;

import javax.naming.directory.DirContext;

import lombok.extern.slf4j.Slf4j;
import nl.flotsam.xeger.Xeger;

@Slf4j
public class StringUtil {
	// app.stringUtil.default.length=8
	static Integer defaultLength=8;
	public static String generateStringByRandom(Integer length) {
		String result=null;
		length = (length==null ? defaultLength : length);
		
		byte[] array = new byte[length];
		new Random().nextBytes(array);
		result = new String(array, Charset.forName("UTF-8"));
//		log.info("");
		return result;
	}
	
	public static String generateStringByRegex(String regex) {
		String result=null;
		Xeger regexGenerator = new Xeger(regex);
		result = regexGenerator.generate();
		log.info("generatedString={}", result);
		return result;
	}
	/**
	 * 
	 * @param originString		
	 * @param paddingString		用來填充用的字串, 預設為半形空白字元
	 * @param expectedLength	填補後的總長度
	 * @param direction			
	 * @return					填補後的字串
	 * @since 2023-03-01
	 * @author Hunter Chen
	 */
	public static String padding(String originString, 
								 String paddingString, 
								 Integer expectedLength, 
								 PaddingDirection direction) 
	{
		// 值檢、預設值
		originString   = (originString == null || originString.isEmpty())   ? "" : originString;
		paddingString  = (paddingString == null || paddingString.isEmpty()) ? " " : paddingString;
		expectedLength = (expectedLength == null || expectedLength <= 0 )   ? 8 : expectedLength;
		direction = (direction == null) ? PaddingDirection.RIGHT : direction;
		
		String result=originString;
		String appendString="";
		// 不須處理的情況
		if (originString.length() >= expectedLength) {	
			//appendString = originString;
		} else {
			int quotient = (expectedLength-originString.length()) / paddingString.length();
			int remainder = (expectedLength-originString.length()) % paddingString.length(); 
			
			for (int i=0; i<quotient; i++) {
				appendString += paddingString;
			}

			char[] paddedChar = paddingString.toCharArray();
			for (int i=0; i<remainder; i++) {
				appendString += paddedChar[i];
			}
		}

		if(direction==PaddingDirection.RIGHT) {
			result = originString + appendString;
		} else {
			result = appendString + originString;
		}
		
		log.info("generatedString= {}", result);
		return result;
	}
	
	
}
