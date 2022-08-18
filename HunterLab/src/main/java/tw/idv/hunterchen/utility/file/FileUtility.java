package tw.idv.hunterchen.utility.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

import org.dom4j.util.StringUtils;

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
	/**
	 * 
	 * @param folder
	 * @return
	 */
	public static boolean forceRemoveFolder(String folder) {
		boolean isClean = false;
		folder = (folder!=null) ? folder : "";
		Path path = Paths.get(folder);
		if ( !folder.isEmpty() && Files.exists(path) && Files.isDirectory(path) ) {
			try {
				Files.walkFileTree(path,
					      new SimpleFileVisitor<Path>() {
					         // 先去遍歷刪除檔案
					         @Override
					         public FileVisitResult visitFile(Path file,
					                                  BasicFileAttributes attrs) throws IOException {
					            Files.delete(file);
					            System.out.printf("檔案被刪除 : %s%n", file);
					            return FileVisitResult.CONTINUE;
					         }
					         // 再去遍歷刪除目錄
					         @Override
					         public FileVisitResult postVisitDirectory(Path dir,
					                                         IOException exc) throws IOException {
					            Files.delete(dir);
					            System.out.printf("資料夾被刪除: %s%n", dir);
					            return FileVisitResult.CONTINUE;
					         }

					      } //end of new()
					   );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isClean = true;
		}
		return isClean;
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
	/**
	 * @return 0+ 總共刪除檔案數量
	 * 			null 未傳參數
	 * 			-1 檔案不存在
	 */
	public FileUtilityMessage deleteAllFilesInFolder(String folder) {
		FileUtilityMessage result = null;
		if(folder==null) {
			result = FileUtilityMessage.NO_PARAMETER;
		} else if(folder.isEmpty()) {
			result = FileUtilityMessage.INVALID_PARAMETER;
		} else{
			Path folderPath = Paths.get(folder);
			if (Files.isRegularFile(folderPath)){
				result = FileUtilityMessage.NOT_FOLDER;	
			} else {
				try {
					Stream<Path> pathList = Files.list(folderPath);
					pathList.forEach(path -> {
							try {
								Files.delete(path);
							} catch (IOException e) {
								e.printStackTrace();
							}
						});
					pathList.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
//				pathList.forEach(path -> {;});
			result = FileUtilityMessage.FINISHED;
			}
		}
		return result;
	}
}
