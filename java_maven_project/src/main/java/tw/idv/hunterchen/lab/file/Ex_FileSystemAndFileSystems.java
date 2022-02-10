package tw.idv.hunterchen.lab.file;

import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import tw.idv.hunterchen.utility.DevTool;
import tw.idv.hunterchen.utility.StringTool;

public class Ex_FileSystemAndFileSystems {

	public static void main(String[] args) throws URISyntaxException{
		String divider = StringTool.genDivider(10);
		//使用 FileSystems 取得 FileSystem 的方法
		DevTool.showMessages(divider, "取得預設檔案系統", "getDefault()");
		FileSystem fileSystem = FileSystems.getDefault();
		showFileSystem(fileSystem);
		
		DevTool.showMessages("建立指定Path", fileSystem.getPath("d:", "temp", "files").toString());
		DevTool.showMessages("取得所有磁碟機的根目錄 path", "getRootDirectories()", fileSystem.getRootDirectories().toString());

		//		DevTool.showMessages(".", "取得當前路徑的檔案系統 file:");
//		fileSystem = FileSystems.getFileSystem(new URI("."));
//		showFileSystem(fileSystem);

		//使用 FileSystems 建立 新FileSystem 的方法.a
//		fileSystem = FileSystems.getDefault();

		
	}
	
	private static void showFileSystem(FileSystem fileSystem) {
		DevTool.showMessages("原始內容", fileSystem.toString());
		DevTool.showMessages("分隔符號", fileSystem.getSeparator());
		DevTool.showMessages("isOpen()", String.valueOf(fileSystem.isOpen()));
		DevTool.showMessages("isReadOnly()", String.valueOf(fileSystem.isReadOnly()));
	}
}
