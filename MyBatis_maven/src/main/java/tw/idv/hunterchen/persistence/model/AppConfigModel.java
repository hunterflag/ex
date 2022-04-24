package tw.idv.hunterchen.lab.model;

import java.sql.Timestamp;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
//@Setter
//@Getter
public class AppConfigModel{
	private Long	 	id;				// 識別碼
	private String 		keyName;		// 鍵名
	private String 		keyValue;		// 鍵值
	
	private Timestamp 	createdTime;	// 建立時間
	private Timestamp 	modifiedTime;	// 異動時間

}