package tw.idv.hunterchen.utility.email;

import org.junit.Test;

public class StmpClientTest {
	@Test
	public void test() {
		// 準備連線主機、相關設定、登入帳密等
				String host = "127.0.0.1";
				String port = "587";
				String username = "developer";
				String password = "developer";

		SmtpClient client = new SmtpClient(host, port, username, password);
		client.connect();
	}
}
