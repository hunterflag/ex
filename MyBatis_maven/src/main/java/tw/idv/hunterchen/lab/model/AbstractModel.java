package tw.idv.hunterchen.lab.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
//@Slf4j
public class AbstractModel {
	private Integer serialNo;
	
	private Timestamp createdTime;
	private Timestamp modifiedTime;
}
