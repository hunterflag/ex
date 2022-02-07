package tw.idv.hunterchen.lab.ssh;

import static org.junit.Assert.*;

import org.junit.Test;

public class SFTPUtilTest {
	String host = "127.0.0.1";
	int port = 21;
	String username = "developer";
	String password = "developer";

	SFTPUtil sftpUtil = new SFTPUtil(username, password, host, port);
	@Test
	public void testLogin() {
		sftpUtil.login();;
		sftpUtil.logout();;
		
	}

}
