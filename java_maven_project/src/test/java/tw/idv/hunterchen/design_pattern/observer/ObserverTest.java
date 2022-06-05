package tw.idv.hunterchen.design_pattern.observer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObserverTest {
	

	@Test
	public void mainTest() {
		log.info(null);
		// 建立 發布者
		TopicSubject topicSubject = new TopicSubject();
		// 建立 訂閱者者 (並向發布者登記)
		TaipeiObserver taipeiObserver = new TaipeiObserver(topicSubject);
		
		// 發布者資料異動，發出通知給訂閱者
		topicSubject.setDatas("123");
		topicSubject.setDatas("456");
		topicSubject.setDatas("789");
	}
	
	
	
	@BeforeClass
	public static void beforeClass() {
		log.info(null);
	}
	@Before
	public void before() {
		log.info(null);
	}
	@After
	public void after() {
		log.info(null);
	}
	@AfterClass
	public static void afterClass() {
		log.info(null);
	}
}
