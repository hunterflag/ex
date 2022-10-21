package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class StringUtilTest {
//	@Test
	public void generatStringByRandomTest() {
		for (int length=0; length<10; length++) {
			String generatedString = StringUtil.generateStringByRandom(length);
			assertEquals(length, generatedString.length());
			log.info("generatedString={}", generatedString.toString());
		}
	}
	@Test
	public void generateStringByRegexTest() {
		String regex = "[ab]{4,6}c";
		for (int i=0; i<10; i++) {
			String generatedString = StringUtil.generateStringByRegex(regex);
			log.info("{}:generatedString={}", i, generatedString.toString());
		}		
	}
}
