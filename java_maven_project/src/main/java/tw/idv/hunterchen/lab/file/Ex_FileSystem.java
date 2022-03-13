package tw.idv.hunterchen.lab.file;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_FileSystem {

	public static void main(String[] args) {
		FileSystem fileSystem = FileSystems.getDefault();
//		DevTool.showAllFields(fileSystem);
//		DevTool.showAllMethods(fileSystem);
		DevTool.showMessages("","", fileSystem.getSeparator());
		DevTool.showMessages("","", fileSystem.getPath(".").toAbsolutePath().toString());
		
	}

}
