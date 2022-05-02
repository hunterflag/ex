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
	private static SqlSessionFactory sqlSessionFactory;
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
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void selectAllTest() {
		log.info("");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<UserModel> userModels = userMapper.selectAll();
		log.info("size={}", userModels.size());
		userModels.forEach((userModel) -> {
			log.info("\n\tid={}\n\tname={}"
					, userModel.getId()
					, userModel.getName() 
					);
		});
	}

	@AfterClass
	public static void afterClass() {
		log.info("");
//		sqlSessionFactory.get
	}

}
