package tw.idv.hunterchen.utility;

import java.nio.charset.Charset;
import java.util.Random;

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
}
