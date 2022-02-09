package tw.idv.hunterchen.lab.ssh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

import tw.idv.hunterchen.utility.DevTool;

public class SftpUtilsTest {
	
	@Test
	public void test() {
//		sftpUtils.connect();
//		sftpUtils.disconnect();
		SftpUtils sftpUtils = null;
		String localPath = "D:\\temp\\sftp";		// 本地存放地址
		String sftpPath = "/";					// Sftp下載路徑
		List<String> filePathList = new ArrayList<String>();
		try {
			sftpUtils = new SftpUtils();
			sftpUtils.connect();
			Vector files = sftpUtils.listFiles(sftpPath);
			for (int i=0; i<files.size(); i++) {
				DevTool.showMessages(files.get(i).toString());
				
			}
			
			// 下載
			sftpUtils.batchDownLoadFile(sftpPath, localPath, "ASSESS", ".txt", false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sftpUtils.disconnect();
		}
	}

}
