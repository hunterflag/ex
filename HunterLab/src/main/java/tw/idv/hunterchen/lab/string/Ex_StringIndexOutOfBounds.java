package tw.idv.hunterchen.lab.string;

public class Ex_StringIndexOutOfBounds {

	public static void main(String[] args) {
		String str="0123456789";
		System.out.println(str + " 可用 index 為 0 ~ " + str.length());	//1. index 必須 0 <= Index <= 長度
		System.out.println(str.substring(0));
		System.out.println(str.substring(1));
		System.out.println(str.substring(10));				//取不到, 此例相當於 str.substring(10, 10)		
		System.out.println(str.substring(str.length()));
		/* 超界會顯示負值, 但可能是
		 * a) 超過字串長度, 會顯示不足數
		 * b) 小於0, 則是原index值
		 */
//		System.out.println(str.substring(str.length()+1));	//beginIndex > 長度 超界, 顯示不足數(-1), 0 <= Index <= 長度
//		System.out.println(str.substring(str.length()+2));	//超界(-1), 0 <= Index <= 長度
//		System.out.println(str.substring(-1));				//biginIndex < 0, 超界會輸出第一個有問題的 index 值
//		System.out.println(str.substring(-2));				//biginIndex < 0, 超界會輸出第一個有問題的 index 值
		
		/* 超界會顯示負值, 但可能是
		 * a) beginIndex < 0  顯示 beginIndex
		 * b) endIndex > 長度, 顯示不足數
		 * c) beginIndex > endIndex, 顯示反差數 
		 */
		System.out.println(str.substring(0, 0));	//取不到
		System.out.println(str.substring(0, 1));	
		System.out.println(str.substring(1, 1));	//取不到
		System.out.println(str.substring(1, str.length()-1));	//biginIndex < 0
		System.out.println(str.substring(1, str.length()));	//biginIndex < 0
//		System.out.println(str.substring(-2, 12));	
//		System.out.println(str.substring(1, str.length()+1));	//biginIndex < 0
//		System.out.println(str.substring(10, 7));	//biginIndex < 0
	}
}

