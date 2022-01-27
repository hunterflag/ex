package tw.idv.hunterchen.lab.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import tw.idv.hunterchen.utility.ShowTool;

public class Ex_File_Write {
	private static String defaultFileName = "d:\\temp\\files\\out.txt";
	private static String encoding = "UTF-8";
	private static List<String> testLineText = Arrays.asList("The first line", "The second line", "UTF-8");

	public static void appendToFile(String fileName, String lineText) {
		lineText = (lineText == null) ? "" : lineText;
		fileName = (fileName == null) ? defaultFileName : fileName;
		File file = new File(fileName);
		try {
			do {
				if (!file.exists()) {
					ShowTool.showMessages(fileName, "不存在, 將建立新檔...");
					file.createNewFile();
				}
				if (file.isDirectory()) {
					fileName = file.getParent() + "\\D_" + file.getName();
					ShowTool.showMessages(file.getCanonicalPath(), "是資料夾, 檔名自動更改為", fileName);
					file = new File(fileName);
				}
			} while (!(file.exists() && file.isFile()));

			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(lineText + "\r\n");
//				bufferedWriter.write(lineText);
//				bufferedWriter.newLine();
			bufferedWriter.flush();
			bufferedWriter.close();
			ShowTool.showMessages("將", lineText, "加入", fileName, "中...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeToNewFile(String fileName, String lineText) {
		lineText = (lineText == null) ? "" : lineText;
		fileName = (fileName == null) ? defaultFileName : fileName;
		// 法.a
		// XXX 每次都開新檔, 不能附加內容?
		try {
			PrintWriter writer = new PrintWriter(defaultFileName, encoding);
			writer.println("The first line");
			writer.println("The second line");
			writer.println(lineText);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		writeToNewFile(null, "fffff");
		appendToFile(null, "dddd");
	}

}
