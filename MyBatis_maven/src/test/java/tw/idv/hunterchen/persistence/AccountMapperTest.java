package tw.idv.hunterchen.persistence;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.persistence.mapper.AccountMapper;
import tw.idv.hunterchen.persistence.model.AccountModel;

@Slf4j
public class AccountMapperTest {
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;
	private AccountMapper accountMapper;
	
	@BeforeClass
	public static void beforeClass() {
		log.info("beforeClass()");
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

		if (sqlSessionFactory != null) sqlSession = sqlSessionFactory.openSession(true);			
	}

	@Before
	public void beforeTest() {
		log.info("beforeTest()");
		if(sqlSession != null) {
			accountMapper = sqlSession.getMapper(tw.idv.hunterchen.persistence.mapper.AccountMapper.class);
		}
	}
	
	@Test
	public void insertTest() {
		log.info("insertTest()");
		String name = "test";
		String password = "test";
//		accountMapper.insert(name, password);
		
		name = "test11";
		password = "test11";
		AccountModel accountModel = new AccountModel();
		accountModel.setName(name);
		accountModel.setPassword(password);
		
		log.info(accountModel.toString());
		accountMapper.insert(accountModel);
		log.info(accountModel.toString());
	}
	
	@Test
	public void selectAllTest() {
		log.info("selectAllTest()");
		try {
			List<AccountModel> accountModels = accountMapper.selectAll();
			log.info("size={}", accountModels.size());			
			
			accountModels.forEach((accountModel) -> {
				log.info(accountModel.toString());
//				showModelDetail(accountModel);
			});
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectOneByNameTest() {
		log.info("selectOneByNameTest");
		log.info(accountMapper.selectOneByName("developer").toString());
	}

	public void showModelDetail(AccountModel accountModel) {
		log.info("\n\tid={}\n\tname={}\n\tpassword={}\n\tcreatedTime={}\n\tmodiifiedTime={}"
				, accountModel.getId()
				, accountModel.getName() 
				, accountModel.getPassword() 
				, accountModel.getCreatedTime() .toLocalDateTime()
				, accountModel.getModifiedTime().toLocaleString()
				);	
	}

	
	
	@After
	public void afterTest() {
		log.info("afterTest()");
	}

	@AfterClass
	public static void afterClass() {
		log.info("afterClass()");
//		sqlSessionFactory.get
	}

}
