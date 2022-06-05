package tw.idv.hunterchen.design_pattern.strategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

// 綠頭鴨
@Slf4j
@Data
public class MallardDuck extends AbstractDuck{
	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new QuackWithGuaGuaGua();
	}

	public void display() {
		log.info("This is a MallardDuck!");
	}
	
	
	
}
