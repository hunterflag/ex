package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
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
//	@Test
	public void generateStringByRegexTest() {
		String regex = "[ab]{4,6}c";
		for (int i=0; i<10; i++) {
			String generatedString = StringUtil.generateStringByRegex(regex);
			log.info("{}:generatedString={}", i, generatedString.toString());
		}		
	}
	
	@Test
	public void paddingTest() {		
		assertEquals("        ", StringUtil.padding(null, null, null, null));
		assertEquals("abc     ", StringUtil.padding("abc", null, null, null));
		assertEquals("abc_____", StringUtil.padding("abc", "_", null, null));
		assertEquals("abcdeded", StringUtil.padding("abc", "de", null, null));
		assertEquals("00000123", StringUtil.padding("123", "0", null, PaddingDirection.LEFT));
		assertEquals("dededabc", StringUtil.padding("abc", "de", null, PaddingDirection.LEFT));
		assertEquals("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", 
				StringUtil.padding(null, "1234567890", 100, null));
		assertEquals("====================", 
				StringUtil.padding(null, "=", 20, null));
	}
	
	@Before
	public void beginTest() {
		System.out.println("Start test");
	}
	
	@After
	public void afterTest() {
		System.out.println("Finish test");
	}
}
