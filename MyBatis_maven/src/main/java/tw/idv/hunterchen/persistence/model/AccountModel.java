package tw.idv.hunterchen.persistence.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountModel {
	private Integer id;
	private final String name;
	private final String password;
	private Timestamp createdTime;
	private Timestamp modifiedTime;
	/*
	public AccountModel(String name, String password) {
		this.name = name;
		this.password=password;
	};
	*/
}
