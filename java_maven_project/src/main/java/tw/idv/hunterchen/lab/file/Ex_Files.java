package tw.idv.hunterchen.lab.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ex_Files {

	public static void main(String[] args) {
//		String pathString=".";
//		String pathString="..";
//		String pathString="/";
//		String pathString="abc";
//		String pathString="./Ex_File.java";
//		String pathString="tw/idv/hunterchen/lab/file/Ex_File.java";

//		String pathString="temp";
		String pathString="src/main/java/tw/idv/hunterchen/lab/file/Ex_File.java";
		
		Path path = Paths.get(pathString);
		log.info("[{}] ", path.toString());
		log.info("[{}] ", path.getParent().toString());
//		log.info("[{}] ", path.getRoot().toString());
		log.info("[{}] ", path.toAbsolutePath().toString());
		if(Files.exists(path)) {
			log.info("[{}] is exist!", pathString);
			
		}else {
			log.info("[{}] is not exist!", pathString);
			
		}
		
	}

}
