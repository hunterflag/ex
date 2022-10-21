package tw.idv.hunterchen.persistence;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.persistence.mapper.UserMapper;
import tw.idv.hunterchen.persistence.model.UserModel;

@Slf4j
public class UserMapperTest {
	private static SqlSessionFactory mSqlSessionFactory;
	private static SqlSession mSqlSession;
	private static UserMapper mUserMapper = mSqlSession.getMapper(UserMapper.class);
	
	@BeforeClass
	public static void beforeClass() {
		log.info("");
		try {
			/* MBH.mark: Resources 是 system path, 
			 * system path: "./config/MyBatisConfig.xml" 或 "config/MyBatisConfig.xml"
			 * classpath: "/config/MyBatisConfig.xml"
			 * FQDN: "/mybatis/src/main/resources/config/MyBatisConfig.xml"
			 */
			Reader reader = Resources.getResourceAsReader("./config/MyBatisConfig.xml");
			mSqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			mSqlSession = mSqlSessionFactory.openSession();
			mUserMapper = mSqlSession.getMapper(UserMapper.class);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void selectAllTest() {
		log.info("selectAllTest()");
		List<UserModel> userModels = mUserMapper.selectAll();
		log.info("size={}", userModels.size());
		userModels.forEach((userModel) -> {
			log.info("\n\tid={}\n\tname={}"
					, userModel.getId()
					, userModel.getName() 
					);
		});
	}
	
	@Test
	public void insertTest() {
		log.info("insertTest()");
		mUserMapper.insert("Hunter");
		
	}

	@AfterClass
	public static void afterClass() {
		log.info("afterClass()");
//		sqlSessionFactory.get
	}

}
