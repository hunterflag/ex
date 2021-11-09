package tw.idv.hunterchen.lab.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.Assert;
import tw.idv.hunterchen.lab.model.SysUser;

@SuppressWarnings("deprecation")
public class SysUserMapperDeleteTest extends BaseMapperTest{
		
	@Test
	public void testUpdateById() {
		// 1.先取得 SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			Long id = 1010L;
			//2.取得映射器
			SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
			
			//3.執行Sql述句、取得結果
			SysUser sysUser = sysUserMapper.selectById(id);
			printSysUser(sysUser);
			
			int result = sysUserMapper.deleteById(id);
			//4.檢驗
			Assert.assertNotNull(sysUser.getId());
			
			sysUser = sysUserMapper.selectById(id);
			printSysUser(sysUser);
			
		} finally {
			sqlSession.commit();
//			sqlSession.rollback();
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
