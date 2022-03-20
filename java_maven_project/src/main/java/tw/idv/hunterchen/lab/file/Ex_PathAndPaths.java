package tw.idv.hunterchen.lab.file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import tw.idv.hunterchen.utility.DevTool;
import tw.idv.hunterchen.utility.StringTool;

public class Ex_PathAndPaths {

	public static void main(String[] args) throws URISyntaxException {
		Path path = null;

		DevTool.showMessages(StringTool.genDivider("|=>", 10)
				, "使用 Paths 建立 Path .a.路徑字串法"
//				, String.valueOf(path = Paths.get("src"))
				, String.valueOf(path = Paths.get("."))
//				, String.valueOf(path = Paths.get(".").toAbsolutePath())
//				, String.valueOf(path = Paths.get("d:", "temp"))
				);
		showPath(path);
//		path.getFileSystem().getFileStores();

//		DevTool.showMessages(StringTool.genDivider("...", 20));
//		path = Paths.get("d:", "temp", "files", "sample.json");
//		showPath(path);
//		showFiles(path);
//		
//		DevTool.showMessages(StringTool.genDivider("...", 20));
//		path = Paths.get("d:", "Program Files");
//		showPath(path);
//		showFiles(path);
//		
//		DevTool.showMessages(StringTool.genDivider("...", 20));
//		path = Paths.get("d:", "hunter");
//		showPath(path);
//		showFiles(path);
//		
//		DevTool.showMessages(StringTool.genDivider("...", 20));
//		path = Paths.get("c:", "Windows");
//		showPath(path);
//		showFiles(path);
		
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
		DevTool.showMessages("從根算到絕對路徑的層數",	"getNameCount()", String.valueOf(nameCount = path.getNameCount()));
		DevTool.showMessages("取得根路徑",			"getRoot()"   , String.valueOf(path.getRoot()));
		for (int i=0; i<nameCount; i++) {
			DevTool.showMessages("取得絕對路徑中的第n個Path的名稱",			"getName("+i+")"   , String.valueOf(path.getName(i)));
		}
		DevTool.showMessages("最後一層(右)的 Path", 		"getFileName()" , String.valueOf(path.getFileName()));
		DevTool.showMessages("取得父層 Path",			"getParent()"   , String.valueOf(path.getParent().getFileName()));
		DevTool.showMessages("取得path所在之檔案系統物件",			"getFileSystem"   , String.valueOf(path.getFileSystem()));
	}
	
	

}
