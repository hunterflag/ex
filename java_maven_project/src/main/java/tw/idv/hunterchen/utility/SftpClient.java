package tw.idv.hunterchen.utility;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SftpClient{
	private static final Logger logger = LoggerFactory.getLogger(SftpClient.class);
	private String 	host 	 = "127.0.0.1";
	private int 	port 	 = 22;
	private String 	username = "developer";
	private String 	password = "developer";

	private ChannelSftp sftp   = null;
	private Session sshSession = null;

	private String remotePath ="/";
	private String localPath  ="d:\\temp\\sftp\\";

	public SftpClient() {
	}

	//法.a.使用帳密
	public SftpClient(String host, String username, String password, int port) {
		this.host = host;
		this.username = username;
		this.password = password;
		this.port = port;
	}
	// 建構式不能呼叫建構式! 但方法可以呼叫同名方法
	public SftpClient(String host, String username, String password) {
		this.host = host;
		this.username = username;
		this.password = password;
		this.port = 22;
	}
	//法.b.a.使用客戶端的金鑰(私)
	//法.b.b.使用伺服端的金鑰(公)
	
	/*
	public ChannelSftp setupJsch() throws JSchException {
		ChannelSftp result=null;
		JSch jsch = new JSch();
		((Object) jsch).serKnownHosts();
		Session jschSession = jsch.getSession(username, host);
		jschSession.setPassword(password);
		jschSession.connect();
		result = (ChannelSftp) jschSession.openChannel("sftp");
		return result;
	}
	*/
	/**
	 * 通過SFTP連線伺服器
	 */

	//建立 ssh連線
	public void connect() {
		try {
			JSch jsch = new JSch();
			sshSession = jsch.getSession(username, host, port);
				logger.info("Session created.");
			sshSession.setPassword(password);
	
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			
			sshSession.connect();
				logger.info("Session connected.");
			
			//在 ssh連線 建立 sftp通道
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
				logger.info("Opening Channel.");
			sftp = (ChannelSftp) channel;
				logger.info("Connected to " + host + ".");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 關閉連線
	 */
	public void disconnect() {
		if (this.sshSession != null) {
			if (this.sshSession.isConnected()) {
				this.sshSession.disconnect();
				logger.info("sshSession is closed already");
			}
		}
		if (this.sftp != null) {
			if (this.sftp.isConnected()) {
				this.sftp.disconnect();
					logger.info("sftp is closed already");
			}
		}else {
			
		}
	}
	
	
}
