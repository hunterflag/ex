package tw.idv.hunterchen.utility;

public interface SftpClients {

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
	void connect();

	/**
	 * 關閉連線
	 */
	void disconnect();

}