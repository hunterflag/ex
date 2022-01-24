package tw.idv.hunterchen.utility;

public class GenString {
	/**
	 * 用來產生1組分隔字串, 預設是 "<======>"
	 * @param header 當作分隔字串的頭部, 必須、且只使用1次, 預設為 "<"
	 * @param body 當作分隔字串的中間部, 將以此補到總長度為止 , 預設為 "="
	 * @param tailer 當作分隔字串的尾部, 必須、且只使用1次, 預設為 ">"
	 * @param length 分隔字串的總長度, 預設為 8
	 * @return
	 */
	public static String divider() {
		return divider(null, null, null, null);
	}
	public static String divider(Integer length) {
		return divider(null, null, null, length);
	}
	public static String divider(String header, String body, String tailer) {
		return divider(header, body, tailer, null);
	}
	public static String divider(String header, String body, String tailer, Integer length) {
		String defaultHeader="<";
		String defaultBody="=";
		String defaultTailer=">";
		Integer defaultLength = 8;
		header = (header == null) ? defaultHeader : header ; 
		body = (body == null) ? defaultBody : body ;
		tailer = (tailer == null) ? defaultTailer : tailer ; 
		int minLength = header.length() + tailer.length();
		/* length = ((length == null ? defaultLength : length) < minLength) ? minLength : length; 
		 * 此寫法的問題是: 
		 * 0. length 是 null 時
		 * 1. 內層的三元運算子會得到 defaultLength, 
		 * 2. 在外層的三元運算子可能會得到 length
		 * 3. 但此時的 length 還是 null (尚未經過 assign)
		 * 4. 所以, 最後 assign 就是 null囉!
		 * */
		length = (length == null) ? defaultLength : length ;
		length = (length < minLength) ? minLength : length; 

		String result = "";
		
		int bodyQuitient = (length - minLength) / body.length();
		int bodyRemainder = (length - minLength) % body.length();
		
		bodyQuitient = (bodyQuitient < 0) ? 0 :bodyQuitient ;
		result += header;
		for (int i=0; i<bodyQuitient; i++) {
			result += body;
		}
		if (bodyRemainder != 0) {
			for(int i=0; i< bodyRemainder; i++) {
				result += body.charAt(i);
			}
		}
		result += tailer;
			
		return result;
	}
}
