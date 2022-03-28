package tw.idv.hunterchen.lab.ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_JSch {
	
	public static void main(String[] args) {
		JSch jsch = new JSch();
		DevTool.showAllMembers(jsch);
		String host = "127.0.0.1";
		try {
			Session session = jsch.getSession(host);
	
			session.getUserName();
		} catch (JSchException e) {
			e.printStackTrace();
		}
		
		
	}

	
	

}
