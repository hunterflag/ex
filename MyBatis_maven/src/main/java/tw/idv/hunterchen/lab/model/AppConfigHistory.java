package tw.idv.hunterchen.lab.model;

import java.sql.Timestamp;

//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Setter
@Getter
public class AppConfigHistory{
	private Long id;				// 識別碼
	private String keyName;			// 鍵名
	private String keyValue;		// 鍵值
	
	private Long serialNo;			// 流水號
	private Timestamp createdTime;	// 建立時間
	private Timestamp modifiedTime;	// 異動時間

}
