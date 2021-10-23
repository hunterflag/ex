/**
 * 
 */
package tw.idv.hunterchen.enumeration;

/**
 * @author chenhuanzhang
 * ref: https://matthung0807.blogspot.com/2017/10/java-enum.html
 */
public enum WeekDay {
	SUN("Sunday", 	"星期日", "週日", "日曜"),
	MON("Monday", 	"星期一", "週一", "月曜"),
	TUE("Tuesday", 	"星期二", "週二", "火曜"),
	WED("Wednesday","星期三", "週三", "水曜"),
	THU("Thursday", "星期四", "週四", "木曜"),
	FRI("Friday", 	"星期五", "週五", "金曜"),
	SAT("Saturday", "星期六", "週六", "土曜");
	
	// ==== 每個 property 都是 private final ====
	private final String day;
	private final String chinese;
	private final String taiwanese;
	private final String japanese;
	
	// ==== 每個欄位都要對應到 ====
	WeekDay(String day, String chinese, String taiwanese, String japanese){
		this.day = day;
		this.chinese = chinese;
		this.taiwanese = taiwanese;
		this.japanese = japanese;
	}
	
	// ==== 只有 getter(), 沒有 setter() ====
	public String getDay() {
		return day;
	}

	public String getChinese() {
		return chinese;
	}

	public String getTaiwanese() {
		return taiwanese;
	}

	public String getJapanese() {
		return japanese;
	}
	
	// ==== 方法都要 public static, 因為 enum 不會拿來生成物件 ====
	public static WeekDay getWeek(int i){
		WeekDay result = null;
		switch(i) {
			case 0: result = SUN; break;
			case 1: result = MON; break;
			case 2: result = TUE; break;
			case 3: result = WED; break;
			case 4: result = THU; break;
			case 5: result = FRI; break;
			case 6: result = SAT; break;
		}
		return result;
		
	}
	// ==== ====
	
	
	
}
