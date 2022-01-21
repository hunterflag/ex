package tw.idv.hunterchen.lab.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import tw.idv.hunterchen.utility.ShowTool;

public class Ex_file {

	private static FileInputStream fileInputStream;

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		/*
//		File.createTempFile("AAA", ".ttt", new File("/Users/chenhuanzhang/temp/"));
//		File.createTempFile("AAA", ".sss");
		
		File[] listRoots = File.listRoots();
		for (File root : listRoots) {
			ShowTool.showMessages(root.getName());
		}
		*/
		
		String pathName="/Users/chenhuanzhang/temp/exFile.txt";
//		String pathName="/Users/chenhuanzhang/temp/";
		
//		String fileName="d:/temp/files/temp.txt";
//		String folderName="d:/temp/files/temp.txt";
//		String pathName="d:/temp/files";
		File path = new File(pathName);

		ShowTool.showMessages("pathName  ", String.valueOf(pathName), "原始名稱");
		ShowTool.showMessages("getName() ", String.valueOf(path.getName()), "最後(右邊)１個pathName" );
		ShowTool.showMessages("isAbsolute() ", String.valueOf(path.isAbsolute()), "原始名稱是否採絕對路徑");
		
		ShowTool.showMessages("getAbsoluteFile() ", String.valueOf(path.getAbsoluteFile()), "系統絕對路徑檔案");
		ShowTool.showMessages("getAbsolutePath() ", String.valueOf(path.getAbsolutePath()), "抽象絕對路徑檔案");
		ShowTool.showMessages("getPath()  		 ", String.valueOf(path.getPath()), "路徑");

		/*
		 */
		ShowTool.showMessages("toURI()    ", String.valueOf(path.toURI()), "轉成URI路徑");
		ShowTool.showMessages("toURL() 	  ", String.valueOf(path.toURI()), "轉成URL路徑");
		ShowTool.showMessages("toString() ", String.valueOf(path.toString()), "路徑");
		ShowTool.showMessages("toPath()   ", String.valueOf(path.toPath()), "路徑");

		ShowTool.showMessages("getParent()     ", String.valueOf(path.getParent()), "父層路徑");
		ShowTool.showMessages("getParentFile() ", String.valueOf(path.getParentFile()), "父層路徑檔案");
		ShowTool.showMessages("getParentFile() ", String.valueOf(path.getParentFile()), "父層路徑檔案");
		
		/*
		 */
		ShowTool.showMessages("canExecute()", String.valueOf(path.canExecute()));
		ShowTool.showMessages("canRead()   ", String.valueOf(path.canRead()));
		ShowTool.showMessages("canWrite()  ", String.valueOf(path.canWrite()));
		ShowTool.showMessages("exists()    ", String.valueOf(path.exists()));
		ShowTool.showMessages("isHidden()  ", String.valueOf(path.isHidden()));
		ShowTool.showMessages("lastModified()", String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(path.lastModified()))));
		
		/* 空間
		 */
		ShowTool.showMessages("getTotalSpace()  ", String.valueOf(path.getTotalSpace()));
		ShowTool.showMessages("getUsableSpace() ", String.valueOf(path.getUsableSpace()));
		
		/*
		 */
		ShowTool.showMessages("hashCode() ", String.valueOf(path.hashCode()));
		ShowTool.showMessages("length()parent. ", String.valueOf(path.length()));

		
		ShowTool.showMessages("mkdir()", String.valueOf(new File(path.getParent().toString()+"/newDir2/ddd").mkdir()));
		ShowTool.showMessages("mkdirs()", String.valueOf(new File(path.getParent().toString()+"/newDir2/ddd").mkdirs()));
		ShowTool.showMessages("mkdirs()", String.valueOf(new File(path.getParent().toString()+"/newDir2/ddd").mkdirs()));

		
		
		if (path.isDirectory() && !(path.isFile())) {
			System.out.println(path.getName() + " is a Directory!" );

	
//			XXX FileFilter fileFilter = new FileFilter();
			String[] fileList = path.list();
			int fileCounter = fileList.length;
			
			if (fileCounter != 0) {
				for (int i=0; i<fileCounter; i++) {
					System.out.printf("%d:%s%n", i, fileList[i]);
				}
			}else {
				System.out.println("no file");
			}
		}else{
			System.out.println(path.getName() + " is a file!" );
			ShowTool.showMessages("space. ", String.valueOf(path.getAbsoluteFile()), "絕對路徑檔案");
			try {
				FileInputStream fileInputStream = new FileInputStream(path);
				System.out.println("file real size (Bytes): "+fileInputStream.available());
				//TODO read from file
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			}
			
		};

		/*
		File file = new File(fileName);
		*/
//		showFields(file);
//		showMethods(file);
		
	}
	
	public static void showFields(Object object) {
		Field[] declaredFields = object.getClass().getDeclaredFields();
		
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
	}
	
	public static void showMethods(Object object) {
		Method[] declaredMethods = object.getClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName()+"()");
		}
	}

}

