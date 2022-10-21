package tw.idv.hunterchen.template.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.idv.hunterchen.utility.DevTool;
import tw.idv.hunterchen.utility.StringTool;

public class TemplateTest { 
	Logger log = LoggerFactory.getLogger(TemplateTest.class);
	static final String mDivider = StringTool.genDivider();
	
	@Test
	public void xxxTest() {
		log.info("AnyThing");
		DevTool.showMessages("----test ----");
	}
	
	@Test
	public void showSystemTest() {
		DevTool.showMessages("----test ----");
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
