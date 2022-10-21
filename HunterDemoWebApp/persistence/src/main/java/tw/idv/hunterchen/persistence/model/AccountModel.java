package tw.idv.hunterchen.persistence.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class AccountModel {
	private Integer id;
	private String name="";
	private String password="1234";
	private Timestamp createdTime;
	private Timestamp modifiedTime;
	/*
	public AccountModel(String name, String password) {
		this.name = name;
		this.password=password;
	};
	*/
}
