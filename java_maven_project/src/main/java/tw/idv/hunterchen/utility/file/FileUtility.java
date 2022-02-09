package tw.idv.hunterchen.utility.file;

import java.io.File;

import tw.idv.hunterchen.utility.DevTool;

public class FileUtility {
	public static String getMainName(String fileName) {
		String result = null;
		File file = new File(fileName);
		fileName = file.getName();
		int pos = fileName.lastIndexOf('.');
//		ShowTool.showMessages(""+pos);
		result = fileName.substring(0, pos);
		return result;
	}

	public static String getExtendName(String fileName) {
		String result = null;
		File file = new File(fileName);
		fileName = file.getName();
		int pos = fileName.lastIndexOf('.');
//		ShowTool.showMessages(""+pos);
		result = fileName.substring(pos + 1);
		return result;
	}

	public static boolean renameOrMove(String source, String destination) {
		boolean result = true;
		try {
			File srcFile = new File(source);
			File destFile = new File(destination);
			if (!srcFile.exists()) {
				DevTool.showMessages(srcFile.getCanonicalPath(), "不存在");
				result = false;
			} else {
				result = srcFile.renameTo(destFile);
				if (result) {
					DevTool.showMessages("renameOrmove?", "成功");
				}else {
					DevTool.showMessages("renameOrmove?", "失敗");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
