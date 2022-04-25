package tw.idv.hunterchen.persistence.model;

import java.sql.Timestamp;

import lombok.Data;

@Data	
// =
//@Setter
//@Getter
//@NoArgsConstructor
//@EqualsAndHashCode
//@ToString
public class AppConfigHistory{
	private Long serialNo;			// 流水號

	private Long id;				// 識別碼
	private String keyName;			// 鍵名
	private String keyValue;		// 鍵值
	
	private Timestamp createdTime;	// 建立時間
	private Timestamp modifiedTime;	// 異動時間

}
