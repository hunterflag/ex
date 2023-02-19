package tw.idv.hunterchen.lab.runtime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Runtime {

	public static void main(String[] args) {
		Runtime lRuntime = Runtime.getRuntime();
//		DevTool.showAllMembers(lRuntime);
//		DevTool.showMessages(String.valueOf(lRuntime.availableProcessors()));
//		DevTool.showMessages(String.valueOf(lRuntime.freeMemory()));
//		DevTool.showMessages(String.valueOf(lRuntime.maxMemory()));
//		lRuntime.exit(111);

		try {
			Process lProcess = 
//					Runtime.getRuntime().exec("notepad.exe");	// 外部程式
//					Runtime.getRuntime().exec("notExist.exe");		// 無此檔案
//					Runtime.getRuntime().exec("C:\\Program Files\\Git\\git-bash.exe");		// 外部程式
					Runtime.getRuntime().exec("ping localhost -t");		// 外部程式
//			Runtime.getRuntime().exec("cmd.exe ");		// 外部程式, 卻不見視窗, 也沒exitCode
			InputStream lInputStream = lProcess.getInputStream();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(lInputStream, "ms950"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(lInputStream, "BIG5"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
//			BufferedWriter bw = new BufferedWriter(new FileWriter("dd"));
//			BufferedWriter.class;
			int exitCode = lProcess.waitFor();		// 後面指令也會等待
			DevTool.showMessages(String.valueOf(exitCode));
			
//			Runtime.getRuntime().exec("dir");			// 這是 cmd.exe 的內部指令
//			Runtime.getRuntime().exec("notepad.exe");	// 外部程式

			/*
			Runtime.getRuntime().exec("notepad.exe d:\\layout.xml");
//			String[] commandWithArgs = {"notepad.exe", "d:\\layout.xml" };	
//			Runtime.getRuntime().exec(commandWithArgs);
*/
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
