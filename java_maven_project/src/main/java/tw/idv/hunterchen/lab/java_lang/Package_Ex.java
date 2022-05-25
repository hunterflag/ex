package tw.idv.hunterchen.lab.java_lang;

import tw.idv.hunterchen.utility.DevTool;

public class Package_Ex {

	public static void main(String[] args) {
		Package package1 = Package.getPackage("java.lang");
		DevTool.showAllMembers(package1);
		DevTool.showMessages("getName()", package1.getName());
	}

}
