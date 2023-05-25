package tw.idv.hunterchen.lab.datetime;

import java.time.Instant;
import java.util.Date;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Instant {

	public static void main(String[] args) {
		
		DevTool.showMessages("就是 Timestamp (豪秒)", String.valueOf(System.currentTimeMillis()));
		
		Instant lNow = Instant.now();
		DevTool.showMessages("就是 Timestamp (秒)", String.valueOf(lNow.getEpochSecond()));
		DevTool.showMessages("就是 Timestamp (豪秒)", String.valueOf(lNow.toEpochMilli()));
		DevTool.showMessages("以奈秒顯示秒下部分", String.valueOf(lNow.getNano()));

		Date lDate = new Date();
		DevTool.showMessages("就是 Timestamp (豪秒)", String.valueOf(lDate.getTime()));
				
		DevTool.showMessages("就是 UTC (ISO-8601)", lNow.toString());
	}

}
