package tw.idv.hunterchen.lab.ssh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

// https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/311339/
public class SftpUtils {
	private static Logger log = LoggerFactory.getLogger(SftpUtils.class.getName());
	private String host = "127.0.0.1"; // 伺服器連線ip
	private String username = "developer"; // 使用者名稱
	private String password = "developer"; // 密碼
	private int port = 23; // 埠號
	private ChannelSftp sftp = null;
	private Session sshSession = null;

	// 建構式
	public SftpUtils() {
	}

	public SftpUtils(String host, int port, String username, String password) {
		this.host = host;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	public SftpUtils(String host, String username, String password) {
		this.host = host;
		this.username = username;
		this.password = password;
	}

	/**
	 * 通過SFTP連線伺服器
	 */
	public void connect() {
		try {
			JSch jsch = new JSch();
			jsch.getSession(username, host, port);
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

	/**
	 * 批量下載檔案
	 * 
	 * @param remotPath：遠端下載目錄(以路徑符號結束,可以為相對路徑eg:/assess/sftp/jiesuan_2/2014/)
	 * @param localPath：本地儲存目錄(以路徑符號結束,D:\Duansha\sftp\)
	 * @param fileFormat：下載檔案格式(以特定字元開頭,為空不做檢驗)
	 * @param fileEndFormat：下載檔案格式(檔案格式)
	 * @param del：下載後是否刪除sftp檔案
	 * @return
	 */
	public List<String> batchDownLoadFile(String remotePath, String localPath, String fileFormat, String fileEndFormat,
			boolean del) {
		List<String> filenames = new ArrayList<String>();
		try {
			// connect();
			Vector v = listFiles(remotePath);
			// sftp.cd(remotePath);
			if (v.size() > 0) {
				System.out.println("本次處理檔案個數不為零,開始下載...fileSize=" + v.size());
				Iterator it = v.iterator();
				while (it.hasNext()) {
					LsEntry entry = (LsEntry) it.next();
					String filename = entry.getFilename();
					SftpATTRS attrs = entry.getAttrs();
					if (!attrs.isDir()) {
						boolean flag = false;
						String localFileName = localPath + filename;
						fileFormat = fileFormat == null ? "" : fileFormat.trim();
						fileEndFormat = fileEndFormat == null ? "" : fileEndFormat.trim();
						// 三種情況
						if (fileFormat.length() > 0 && fileEndFormat.length() > 0) {
							if (filename.startsWith(fileFormat) && filename.endsWith(fileEndFormat)) {
								flag = downloadFile(remotePath, filename, localPath, filename);
								if (flag) {
									filenames.add(localFileName);
									if (flag && del) {
										deleteSFTP(remotePath, filename);
									}
								}
							}
						} else if (fileFormat.length() > 0 && "".equals(fileEndFormat)) {
							if (filename.startsWith(fileFormat)) {
								flag = downloadFile(remotePath, filename, localPath, filename);
								if (flag) {
									filenames.add(localFileName);
									if (flag && del) {
										deleteSFTP(remotePath, filename);
									}
								}
							}
						} else if (fileEndFormat.length() > 0 && "".equals(fileFormat)) {
							if (filename.endsWith(fileEndFormat)) {
								flag = downloadFile(remotePath, filename, localPath, filename);
								if (flag) {
									filenames.add(localFileName);
									if (flag && del) {
										deleteSFTP(remotePath, filename);
									}
								}
							}
						} else {
							flag = downloadFile(remotePath, filename, localPath, filename);
							if (flag) {
								filenames.add(localFileName);
								if (flag && del) {
									deleteSFTP(remotePath, filename);
								}
							}
						}
					}
				}
			}
			if (log.isInfoEnabled()) {
				log.info("download file is success:remotePath=" + remotePath + "Path=" + localPath + ",file size is"
						+ v.size());
			}
		} catch (SftpException e) {
			e.printStackTrace();
		} finally {
			// this.disconnect();
		}
		return filenames;
	}

	/**
	 * 下載單個檔案
	 * 
	 * @param remotPath：遠端下載目錄(以路徑符號結束)
	 * @param remoteFileName：下載檔名
	 * @param localPath：本地儲存目錄(以路徑符號結束)
	 * @param localFileName：儲存檔名
	 * @return
	 */
	public boolean downloadFile(String remotePath, String remoteFileName, String localPath, String localFileName) {
		FileOutputStream fieloutput = null;
		try {
			// sftp.cd(remotePath);
			File file = new File(localPath + localFileName);
			// mkdirs(localPath localFileName);
			fieloutput = new FileOutputStream(file);
			sftp.get(remotePath + remoteFileName, fieloutput);
			if (log.isInfoEnabled()) {
				log.info("===DownloadFile:" + remoteFileName + " success from sftp.");
			}
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		} finally {
			if (null != fieloutput) {
				try {
					fieloutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * 上傳單個檔案
	 * 
	 * @param remotePath：遠端儲存目錄
	 * @param remoteFileName：儲存檔名
	 * @param localPath：本地上傳目錄(以路徑符號結束)
	 * @param localFileName：上傳的檔名
	 * @return
	 */
	public boolean uploadFile(String remotePath, String remoteFileName, String localPath, String localFileName) {
		FileInputStream in = null;
		try {
			createDir(remotePath);
			File file = new File(localPath + localFileName);
			in = new FileInputStream(file);
			sftp.put(in, remoteFileName);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * 批量上傳檔案
	 * 
	 * @param remotePath：遠端儲存目錄
	 * @param localPath：本地上傳目錄(以路徑符號結束)
	 * @param del：上傳後是否刪除本地檔案
	 * @return
	 */
	public boolean bacthUploadFile(String remotePath, String localPath, boolean del) {
		try {
			connect();
			File file = new File(localPath);
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile() && files[i].getName().indexOf("bak") == -1) {
					if (this.uploadFile(remotePath, files[i].getName(), localPath, files[i].getName()) && del) {
						deleteFile(localPath + files[i].getName());
					}
				}
			}
			if (log.isInfoEnabled()) {
				log.info("upload file is success:remotePath=" + remotePath + "and localPath=" + localPath
						+ ",file size is " + files.length);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
		return false;
	}

	/**
	 * 刪除本地檔案
	 * 
	 * @param filePath
	 * @return
	 */
	public boolean deleteFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			return false;
		}
		if (!file.isFile()) {
			return false;
		}
		boolean rs = file.delete();
		if (rs && log.isInfoEnabled()) {
			log.info("delete file success from local.");
		}
		return rs;
	}

	/**
	* 建立目錄
	* @param createpath
	* @return
	*/
	public boolean createDir(String createpath)
	{
	try
	{
	if (isDirExist(createpath))
	{
	this.sftp.cd(createpath);
	return true;
	}
	String pathArry[] = createpath.split("/");
	StringBuffer filePath = new StringBuffer("/");
	for (String path : pathArry)
	{
	if (path.equals(""))
	{
	continue;
	}
	filePath.append(path + "/");
	if (isDirExist(filePath.toString()))
	{
	sftp.cd(filePath.toString());
	}
	else
	{
	// 建立目錄
	sftp.mkdir(filePath.toString());
	// 進入並設定為當前目錄
	sftp.cd(filePath.toString());
	}
	}
	this.sftp.cd(createpath);
	return true;
	}
	catch (SftpException e)
	{
	e.printStackTrace();
	}
	return false;
	}

	/**
	 * 判斷目錄是否存在
	 * 
	 * @param directory
	 * @return
	 */
	public boolean isDirExist(String directory) {
		boolean isDirExistFlag = false;
		try {
			SftpATTRS sftpATTRS = sftp.lstat(directory);
			isDirExistFlag = true;
			return sftpATTRS.isDir();
		} catch (Exception e) {
			if (e.getMessage().toLowerCase().equals("no such file")) {
				isDirExistFlag = false;
			}
		}
		return isDirExistFlag;
	}

	/**
	* 刪除stfp檔案
	* @param directory：要刪除檔案所在目錄
	* @param deleteFile：要刪除的檔案
	* @param sftp
	*/
	public void deleteSFTP(String directory, String deleteFile)
	{
	try
	{
	// sftp.cd(directory);
	sftp.rm(directory + deleteFile);if(log.isInfoEnabled())

	{
		log.info("delete file success from sftp.");
	}}catch(
	Exception e)
	{
		e.printStackTrace();
	}
	}

	/**
	 * 如果目錄不存在就建立目錄
	 * 
	 * @param path
	 */
	public void mkdirs(String path) {
		File f = new File(path);
		String fs = f.getParent();
		f = new File(fs);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	/**
	 * 列出目錄下的檔案
	 * 
	 * @param directory：要列出的目錄
	 * @param sftp
	 * @return
	 * @throws SftpException
	 */
	public Vector listFiles(String directory) throws SftpException {
		return sftp.ls(directory);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ChannelSftp getSftp() {
		return sftp;
	}

	public void setSftp(ChannelSftp sftp) {
		this.sftp = sftp;
	}

	/** 測試 
	public static void main(String[] args) {
		SftpUtils sftp = null;
		// 本地存放地址
		String localPath = "D:/tomcat5/webapps/ASSESS/DocumentsDir/DocumentTempDir/txtData/";
		// Sftp下載路徑
		String sftpPath = "/home/assess/sftp/jiesuan_2/2014/";
		List<String> filePathList = new ArrayList<String>();
		try {
			sftp = new SftpUtils("10.163.201.115", "tdcp", "tdcp");
			sftp.connect();
			// 下載
			sftp.batchDownLoadFile(sftpPath, localPath, "ASSESS", ".txt", true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sftp.disconnect();
		}
	}
	 * */
}
