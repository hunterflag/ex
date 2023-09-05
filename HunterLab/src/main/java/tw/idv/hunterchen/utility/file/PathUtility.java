package tw.idv.hunterchen.utility.file;

import java.io.File;

public class PathUtility {
	/**
	 * 依所在的系統, 將混合路徑的分隔號統一, 
	 * @param pathStr
	 * @return
	 */
	public static String normalize(String pathStr) {
		String normalizedPathStr;
		normalizedPathStr = pathStr.replace("/", File.separator).replace("\\", File.separator);
		return normalizedPathStr;
	}
}
