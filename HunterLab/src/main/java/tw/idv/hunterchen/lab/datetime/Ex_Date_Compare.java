package tw.idv.hunterchen.lab.datetime;

import java.sql.Date;
import java.text.SimpleDateFormat;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Date_Compare {

	public static void main(String[] args) {
		DevTool.showMessages("時間、日期");
		DevTool.showMessages("java.util.Date", "==================");
		java.util.Date utilDate = new java.util.Date();
		DevTool.showMessages("現在日期時間", "new Date()", utilDate.toString());
		DevTool.showMessages("現在日期時間", "getTime()", String.valueOf(utilDate.getTime()));
		DevTool.showMessages("現在日期時間", "SimpleDateFormat", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
				    						.format(new java.util.Date())
    						);
		DevTool.showMessages("java.sql.Date", "==================");
		DevTool.showMessages("產生指定日期", new java.sql.Date(0, 0, 1).toString());
		Date sqlDate = new java.sql.Date(2020);
		
		

	}

}
