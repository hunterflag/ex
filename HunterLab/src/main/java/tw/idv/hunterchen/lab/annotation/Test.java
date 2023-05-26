package tw.idv.hunterchen.lab.annotation;

import tw.idv.hunterchen.utility.DevTool;

public class Test {
	
	@TestAnnotation(multiValues={"ddd","wee"})
	public static void main(String[] args) {
		DevTool.showMessages("Hello @nnotation");
		if (args !=null) {	// 陣列一宣告, 變數就存在, null 的是上未定義的陣列值索引值			
			if (args.length != 0) {
				DevTool.showMessages("args[]:", args[0]);			
			}
		}

	}

}
