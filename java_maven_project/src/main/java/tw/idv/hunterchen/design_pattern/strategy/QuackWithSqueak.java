package tw.idv.hunterchen.design_pattern.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuackWithSqueak implements QuackBehavior {

	@Override
	public void quack() {
		log.info("Quack with {}", "Squeak! Squeak! Squeak!");
	}

}
