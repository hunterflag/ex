package tw.idv.hunterchen.lab.file;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import tw.idv.hunterchen.utility.DevTool;
import tw.idv.hunterchen.utility.StringTool;

public class Ex_PathAndPaths {

	public static void main(String[] args) throws URISyntaxException {
		String divider = StringTool.genDivider(10);
		Path path = null;

		DevTool.showMessages(divider, "使用 Paths 建立 Path .a.路徑字串法");
//		path = Paths.get(".");
		path = Paths.get("d:", "temp");
		showPath(path);
		path = Paths.get("..", ".", "temp");
		showPath(path);
		
//		DevTool.showMessages(divider, "使用 Paths 建立 Path .b.URI表示法");
//		path = Paths.get(new URI("file://d:/temp/files"));
//		showPath(path);

		//		path = Paths.get(new URI("https://www.google.com"));
		
	}
	
	private static void showPath(Path path) {
		DevTool.showMessages("原始 Path", path.toString());
		DevTool.showMessages("自動搭配OS使用分隔符號"  , "toString()"	, path.toString());
		DevTool.showMessages("是絕對路徑?"			  , "isAbsolute()"  , String.valueOf(path.isAbsolute()));
		DevTool.showMessages("最後(右)的 Path"	  , "getFileName()" , String.valueOf(path.getFileName()));
		DevTool.showMessages("從根目錄算起的 Path 層數", "getNameCount()", String.valueOf(path.getNameCount()));
		DevTool.showMessages("取得上層 Path"	      , "getParent()"   , String.valueOf(path.getParent().getFileName()));
		
	}

}
