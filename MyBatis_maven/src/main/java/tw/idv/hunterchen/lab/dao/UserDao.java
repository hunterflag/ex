package tw.idv.hunterchen.lab.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tw.idv.hunterchen.lab.model.User;

public class UserDao {
	private static Reader reader;
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;
	private static UserMapper userMapper;
	static {
		try {
			// 1. 取得 MyBatis配置
			reader = Resources.getResourceAsReader("config/MyBatisConfig.xml");		
			// 2. 依配置文件建立 sqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
			// 3. 從 sqlSessionFactory 開啟 sqlSession
			sqlSession = sqlSessionFactory.openSession();	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int insert(String userName) {
		User user = new User();
		user.setName(userName);
		return insert(user);
	}

	public static int insert(User user) {
		int result=0;
		try {
			// 4. 以 sqlSession 調用 Mapper (DAO) 中的方法、在DB中執行SQL述句, 並將結果從DB放到DVO
			User user2 = (User) sqlSession.selectOne("tw.idv.hunterchen.lab.mapper.UserMapper.getUserById", 3);
			sqlSession .selectOne("tw.idv.hunterchen.lab.mapper.UserMapper.getUserById", 3);
			// 5. 在 DVO中操作資料
			if (user2!=null) {
				System.out.println(user2.getName());
			} else {
				System.out.println("member is null");					
			}
			
			// 4. 從 sqlSession 取得 Mapper
			user2 = userMapper.selectOneById(1);
			if (user2 != null) {
				System.out.println(user2);
			}else {
				System.out.println("user is null");
				
			}
			
			
			String userName="java";
			user2 = userMapper.selectOneByName(userName);
			if (user2 != null) {
				System.out.println("====>"+user2);
			}
			
			Integer insertedId = userMapper.update("java14", 1);
			if (insertedId != null) {
				System.out.println(insertedId);
			}
			
			
			
			
		} finally {
			// 6. 關閉 sqlSession
			System.out.println("==== Goodbye MyBatis!! ====");
			sqlSession.commit();
			sqlSession.close();
		}

		return result;
	}
	

}
