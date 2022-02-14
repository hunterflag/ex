package tw.idv.hunterchen.utility;

import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

// https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/311339/
public class SftpClient{
	private static final Logger logger = LoggerFactory.getLogger(SftpClient.class);
	private String 	host 	 = "127.0.0.1";
	private int 	port 	 = 22;
	private String 	username = "developer";
	private String 	password = "developer";

	private String remoteCurrentDir ="/";					//伺服端當前目錄
	private String localCurrentDir  ="d:\\temp\\sftp\\";	//本地端當前目錄

	private Session sshSession = null;
	private ChannelSftp channelSftp   = null;


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

	//建立 ssh連線、建立SFTP連線伺服器
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
			channelSftp = (ChannelSftp) channel;
				logger.info("Connected to " + host + ".");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 取得當前目錄路徑名稱
	public String getremotePath() {
		return remoteCurrentDir;
	}
	// 建立目錄
	// 移除目錄
	// 切換目錄
	// 下載指定路徑的檔案
	// 下載指定目錄下的的全部檔案
	// 下載指定目錄(含以下的全部檔案)
	// 上傳指定路徑的檔案
	// 上傳指定目錄下的的全部檔案
	// 上傳指定目錄(含以下的全部檔案)
	// 刪除檔案
	
	// 取得指定目錄下的檔案清單
	public List<String> lsFileNames(String directory){
		List<String> result = null;
		Vector<LsEntry> lsEntries  = ls(directory);
		for (LsEntry lsEntry : lsEntries) {
			SftpATTRS attrs = lsEntry.getAttrs();
			if(!attrs.isDir()) {
				DevTool.showMessages(lsEntry.getFilename());
			}
		}
		return result;
	}
	public Vector ls(){
		return ls(null);
	}
	public Vector ls(String directory){
		directory = directory==null ? remoteCurrentDir : directory;
		Vector result=null;
		try {
			result = channelSftp.ls(directory);
//			result = channelSftp.ls(remotePath);
			if (result.size()>0) {
				for (int i=0; i<result.size(); i++) {
					DevTool.showMessages(""+i, result.get(i).toString());
				}
			}else {
				DevTool.showMessages("No file in Directory");
			}
		} catch (SftpException e) {
			e.printStackTrace();
		} 
		return result;
	}
	// 關閉連線
	public void disconnect() {
		if (this.sshSession != null) {
			if (this.sshSession.isConnected()) {
				this.sshSession.disconnect();
				logger.info("sshSession is closed already");
			}
		}
		if (this.channelSftp != null) {
			if (this.channelSftp.isConnected()) {
				this.channelSftp.disconnect();
					logger.info("sftp is closed already");
			}
		}else {
	
		}
	}
	
	
	
}
