package tw.idv.hunterchen.lab.model;

public class SysUserRole {
	private Long roleId;
	private Long privilegeId;

	public Long getUserId() {
		return privilegeId;
	}
	public void setUserId(Long userId) {
		this.privilegeId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}
