package tw.idv.hunterchen.lab.sftp;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * 類說明 sftp工具類 https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/571871/
 */
public class SftpUtil {
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	private ChannelSftp sftp;
	private Session session;
	/** SFTP 登入使用者名稱 */
	private String username;
	/** SFTP 登入密碼 */
	private String password;
	/** 私鑰 */
	private String privateKey;
	/** SFTP 伺服器地址IP地址 */
	private String host;
	/** SFTP 埠 */
	private int port;

	/**
	 * 構造基於密碼認證的sftp物件
	 */
	public SftpUtil(String username, String password, String host, int port) {
		this.username = username;
		this.password = password;
		this.host = host;
		this.port = port;
	}

	/**
	 * 構造基於祕鑰認證的sftp物件
	 */
	public SftpUtil(String username, String host, int port, String privateKey) {
		this.username = username;
		this.host = host;
		this.port = port;
		this.privateKey = privateKey;
	}

	public SftpUtil() {
	}

	/**
	 * 連線sftp伺服器
	 */
	public void login() {
		try {
			JSch jsch = new JSch();
			if (privateKey != null) {
				jsch.addIdentity(privateKey);// 設定私鑰
			}
			session = jsch.getSession(username, host, port);
			if (password != null) {
				session.setPassword(password);
			}
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
		} catch (JSchException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 關閉連線 server
	 */
	public void logout() {
		if (sftp != null) {
			if (sftp.isConnected()) {
				sftp.disconnect();
			}
		}
		if (session != null) {
			if (session.isConnected()) {
				session.disconnect();
			}
		}
	}

}
