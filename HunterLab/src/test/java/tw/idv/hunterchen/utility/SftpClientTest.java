package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SftpClientTest { 
//	private static final Logger log = LoggerFactory.getLogger(SftpClientTest.class);
	static final String mDivider = StringTool.genDivider();
	
	static SftpClient sftpClient;
	
	@BeforeClass
	public static void beforeClass() {
		String host;
		String username;
		String password;
		int port;
		String remotePath;
		String localPath;
		
		switch (DevTool.getOsName()) {
			case "MacOS":
				host = "192.168.100.195";
				username = "pi";
				password = "hunter1234";
				port = 22;
//				remotePath="~/temp/sftpServerRoot/";
				remotePath="/home/pi/temp/sftpServerRoot/";
				localPath="~/temp/sftpClientRoot/";
				break;
			case "Windows":
				host = "127.0.0.1";
				username = "developer";
				password = "developer";
				port = 2222;
				remotePath="~/upload";
				localPath="d:/temp/sftpClientRoot/";
				break;
			default:
				host = "127.0.0.1";
				username = "developer";
				password = "developer";
				port = 2222;
				remotePath="/";
				localPath="d:/temp/sftpClientRoot/";
		}
		
		sftpClient = new  SftpClient(host, username, password, port);
		DevTool.showMessages("connect...");
		sftpClient.connect();
	
	}
	
	@Test
	public void testAtHomeLan() {
		DevTool.showMessages("----test ----");
		
		assertTrue(sftpClient.isExist("/"));
		assertFalse(sftpClient.isExist("/dd"));
		assertTrue(sftpClient.isExist("/upload"));
		assertTrue(sftpClient.isExist("/upload/"));
		
		sftpClient.ensureDirExist("/upload/cc");
		sftpClient.ls("/");
		sftpClient.ls("/upload");
//		sftpClient.mv("/upload/sample.properties", "/upload/dd/sample.properties");
//		sftpClient.mv("/upload/sample.json", "/sample.json");
		sftpClient.lsFileNames("/upload/dd");
		DevTool.showMessages("connect complete, and disconnect...");
		
	}
	
	@AfterClass
	public static void afterClass() {
		if (sftpClient!=null) {
			DevTool.showMessages("disconnect");
			sftpClient.disconnect();
		}
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
