package tw.idv.hunterchen.lab.model;

public class Member {
	// field
	private Integer serialNo;
	private String account;
	private String password = "1111";
	
	// constructor
	public Member() {
		// TODO Auto-generated constructor stub
	}
	// setter() & getter()
	public Integer getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
