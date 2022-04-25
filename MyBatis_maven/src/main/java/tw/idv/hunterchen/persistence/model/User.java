package tw.idv.hunterchen.persistence.model;

import java.sql.Date;

public class User {
	private Integer id;
	private String name;
	private Date createdTime;
	private Date modifiedTime;
	

	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime
				+ "]";
	}
	

}
