package tw.idv.hunterchen.lab.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tw.idv.hunterchen.lab.model.SysUser;

public class SysUserMapperTest extends BaseMapperTest{
		
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
//			List<Country> countryList = sqlSession.selectList("tw.idv.hunterchen.lab.mapper.CountryMapper.selectAll");
			List<SysUser> sysUserList = sqlSession.selectList("tw.idv.hunterchen.lab.mapper.SysUserMapper.selectAll");
//			List<SysUser> sysUserList = sqlSession.selectList("selectAll");
			printSysUserList(sysUserList);
		} finally {
			sqlSession.close();
		}
	}

	private void printSysUserList(List<SysUser> sysUserList) {
		for (SysUser sysUser : sysUserList) {
			System.out.printf("%-4d%4s%4s%4s%4s%4s\n"
					, sysUser.getId()
					, sysUser.getUserName()
					, sysUser.getUserPassword()
					, sysUser.getUserEmail()
					, sysUser.getUserInfo()
					, sysUser.getHeadImg()
					, sysUser.getCreateTime()
					);
		}
	}
}
