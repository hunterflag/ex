package tw.idv.hunterchen.lab.mapper;

import java.util.List;

import tw.idv.hunterchen.lab.model.SysRole;
import tw.idv.hunterchen.lab.model.SysUser;

public interface SysUserMapper {
	List<SysRole> selectRolesByUserId2(Long id);
	List<SysRole> selectRolesByUserId(Long id);
	SysUser selectById(Long id);
	List<SysUser> selectAll();
	int insert(SysUser sysUser);
	int insert2(SysUser sysUser);
	int insert3(SysUser sysUser);
	int updateById(SysUser sysUser);
	int deleteById(Long id);
	
}
