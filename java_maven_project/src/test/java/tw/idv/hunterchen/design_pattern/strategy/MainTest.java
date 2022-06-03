package tw.idv.hunterchen.design_pattern.strategy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainTest {
	
	@Test
	public void duckTest() {
		log.info(null);
		Duck duck = new Duck();
		
//		duck.setFlyBehavior(new FlyWithWings());
		duck.performFly();
		duck.performQuack();
//		duck.setFlyBehavior(new FlyWithNoWay());
//		duck.performFly();
	}
		
	@Test
	public void rubberDuckTest() {
		log.info(null);
		Duck duck = new RubberDuck();
		
		duck.performFly();
		duck.performQuack();
		
	}
	
	@Test
	public void mallardDuckTest() {
		log.info(null);
		Duck duck = new MallardDuck();
		
		duck.performFly();
		duck.performQuack();
		
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
