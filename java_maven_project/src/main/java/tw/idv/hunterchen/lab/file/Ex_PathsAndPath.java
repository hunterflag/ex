package tw.idv.hunterchen.lab.file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import tw.idv.hunterchen.utility.DevTool;
import tw.idv.hunterchen.utility.StringTool;

public class Ex_PathsAndPath {

	public static void main(String[] args) throws URISyntaxException {
		String localBase=".";
		Path path = null;

		// 使用 Paths, 以 String 建立 Path 的方法 x2:
		
		
		
		DevTool.showMessages(StringTool.genDivider("|=>", 10)
				, "使用 Paths 建立 Path .a.路徑字串法"
				// 法.a
				, String.valueOf(path = Paths.get(localBase))						// 相對路徑: 專案資料夾
//				, String.valueOf(path = Paths.get("src"))					
//				, String.valueOf(path = Paths.get(".").toAbsolutePath())
				// 法.b
//				, String.valueOf(path = Paths.get("d:", "temp")) 			
				);
		showPath(path);
		
		try {
			// 建立暫存資料夾
			Path tempPath = Files.createTempDirectory(path, "temp_");
//			Files.createDirectory(path);
			showPath(tempPath);
			Thread.sleep(5000);
			// 清除暫存資料夾
			Files.delete(tempPath);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		// others	
//		path.getFileSystem().getFileStores();

//		DevTool.showMessages(divider, "使用 Paths 建立 Path .b.URI表示法");
//		path = Paths.get(new URI("file://d:/temp/files"));
//		showPath(path);

		//		path = Paths.get(new URI("https://www.google.com"));
		
	}
	
	private static void showPath(Path path) {
		int nameCount;
		DevTool.showMessages(StringTool.genDivider("---", 20));
		DevTool.showMessages("提供的原始 path", path.toString());
		DevTool.showMessages("原始路徑中的層數",	"getNameCount()", String.valueOf(nameCount = path.getNameCount()));
		DevTool.showMessages("是絕對路徑?",			"isAbsolute()"  , String.valueOf(path.isAbsolute()));
		DevTool.showMessages("絕對路徑path(相對路徑時為null)", (path=path.toAbsolutePath()).toString());
		DevTool.showMessages("正規化後的絕對路徑path(相對路徑時為null)", (path=path.normalize()).toString());
		DevTool.showMessages("從根算到絕對	路徑的層數",	"getNameCount()", String.valueOf(nameCount = path.getNameCount()));
		DevTool.showMessages("取得根路徑",			"getRoot()"   , String.valueOf(path.getRoot()));
		for (int i=0; i<nameCount; i++) {
			DevTool.showMessages("取得絕對路徑中的第n個Path的名稱",			"getName("+i+")"   , String.valueOf(path.getName(i)));
		}
		DevTool.showMessages("最後一層(右)的 Path", 		"getFileName()" , String.valueOf(path.getFileName()));
		DevTool.showMessages("取得父層 Path",			"getParent()"   , String.valueOf(path.getParent().getFileName()));
		DevTool.showMessages("取得path所在之檔案系統物件",			"getFileSystem"   , String.valueOf(path.getFileSystem()));
	}
	
	

}
