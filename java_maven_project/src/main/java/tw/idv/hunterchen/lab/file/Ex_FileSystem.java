package tw.idv.hunterchen.lab.file;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import tw.idv.hunterchen.utility.ShowTool;

public class Ex_FileSystem {

	public static void main(String[] args) {
		FileSystem defaultFileSystem = FileSystems.getDefault();
		ShowTool.showMessages("getDefault()", defaultFileSystem.toString());
		ShowTool.showMessages("isOpen()", String.valueOf(defaultFileSystem.isOpen()));
		ShowTool.showMessages("isReadOnly()", String.valueOf(defaultFileSystem.isReadOnly()));
//		FileSystem fileSystem = FileSystems.getFileSystem(new URI("."));

	}

}
