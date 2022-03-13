package tw.idv.hunterchen.lab.file;

import java.nio.file.FileStore;
import java.nio.file.Paths;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_FileStore {

	public static void main(String[] args) {
		Iterable<FileStore> fileStores = Paths.get(".").toAbsolutePath().getFileSystem().getFileStores();
		for(FileStore fileStore : fileStores) {
			DevTool.showMessages(fileStore.name());
		}
	}

}
