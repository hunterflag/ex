package tw.idv.hunterchen.lab.time;

import java.sql.Date;
import java.text.SimpleDateFormat;

import tw.idv.hunterchen.utility.ShowTool;

public class Ex_Time {

	public static void main(String[] args) {
		ShowTool.showMessages("時間、日期");
		ShowTool.showMessages("java.util.Date", "==================");
		java.util.Date utilDate = new java.util.Date();
		ShowTool.showMessages("現在日期時間", "new Date()", utilDate.toString());
		ShowTool.showMessages("現在日期時間", "getTime()", String.valueOf(utilDate.getTime()));
		ShowTool.showMessages("現在日期時間", "SimpleDateFormat", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
				    						.format(new java.util.Date())
    						);
		ShowTool.showMessages("java.sql.Date", "==================");
		ShowTool.showMessages("產生指定日期", new java.sql.Date(0, 0, 1).toString());
		Date sqlDate = new java.sql.Date(2020);
		
		

	}

}
