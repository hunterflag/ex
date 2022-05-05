package tw.idv.hunterchen.persistence;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tw.idv.hunterchen.persistence.model.Member;

public class Main {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("config/MyBatisConfig.xml");		// 1. 取得 MyBatis配置
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		// 2. 依配置文件建立 sqlSessionFactory
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		System.out.println("==== Hello MyBatis!! ====");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();	// 3. 從 sqlSessionFactory 開啟 sqlSession
		try {
				// 4. 以 sqlSession 調用 Mapper (DAO) 中的方法、在DB中執行SQL述句, 並將結果從DB放到DVO
				Member member = (Member) sqlSession.selectOne("tw.idv.hunterchen.lab.mapper.MemberMapper.getMemberById", 3);
				sqlSession .selectOne("tw.idv.hunterchen.lab.mapper.MemberMapper.getMemberById", 3);
				// 5. 在 DVO中操作資料
				if (member!=null) {
					System.out.println(member.getAccount());
				} else {
					System.out.println("member is null");					
				}
				
				// 4. 從 sqlSession 取得 Mapper
					
				
				
				
				
				
		} finally {
				// 6. 關閉 sqlSession
			System.out.println("==== Goodbye MyBatis!! ====");
			sqlSession.commit();
			sqlSession.close();
		}
		
	}

}
