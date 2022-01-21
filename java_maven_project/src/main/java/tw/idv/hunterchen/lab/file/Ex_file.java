package tw.idv.hunterchen.lab.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex_file {

	private static FileInputStream fileInputStream;

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
//		String fileName="/Users/chenhuanzhang/temp/exFile.txt";
		
//		String fileName="d:/temp/files/temp.txt";
//		String folderName="d:/temp/files/temp.txt";
		String folderName="d:/temp/files";
		
		File folder = new File(folderName);
		if (folder.isDirectory()) {
			System.out.println(folder.getName() + " is a Directory!" );
		}else{
			System.out.println(folder.getName() + " is a file!" );
			
		};
		String[] fileList = folder.list();
		int fileCounter = fileList.length;
		
		if (fileCounter != 0) {
			for (int i=0; i<fileCounter; i++) {
				System.out.printf("%d:%s%n", i, fileList[i]);
			}
		}else {
			System.out.println("no file");
		}
		/*
		File file = new File(fileName);
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
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

