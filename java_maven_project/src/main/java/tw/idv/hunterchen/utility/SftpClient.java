// 連線登入.帳密
// 連線登入.憑證
// 斷線登出
// 目錄.建立
// 目錄.刪除
// 目錄.切換
// 目錄.檢視清單
// 下載.單一檔案
// 下載.目錄下的全部檔案
// 下載.目錄下、特定類型(字尾)的全部檔案
// 下載.目錄(含子目錄)
// 上傳.單一檔案
// 上傳.目錄下的的全部檔案
// 上傳.目錄下、特定類型(字尾)的全部檔案
// 上傳.目錄(含子目錄)
// 刪除檔案
// 存在嗎？
// 是檔案？

package tw.idv.hunterchen.utility;

import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

import lombok.extern.slf4j.Slf4j;

// https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/311339/
@Slf4j
public class SftpClient{
//	private static final Logger log = LoggerFactory.getLogger(SftpClient.class);
	private String 	host 	 = "127.0.0.1";
	private int 	port 	 = 22;
	private String 	username = "developer";
	private String 	password = "developer";

	private String remoteCurrentDir ="/";					//伺服端當前目錄
	private String localCurrentDir  ="d:\\temp\\sftp\\";	//本地端當前目錄

	private Session sshSession = null;
	private ChannelSftp channelSftp   = null;
	private boolean hasConnected = false;


	public SftpClient() {
	}

	//法.a.使用帳密
	public SftpClient(String host, String username, String password, int port) {
		log.info("\n\thost:{}\n\tusername:{}\n\tpassword:{}\n\tport:{}", host, username, password, port);
		this.host = host;
		this.username = username;
		this.password = password;
		this.port = port;
	}
	// 建構式不能呼叫建構式! 但方法可以呼叫同名方法
	public SftpClient(String host, String username, String password) {
		log.info("\n\thost:{}\n\tusername:{}\n\tpassword:{}\n\tport:{}", host, username, password, port);
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
	public boolean connect() {
		hasConnected = false;
		try {
			
			JSch jsch = new JSch();								
			// 首先要取得連線(不然怎麼通訊, 此時只能驗證而已)
			sshSession = jsch.getSession(username, host, port);	
			// 取得連線之後, 才能驗證密碼、進行設定
			sshSession.setPassword(password);					
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			// 通過驗證, 正式建立ssh連線
			sshSession.connect();
			log.info("SSH Session connected.");
			
			//在 ssh連線 上, 建立 sftp通道 (依關鍵字開啟各種用途通道)
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
				log.info("Opening Channel.");
			channelSftp = (ChannelSftp) channel;
				log.info("Connected to " + host + ".");
			hasConnected = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasConnected;
	}
	// 取得當前目錄路徑名稱
	public String getremotePath() {
		return remoteCurrentDir;
	}
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
	
	public void mv(String srcFile,String destFile) {
		boolean result=false;
		try {
			channelSftp.rename(srcFile, destFile);
			result=true;
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return result;
	}
	
	
	// 關閉連線
	public void disconnect() {
		if (this.sshSession != null) {
			if (this.sshSession.isConnected()) {
				this.sshSession.disconnect();
				log.info("sshSession is closed already");
			}
		}
		if (this.channelSftp != null) {
			if (this.channelSftp.isConnected()) {
				this.channelSftp.disconnect();
					log.info("sftp is closed already");
			}
		}else {
	
		}
	}
	
	
	
}
