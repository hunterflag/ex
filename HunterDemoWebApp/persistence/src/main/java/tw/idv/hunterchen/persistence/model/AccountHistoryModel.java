package tw.idv.hunterchen.persistence.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class AccountHistoryModel {
	private Integer serialNo;
	private Integer id;
	private String name;
	private String password;
	private Boolean deletedFlag;
	private Boolean modifiableFlag;
	private Date createdTime;
	private Timestamp modifiedTime;

	public AccountHistoryModel(String name) {
		this.name		= name;
		this.password 	= name;
//		new AccountModel(name, name); 	// 建構式不能像一般方法的疊套使用, 因為此時還沒建立物件, 所以自然也沒有建構這個方法也不存在
	};
	public AccountHistoryModel(String name, String password) {
		this.name		= name;
		this.password 	= password;
	};
}
