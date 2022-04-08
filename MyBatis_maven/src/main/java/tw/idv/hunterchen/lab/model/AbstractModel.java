package tw.idv.hunterchen.lab.model;

import java.sql.Timestamp;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class AbstractModel {
	private Integer serialNo;
	
	private Timestamp createdTime;
	private Timestamp modifiedTime;
}
