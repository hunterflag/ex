package tw.idv.hunterchen.lab.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.Assert;
import tw.idv.hunterchen.lab.model.SysUser;

@SuppressWarnings("deprecation")
public class SysUserMapperTest4 extends BaseMapperTest{
		
	@Test
	public void testInsert3() {
		// 0.
		SysUser sysUser = new SysUser();
		sysUser.setUserName("tester3");
		sysUser.setUserPassword("123456");
		sysUser.setUserEmail("tester3@hunterchen.idv.tw");
		sysUser.setUserInfo("user3 info");
		sysUser.setHeadImg(new byte[]{1,2,3});
		sysUser.setCreateTime(new Date());
		// 1.先取得 SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//2.取得映射器
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			
			//3.執行Sql述句、取得結果
			int result = sysUserMapper.insert3(sysUser);
			//4.檢驗
			Assert.assertNotNull(sysUser.getId());
			
			printSysUser(sysUser);
			sysUser = sysUserMapper.selectById(sysUser.getId());
			printSysUser(sysUser);
			
		} finally {
			sqlSession.commit();
//			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2() {
		// 0.
		SysUser sysUser = new SysUser();
		sysUser.setUserName("tester2");
		sysUser.setUserPassword("123456");
		sysUser.setUserEmail("tester2@hunterchen.idv.tw");
		sysUser.setUserInfo("user2 info");
		sysUser.setHeadImg(new byte[]{1,2,3});
		sysUser.setCreateTime(new Date());
		// 1.先取得 SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//2.取得映射器
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			
			//3.執行Sql述句、取得結果
			int result = sysUserMapper.insert2(sysUser);
			//4.檢驗
			Assert.assertNotNull(sysUser.getId());
		
			printSysUser(sysUser);
			sysUser = sysUserMapper.selectById(sysUser.getId());
			printSysUser(sysUser);
			
		} finally {
			sqlSession.commit();
//			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert() {
		// 0.
		SysUser sysUser = new SysUser();
		sysUser.setUserName("tester1");
		sysUser.setUserPassword("123456");
		sysUser.setUserEmail("tester1@hunterchen.idv.tw");
		sysUser.setUserInfo("user info");
		sysUser.setHeadImg(new byte[]{1,2,3});
		sysUser.setCreateTime(new Date());
		// 1.先取得 SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//2.取得映射器
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			
			//3.執行Sql述句、取得結果
			int result = sysUserMapper.insert(sysUser);
			//4.檢驗
			Assert.assertEquals(1, result);
			
			sysUser = sysUserMapper.selectById(2L);
			System.out.println(sysUser == null ? 0 : sysUser.toString());
			
		} finally {
			sqlSession.commit();
			sqlSession.rollback();
			sqlSession.close();
		}
	}

	private void printSysUserList(List<SysUser> sysUserList) {
		for (SysUser sysUser : sysUserList) {
			printSysUser(sysUser);
		}
	}
	
	private void printSysUser(SysUser sysUser) {
			System.out.printf("====\n%-5d\n%-10s\n%-10s\n%-40s\n%-10s\n%-10s\n%-10s\n"
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
