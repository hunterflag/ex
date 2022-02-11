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
//				, String.valueOf(path = Paths.get("."))
				, String.valueOf(path = Paths.get(".").toAbsolutePath())
//				, String.valueOf(path = Paths.get("d:", "temp"))
				);
		showPath(path);
		showFiles(path);
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
		DevTool.showMessages(StringTool.genDivider("---", 20));
		DevTool.showMessages("原始 Path", path.toString());
		DevTool.showMessages("自動搭配OS使用分隔符號",	"toString()"	, path.toString());
		DevTool.showMessages("是絕對路徑?",			"isAbsolute()"  , String.valueOf(path.isAbsolute()));
		DevTool.showMessages("最後(右)的 Path", 		"getFileName()" , String.valueOf(path.getFileName()));
		DevTool.showMessages("從根算到當前Path的層數",	"getNameCount()", String.valueOf(path.getNameCount()));
		DevTool.showMessages("取得上層 Path",			"getParent()"   , String.valueOf(path.getParent().getFileName()));
	}
	
	private static void showFiles(Path path) {
		DevTool.showMessages(StringTool.genDivider("---", 20));
		DevTool.showMessages("存在嗎?", 	"exists()",		String.valueOf((Files.exists(path, LinkOption.NOFOLLOW_LINKS))));
		DevTool.showMessages("不存在嗎?", "notExists()",	String.valueOf((Files.notExists(path, LinkOption.NOFOLLOW_LINKS))));
		DevTool.showMessages("資料夾嗎?", 	"isDirectory()", 	String.valueOf((Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))));
		DevTool.showMessages("是檔案嗎?", 	"isRegularFile()", 	String.valueOf((Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS))));
		DevTool.showMessages("是link嗎?",	"isSymbolicLink()",	String.valueOf((Files.isSymbolicLink(path))));
		DevTool.showMessages("可讀嗎?", 	"isReadable()", 	String.valueOf((Files.isReadable(path))));
		DevTool.showMessages("可寫嗎?", 	"isWritable()", 	String.valueOf((Files.isWritable(path))));
		DevTool.showMessages("可執行嗎?", "isExecutable()", 	String.valueOf((Files.isExecutable(path))));
		try {
			DevTool.showMessages("檔案大小(資料夾固定為4096)", String.valueOf(Files.size(path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		DevTool.showMessages("可執行嗎?", "isExecutable()", 	String.valueOf((Files.getFileStore(path).)));
		
	}

}
