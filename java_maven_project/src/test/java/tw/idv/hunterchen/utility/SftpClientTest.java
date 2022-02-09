package tw.idv.hunterchen.utility;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SftpClientTest { 
	private static final Logger logger = LoggerFactory.getLogger(SftpClientTest.class);
	static final String mDivider = StringTool.genDivider();

	private SftpClients client = new SftpClientImpl();
	
	@Test
	public void xxx_ut() {
		DevTool.showMessages("----test ----");
		DevTool.showMessages("connect...");
		client.connect();
		DevTool.showMessages("connect complete, and disconnect...");
		client.disconnect();
		DevTool.showMessages("disconnect");
		
	}
	
	/*
	@Before
	public void beforeEveryTest() {
		ShowTool.showMessages(mDivider, "...before test", mDivider);
	}
	
	@After
	public void afterEveryTest() {
		ShowTool.showMessages(mDivider, "after test...", mDivider);
	}

	 * @xxxClass 必須是 static
	 * 漏了, editor不會有任何問題, 但 initial會失敗, 導致 jUnit 失敗 
	@BeforeClass
	public static void beforeClass() {
		ShowTool.showMessages(mDivider, "...before class", mDivider);
	}
	
	@AfterClass
	public static void afterClass() {
		ShowTool.showMessages(mDivider, "after class...", mDivider);
	}
	 */
}
