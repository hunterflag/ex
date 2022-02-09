package tw.idv.hunterchen.lab.file;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Paths {

	public static void main(String[] args) throws URISyntaxException {
		Path path = Paths.get("d:", "temp");
		show(path);
		//FIXME 使用URI如何表示本機的檔案? 或這只適用在網路上?
		path = Paths.get(new URI("https://www.google.com"));
		show(path);
	}
	
	private static void show(Path path) {
		DevTool.showMessages("自動搭配OS使用分隔符號", path.toString());
		DevTool.showMessages(path.getFileName().toString());
		DevTool.showMessages("是絕對路徑?", String.valueOf(path.isAbsolute()));
	}

}
