package tw.idv.hunterchen.lab.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import tw.idv.hunterchen.utility.StringTool;
import tw.idv.hunterchen.utility.DevTool;

import java.util.Date;

public class Ex_Path {

	private static FileInputStream fileInputStream;

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		showCurrentPath();
		/* File: 
		 * 1.『檔案/資料夾名稱』在JVM中的代表物件, 是『名稱』的抽象代表, 
		 * 2. 到底是檔案、或資料夾, 需要以此名稱去查詢, 
		 * 3. 存在的話, 此名稱就可代表該/資料夾
		 * 4. 但也可能不存在; 此時. 即可以此名稱, 建立新的檔案/資料夾
		 */
		
		/*
		 * // File.createTempFile("AAA", ".ttt", new
		 * File("/Users/chenhuanzhang/temp/")); // File.createTempFile("AAA", ".sss");
		 * 
		 * File[] listRoots = File.listRoots(); for (File root : listRoots) {
		 * ShowTool.showMessages(root.getName()); }
		 */
		
		String osName=System.getProperty("os.name");
		String strDiv = StringTool.genDivider(16);
		String pathName = "/";

		DevTool.showMessages(strDiv, "作業系統是 "+osName, "其分隔字元為", strDiv);
		DevTool.showMessages("路徑的分隔字元(字串形式)", "pathSeparator", "'"+File.pathSeparator+"'");
		DevTool.showMessages("路徑的分隔字元", "pathSeparatorChar", "'"+String.valueOf(File.pathSeparatorChar)+"'");
		DevTool.showMessages("名稱的分隔字元(字串形式)", "Separator", File.separator);
		DevTool.showMessages("名稱的分隔字元", "SeparatorChar", String.valueOf(File.separatorChar));

		switch (osName) {
			case "Mac OS X":
//				pathName = "/Users/chenhuanzhang/temp/newDir2";
//				pathName = "/Users/chenhuanzhang/temp/newDir2/ddd";
				pathName = "/Users/chenhuanzhang/temp/../temp/zLab";
//				pathName = "/Users/chenhuanzhang/temp/zLab";
//				pathName = "/Users/chenhuanzhang/temp/";
//				pathName = "/Users/chenhuanzhang/";
//				pathName = "/Users/chenhuanzhang/temp/:/Users/chenhuanzhang/";
//				pathName = ".";	//當前路徑：指『專案資料夾』
//				pathName = "~/temp/";	// 不是 / 開頭, 就是相對路徑
//				pathName = "./temp/";	// 不是 / 開頭, 就是相對路徑
//				pathName = "temp/";	// 不是 / 開頭, 就是相對路徑
//				pathName = "/Users/chenhuanzhang/temp/exFile.txt";
				//在mac中, \ 不會自動轉換成 /
//				pathName = "\\Users\\chenhuanzhang\\temp\\..\\temp\\zLab";
//				pathName = "\\Users\\chenhuanzhang\\temp\\zLab";
//				pathName = "/Users\\chenhuanzhang\\temp\\zLab";
				break;
			case "Windows 10":
				//在Windowsc中, / 會自動轉換成 \
				pathName = "d:/temp/files/../files/temp.sample.txt";
				// pathName="d:/temp/files/temp.txt";
				// pathName="d:/temp/files";
				// pathName = "d:/temp/files";
				break;
			default:
		}
		Path path = Paths.get(pathName);
		Paths.
		DevTool.showMessages(strDiv, "原始路徑名稱", "pathName", path.toString(), strDiv);
		DevTool.showMessages("原始名稱是否為絕對路徑?", "isAbsolute()", String.valueOf(path.isAbsolute()));
		
		DevTool.showMessages(strDiv, "原始路徑 轉換成 File(抽象路徑檔名)後, 名稱分隔號會與 OS 相同", strDiv);
		//VS 看不出差異
		DevTool.showMessages("原始名稱的路徑", "toString() ", path.toString());
		DevTool.showMessages("原始名稱的路徑", "toFile()   ", String.valueOf(path.toFile()));
		DevTool.showMessages("路徑", "getFileSystem()   ", String.valueOf(path.getFileSystem()));
		/*
		ShowTool.showMessages("最後(右邊)１個pathName", "getName()", String.valueOf(path.getName()));
		//VS 看不出差異
		ShowTool.showMessages("原始名稱上的父層路徑", "getParent()     ", String.valueOf(path.getParent()));
		ShowTool.showMessages("原始名稱上的父層路徑", "getParentFile() ", String.valueOf(path.getParentFile()));
		ShowTool.showMessages(strDiv, "從原始名稱的相對路徑組合成絕對路徑", strDiv);
		//VS 看不出差異
		ShowTool.showMessages("系統絕對路徑檔案", "getAbsoluteFile()", String.valueOf(path.getAbsoluteFile()));
		ShowTool.showMessages("抽象絕對路徑檔案", "getAbsolutePath()", String.valueOf(path.getAbsolutePath()));
		ShowTool.showMessages("路徑檔案", "getPath()", String.valueOf(path.getPath()));
		
		//VS 看不出差異
		ShowTool.showMessages("絕對路徑轉換成URI路徑", "toURI()", String.valueOf(path.toURI()));
		ShowTool.showMessages("絕對路徑轉換成URL路徑", "toURL()", String.valueOf(path.toURL()));

		ShowTool.showMessages(strDiv, "原始路徑 轉換成 標準/精簡/絕對/抽象路徑", strDiv);
		ShowTool.showMessages("系統標準/精簡路徑檔案", "getCanonicalFile()", String.valueOf(path.getCanonicalFile()));
		ShowTool.showMessages("抽象標準/精簡路徑檔案", "getCanonicalPath()", String.valueOf(path.getCanonicalPath()));
		ShowTool.showMessages("hashCode() ", Integer.toHexString(path.hashCode()));
		ShowTool.showMessages("抽象路徑的長度","length()", String.valueOf(path.length()));
		ShowTool.showMessages("絕對路徑的字元數", "getCanonicalPath()", String.valueOf( path.getCanonicalPath().length()));
		 */
		
		/*
		if (!path..exists()) {
			ShowTool.showMessages(strDiv, "指定路徑不存在時", strDiv);
			ShowTool.showMessages("mkdir()",
					String.valueOf(new File(path.getParent().toString() + "/newDir2/ddd").mkdir()));
			ShowTool.showMessages("mkdirs()",
					String.valueOf(new File(path.getParent().toString() + "/newDir2/ddd").mkdirs()));
			ShowTool.showMessages("mkdirs()",
					String.valueOf(new File(path.getParent().toString() + "/newDir2/ddd").mkdirs()));
		} else {
//			ShowTool.showMessages(strDiv, "指定路徑存在時", strDiv);
//
//			ShowTool.showMessages(strDiv, "存在各種屬性", strDiv);
//			ShowTool.showMessages("canExecute()", String.valueOf(path.canExecute()));
//			ShowTool.showMessages("canRead()   ", String.valueOf(path.canRead()));
//			ShowTool.showMessages("canWrite()  ", String.valueOf(path.canWrite()));
//			ShowTool.showMessages("exists()    ", String.valueOf(path.exists()));
//			ShowTool.showMessages("isHidden()  ", String.valueOf(path.isHidden()));
//			ShowTool.showMessages("lastModified()",
//			String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(path.lastModified()))));
//
//			ShowTool.showMessages(strDiv, "所屬硬碟空間資訊", strDiv);
//			ShowTool.showMessages("所屬硬碟全部總空間", "getTotalSpace() " , String.valueOf(NumberFormat.getInstance().format(path.getTotalSpace())));
//			ShowTool.showMessages("所屬硬碟未使用空間", "getUsableSpace()" , String.valueOf(new DecimalFormat().format(path.getUsableSpace())));
//			ShowTool.showMessages("所屬硬碟已使用空間", "                " , String.valueOf(NumberFormat.getInstance().format(path.getTotalSpace()-path.getUsableSpace())));

			// 依檔案或資料夾分別顯示
			if (path.isDirectory() && !(path.isFile())) {
				ShowTool.showMessages(strDiv, path.getName(), "為資料夾", strDiv);

//			XXX FileFilter fileFilter = new FileFilter();
				String[] fileList = path.list();
				int fileCounter = fileList.length;

				if (fileCounter != 0) {
					ShowTool.showMessages(strDiv, path.getName() + " 資料夾下有 "+fileCounter+" 個檔案或資料夾", strDiv);
					for (int i = 0; i < fileCounter; i++) {
						System.out.printf("%d:%s%n", i, fileList[i]);
					}
				} else {
					ShowTool.showMessages(strDiv, path.getName() + " 資料夾下沒有檔案", strDiv);
				}
			} else {
				ShowTool.showMessages(strDiv, path.getName(), "為檔案", strDiv);
				ShowTool.showMessages("space. ", String.valueOf(path.getAbsoluteFile()), "絕對路徑檔案");
				try {
					FileInputStream fileInputStream = new FileInputStream(path);
					System.out.println("file real size (Bytes): " + fileInputStream.available());
					// TODO read from file

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fileInputStream != null) {
						fileInputStream.close();
					}
				}

			}

			
			/*
			 * File file = new File(fileName);
			 */
//		showFields(file);
//		showMethods(file);
//		}
	
	}
	

	public static void showCurrentPath() {
		DevTool.showMessages("目前路徑", Paths.get(".").toAbsolutePath().toString());
	}
	
	public static void showAllMembers(Object object) {
		showAllFields(object);
		showAllMethods(object);
	}
	
	public static void showAllFields(Object object) {
		Field[] declaredFields = object.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
	}

	public static void showAllMethods(Object object) {
		Method[] declaredMethods = object.getClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName() + "()");
		}
	}

}
