package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Vector;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

public class SftpClientTest { 
	Logger logger = Logger.getLogger(this.getClass().getName());
	static final String mDivider = StringTool.genDivider();
	static SftpClient sftpClient;
	static ChannelSftp channelSftp;
//	
//	@BeforeClass
//	public static void beforeClass() {
//		ShowTool.showMessages(mDivider, "after class init()...", mDivider);
//		sftpClient = new SftpClient();
//		try {
//			channelSftp = sftpClient.setupJsch();
//			channelSftp.connect();
//		} catch (JSchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
	@Test
	public void testSetupJsch() {
		if (channelSftp.isConnected()) {
			try {
				Vector vector = channelSftp.ls("/");
				for (int i=0; i<vector.size(); i++) {
					ShowTool.showMessages(""+i, vector.get(i).toString());
				}
			} catch (SftpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Before
	public void beforeEveryTest() {
		ShowTool.showMessages(mDivider, "before test...", mDivider);
	}
	
	@After
	public void afterEveryTest() {
		ShowTool.showMessages(mDivider, "after test...", mDivider);
	}

	
	@AfterClass
	public static void afterClass() {
		ShowTool.showMessages(mDivider, "class end and after class...", mDivider);
		ShowTool.showMessages(mDivider, "after class", mDivider);
	}
}
