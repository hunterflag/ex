package tw.idv.hunterchen.design_pattern.strategy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyTest {
	
//	@Test
//	public void abstractDuckTest() {
//		log.info(null);
//		AbstractDuck duck = new AbstractDuck();
		
//		duck.setFlyBehavior(new FlyWithWings());
//		duck.performFly();
//		duck.performQuack();
//		duck.setFlyBehavior(new FlyWithNoWay());
//		duck.performFly();
//	}
		
	@Test
	public void rubberDuckTest() {
		log.info(null);
		RubberDuck duck = new RubberDuck();
		
		duck.performFly();
		duck.performQuack();
		
	}
	
	@Test
	public void mallardDuckTest() {
		log.info(null);
		MallardDuck duck = new MallardDuck();
		
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
