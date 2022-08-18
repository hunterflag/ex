package tw.idv.hunterchen.lab.file;

import java.io.File;

public class Ex_File_Rename {

	public static void main(String[] args) {
		String source = "d:\\temp\\files\\sample_re.txt";
		String target = "d:\\temp\\files\\newDir2\\sample_re.txt";
		File file = new File(source);
		file.renameTo(new File(target));
	}

}
