package tw.idv.hunterchen.persistence.model;

import java.sql.Date;

import lombok.Data;

@Data
public class UserModel{
	private Integer id;
	private String name;
	private String password;
	private Date createdTime;
	private Date modifiedTime;
}
