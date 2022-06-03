package tw.idv.hunterchen.design_pattern.strategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public void performFly(){
		flyBehavior.fly();
	}
	public void performQuack() {
		quackBehavior.quack();
	}
	
	
}
