package tw.idv.hunterchen.template.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tw.idv.hunterchen.utility.DevTool;
import tw.idv.hunterchen.utility.StringTool;

public class TemplateTestDemo { 
	Logger logger = Logger.getLogger(this.getClass().getName());
	static final String mDivider = StringTool.genDivider();
	
	@Test
	public void xxx_ut() {
		DevTool.showMessages("----test ----");
//		assertEquals("expect", "result");
		assertNotEquals("expect", "result");
		assertTrue(true);
		assertFalse(false);
	}
	
	@Test
	public void showSystem_ut() {
		DevTool.showMessages("----test ----");
		DevTool.showSystem();
	}
	
	@Before
	public void beforeEveryTest() {
		DevTool.showMessages(mDivider, "...before test", mDivider);
	}
	
	@After
	public void afterEveryTest() {
		DevTool.showMessages(mDivider, "after test...", mDivider);
	}

	/*
	 * @xxxClass 必須是 static
	 * 漏了, editor不會有任何問題, 但 initial會失敗, 導致 jUnit 失敗 
	 */
	@BeforeClass
	public static void beforeClass() {
		DevTool.showMessages(mDivider, "...before class", mDivider);
	}
	
	@AfterClass
	public static void afterClass() {
		DevTool.showMessages(mDivider, "after class...", mDivider);
	}
}
