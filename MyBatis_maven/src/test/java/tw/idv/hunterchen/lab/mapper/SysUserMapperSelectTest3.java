package tw.idv.hunterchen.lab.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.Assert;
import tw.idv.hunterchen.lab.model.SysRole;
import tw.idv.hunterchen.lab.model.SysUser;

@SuppressWarnings("deprecation")
public class SysUserMapperSelectTest3 extends BaseMapperTest{
		
	@Test
	public void testSelectRoleByUserId2() {
		// 1.先取得 SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//2.取得映射器
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			
			//3.執行Sql述句、取得結果
			List<SysRole> sysRoleList = sysUserMapper.selectRolesByUserId2((long) 1);
			//4.檢驗
			Assert.assertNotNull(sysRoleList);
			
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectRoleByUserId() {
		// 1.先取得 SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//2.取得映射器
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			
			//3.執行Sql述句、取得結果
			List<SysRole> sysRoleList = sysUserMapper.selectRolesByUserId((long) 1);
			//4.檢驗
			Assert.assertNotNull(sysRoleList);
			
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectById() {
		// 1.先取得 SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//2.取得映射器
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
					
			//3.執行Sql述句、取得結果
			SysUser sysUser = sysUserMapper.selectById((long) 1);
			//4.檢驗
			Assert.assertNotNull(sysUser);
			Assert.assertEquals("admin", sysUser.getUserName());
			
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectAll() {
		// 1.先取得 SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//2.取得映射器
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			
			//3.執行Sql述句、取得結果
			List<SysUser> sysUserList = sysUserMapper.selectAll();
//			List<SysUser> sysUserList = sqlSession.selectList("tw.idv.hunterchen.lab.mapper.SysUserMapper.selectAll");
			//4.檢驗
			Assert.assertNotNull(sysUserList);
			Assert.assertTrue(sysUserList.size() > 0);
			printSysUserList(sysUserList);
		} finally {
			sqlSession.close();
		}
	}

	private void printSysUserList(List<SysUser> sysUserList) {
		for (SysUser sysUser : sysUserList) {
			System.out.printf("%-5d%-10s%-10s%-40s%-10s%-10s\n"
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
