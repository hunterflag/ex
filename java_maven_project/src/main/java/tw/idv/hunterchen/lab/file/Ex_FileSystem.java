package tw.idv.hunterchen.lab.file;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_FileSystem {

	public static void main(String[] args) {
		FileSystem defaultFileSystem = FileSystems.getDefault();
		DevTool.showMessages("getDefault()", defaultFileSystem.toString());
		DevTool.showMessages("isOpen()", String.valueOf(defaultFileSystem.isOpen()));
		DevTool.showMessages("isReadOnly()", String.valueOf(defaultFileSystem.isReadOnly()));
//		FileSystem fileSystem = FileSystems.getFileSystem(new URI("."));

	}

}
