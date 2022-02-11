package tw.idv.hunterchen.lab.file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.text.NumberFormat;
import java.util.Iterator;

import tw.idv.hunterchen.utility.DevTool;
import tw.idv.hunterchen.utility.StringTool;

public class Ex_FileSystemAndFileSystems {

	public static void main(String[] args) throws URISyntaxException{
		FileSystem fileSystem;

		DevTool.showMessages( StringTool.genDivider("|=>", 10)
				, "使用 FileSystems 取得預設檔案系統"
				, "getDefault()"
				, String.valueOf(fileSystem = FileSystems.getDefault())
				);
		showFileSystem(fileSystem);
		showFileStores(fileSystem);
		
//		DevTool.showMessages("建立指定Path", fileSystem.getPath("d:", "temp", "files").toString());
//		DevTool.showMessages("取得所有磁碟機的根目錄 path", "getRootDirectories()", fileSystem.getRootDirectories().toString());

		//		DevTool.showMessages(".", "取得當前路徑的檔案系統 file:");
//		fileSystem = FileSystems.getFileSystem(new URI("."));
//		showFileSystem(fileSystem);

		//使用 FileSystems 建立 新FileSystem 的方法.a
//		fileSystem = FileSystems.getDefault();

		
	}
	
	private static void showFileSystem(FileSystem fileSystem) {
		DevTool.showMessages("原始內容", 		"toString()",			fileSystem.toString());
		DevTool.showMessages("分隔符號", 		"getSeparator()", 		fileSystem.getSeparator());
		DevTool.showMessages("已開啟?",		"isOpen()", 			String.valueOf(fileSystem.isOpen()));
		DevTool.showMessages("唯讀嗎?",		"isReadOnly()", 		String.valueOf(fileSystem.isReadOnly()));
		DevTool.showMessages("取出所有根path",	"getRootDirectories()", String.valueOf(fileSystem.getRootDirectories()));
	}
	
	private static void showFileStores(FileSystem fileSystem) {
		Iterable<FileStore> fileStores = fileSystem.getFileStores();
		
		Iterator<FileStore> iterator = fileStores.iterator();
		while (iterator.hasNext()) {
			FileStore fileStore = iterator.next();
			showFileStore(fileStore);
		}
	}
	private static void showFileStore(FileStore fileStore) {
		DevTool.showMessages(StringTool.genDivider("...", 100));
		DevTool.showMessages("儲存器的名稱與代號", 	"toString()",	fileStore.toString());
		DevTool.showMessages("儲存器的名稱", 		"name()", 		fileStore.name());
		DevTool.showMessages("儲存器使用的檔案系統", "type()", 		fileStore.type());
		
		DevTool.showMessages("唯讀嗎?", "isReadOnly()", String.valueOf(fileStore.isReadOnly()));
		
		try {
			DevTool.showMessages("總容量", 		"getTotalSpace()",			NumberFormat.getNumberInstance().format(fileStore.getTotalSpace()));
			DevTool.showMessages("未配置容量",		"getUnallocatedSpace()",	NumberFormat.getNumberInstance().format(fileStore.getUnallocatedSpace()));
			DevTool.showMessages("JVM可用容量",	"getUsableSpace()",			NumberFormat.getNumberInstance().format(fileStore.getUsableSpace()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
