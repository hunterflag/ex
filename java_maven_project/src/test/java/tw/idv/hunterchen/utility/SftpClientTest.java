package tw.idv.hunterchen.utility;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SftpClientTest { 
//	Logger logger = Logger.getLogger(this.getClass().getName());
	static final String mDivider = StringTool.genDivider();

	private SftpClient client = new SftpClient();
	
	@Test
	public void xxx_ut() {
		ShowTool.showMessages("----test ----");
		ShowTool.showMessages("connect...");
		client.connect();
		ShowTool.showMessages("connect complete, and disconnect...");
		client.disconnect();
		ShowTool.showMessages("disconnect");
		
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
