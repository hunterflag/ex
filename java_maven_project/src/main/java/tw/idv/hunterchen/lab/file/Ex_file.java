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
		File file = new File("/Users/chenhuanzhang/temp/exFile.txt");
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

