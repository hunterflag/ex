package tw.idv.hunterchen.lab.java_lang;

import tw.idv.hunterchen.utility.DevTool;
import tw.idv.hunterchen.utility.StringTool;

public class ClassLoader_Ex {

	public static void main(String[] args) {
		ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
		DevTool.showAllFields(platformClassLoader);
//		DevTool.showAllMethods(platformClassLoader);
		showClassLoader(platformClassLoader);
		
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//		DevTool.showAllFields(systemClassLoader);
//		DevTool.showAllMethods(systemClassLoader);
		showClassLoader(systemClassLoader);
	
		
		
	}
	
	static void showClassLoader(ClassLoader cl) {
		DevTool.showMessages(StringTool.genDivider(50));
		DevTool.showMessages("getName()", cl.getName());
		DevTool.showMessages("getParent()", cl.getParent()==null ? "null" : cl.getParent().getName());
		
		
	}
	

}
