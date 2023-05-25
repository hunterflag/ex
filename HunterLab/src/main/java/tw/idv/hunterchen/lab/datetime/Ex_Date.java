package tw.idv.hunterchen.lab.datetime;

import java.util.Date;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Date {
	public static void demoDate() {
		Date lDate = new Date();
		DevTool.showMessages("timestamp (ms)", String.valueOf(lDate.getTime()));
		DevTool.showMessages("GMT", lDate.toGMTString());
		DevTool.showMessages("當地時間(GMT+時區)CST", lDate.toString());
//		DevTool.showMessages("timestamp", lDate.toString());
		
		
	}
	
	
	
	public static void main(String args[]) {
		demoDate();
	
	
	}
}