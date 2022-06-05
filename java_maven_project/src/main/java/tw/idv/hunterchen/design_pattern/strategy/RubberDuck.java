package tw.idv.hunterchen.design_pattern.strategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class RubberDuck extends AbstractDuck{
	public RubberDuck() {
		flyBehavior = new FlyWithNoWay();
		quackBehavior = new QuackWithSqueak();
	}
	
	public void display() {
		log.info("This is a RubberDuck!");
	}
	
	
}
