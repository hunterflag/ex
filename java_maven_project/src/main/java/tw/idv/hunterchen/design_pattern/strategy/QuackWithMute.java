package tw.idv.hunterchen.design_pattern.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuackWithMute implements QuackBehavior {

	@Override
	public void quack() {
		log.info("Quack with {}", "No Sound...");
	}

}
