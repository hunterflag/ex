package tw.idv.hunterchen.lab.utility;

public class StringUtil {
	public static String repeat(String str, int counter) {
		String result="";
		if (counter > 0) {
			for(int i=0; i<counter; i++) {
				result += str;
			}
		}
		return result;
	}

}
