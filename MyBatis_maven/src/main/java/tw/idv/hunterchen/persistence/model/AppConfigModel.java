package tw.idv.hunterchen.persistence.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AppConfigModel{
	private Integer	 	serialNo;		// 流水號
	private String 		scope;			// 使用範圍
	private String 		keyName;		// 鍵名
	private String 		keyValue;		// 鍵值
	
	private Timestamp 	createdTime;	// 建立時間
	private Timestamp 	modifiedTime;	// 異動時間

}
