package tw.idv.hunterchen.persistence;

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
import tw.idv.hunterchen.persistence.model.Country;

@Slf4j
public class MyBatisBookTest {
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
	public void CountryMapperTest() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<Country> models = sqlSession.selectList("selectAll");
			models.forEach(record -> {
				log.info("id:{}, name= {} ; code= {}"
						, record.getId()
						, record.getCountryName()
						, record.getCountryCode()
						);
			});
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}
	
}
