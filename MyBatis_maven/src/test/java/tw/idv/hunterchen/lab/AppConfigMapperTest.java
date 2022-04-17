package tw.idv.hunterchen.lab;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.lab.dao.UserMapper;
import tw.idv.hunterchen.lab.model.AppConfigModel;
import tw.idv.hunterchen.lab.model.User;
import tw.idv.hunterchen.utility.DevTool;

@Slf4j
public class AppConfigMapperTest {
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
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
	
	@Test()
	public void AppConfigMapperTest() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			String key = "key";
			List<AppConfigModel> models = sqlSession.selectList("getRecordByKey", key);
			DevTool.showMessages(""+models.size());
			AppConfigModel appConfigModel = models.get(0);
			DevTool.showMessages(appConfigModel.getKeyName(), appConfigModel.getKeyValue());
			models.forEach(record -> {
				DevTool.showMessages(key, record.getKeyName(), record.getKeyValue() );
				log.info("the value of key {} is {}", record.getKeyName(), record.getKeyValue());
			});
			String value = sqlSession.selectOne("getValueByKey", key);
			DevTool.showMessages(key, value);
			log.info("the value of key {} is {}", key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}
	
	public void UserTest() {
//		UserMapper userMapper = new UserMapper();
		try {
			List<User> models = UserMapper.getAllRecords();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
