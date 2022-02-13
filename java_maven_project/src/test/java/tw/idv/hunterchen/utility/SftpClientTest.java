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

	
	@Test
	public void testAtHomeLan() {
		String host;
		String username;
		String password;
		int port;
		switch (DevTool.getOsName()) {
			case "MacOS":
				host = "192.168.100.195";
				username = "pi";
				password = "hunter1234";
				port = 22;
				break;
			case "Windows":
				host = "127.0.0.1";
				username = "developer";
				password = "developer";
				port = 22;
				break;
			default:
				host = "127.0.0.1";
				username = "developer";
				password = "developer";
				port = 22;
		}
		
		SftpClient sftpClient = new  SftpClient(host, username, password, port);

		DevTool.showMessages("----test ----");
		DevTool.showMessages("connect...");
		sftpClient.connect();
		DevTool.showMessages("connect complete, and disconnect...");
		sftpClient.disconnect();
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
