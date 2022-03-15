package tw.idv.hunterchen.lab.reflection;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Class {

	public static void main(String[] args) {
		Class clazz = Ex_Class.class.getClass();
		DevTool.showAllMembers(clazz);
	}

}
