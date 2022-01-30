package tw.idv.hunterchen.utility;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SftpClient {
	private Logger log = Logger.getLogger(this.getClass().getName());
	private String host = "192.168.100.195";
	private String username = "pi";
	private String password = "raspberry";
	private int port = 22;

	private ChannelSftp sftp = null;
	private Session sshSession = null;

	public SftpClient() {
	}

	public SftpClient(String host, String user, String password, int port) {
		this.host = host;
		this.username = user;
		this.password = password;
		this.port = port;
	}

	public SftpClient(String host, String user, String password) {
		this.host = host;
		this.username = user;
		this.password = password;
	}
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
	public void connect() {
		try {
			JSch jsch = new JSch();
//			jsch.getSession(username, host, port);
			sshSession = jsch.getSession(username, host, port);
			if (log.isInfoEnabled()) {
				log.info("Session created.");
			}
			sshSession.setPassword(password);
	
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			
			sshSession.connect();
			if (log.isInfoEnabled()) {
				log.info("Session connected.");
			}
			
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			if (log.isInfoEnabled()) {
				log.info("Opening Channel.");
			}
			sftp = (ChannelSftp) channel;
			if (log.isInfoEnabled()) {
				log.info("Connected to " + host + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 關閉連線
	 */
	public void disconnect() {
		if (this.sftp != null) {
			if (this.sftp.isConnected()) {
				this.sftp.disconnect();
				if (log.isInfoEnabled()) {
					log.info("sftp is closed already");
				}
			}
		}
		if (this.sshSession != null) {
			if (this.sshSession.isConnected()) {
				this.sshSession.disconnect();
				if (log.isInfoEnabled()) {
					log.info("sshSession is closed already");
				}
			}
		}
	}
}
