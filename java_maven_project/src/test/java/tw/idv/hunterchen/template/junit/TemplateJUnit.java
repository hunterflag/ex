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

import tw.idv.hunterchen.utility.ShowTool;
import tw.idv.hunterchen.utility.StringTool;

public class TemplateJUnit { 
	Logger logger = Logger.getLogger(this.getClass().getName());
	static final String mDivider = StringTool.genDivider();
	
	@Test
	public void xxx_ut() {
		ShowTool.showMessages(mDivider, "test start...", mDivider);
//		assertEquals("expect", "result");
		assertNotEquals("expect", "result");
		assertTrue(true);
		assertFalse(false);
		ShowTool.showMessages(mDivider, "test end", mDivider);
	}
	
	@Test
	public void showSystem_ut() {
		ShowTool.showSystem();
	}
	
	@Before
	public void beforeEveryTest() {
		ShowTool.showMessages(mDivider, "before test...", mDivider);
	}
	
	@After
	public void afterEveryTest() {
		ShowTool.showMessages(mDivider, "after test...", mDivider);
	}

	/*
	 * @xxxClass 必須是 static
	 * 漏了, editor不會有任何問題, 但 initial會失敗, 導致 jUnit 失敗 
	 */
	@BeforeClass
	public static void beforeClass() {
		ShowTool.showMessages(mDivider, "before class...", mDivider);
		//TODO
		ShowTool.showMessages(mDivider, "class start...", mDivider);
	}
	
	@AfterClass
	public static void afterClass() {
		ShowTool.showMessages(mDivider, "class end and after class...", mDivider);
		ShowTool.showMessages(mDivider, "after class", mDivider);
	}
}
