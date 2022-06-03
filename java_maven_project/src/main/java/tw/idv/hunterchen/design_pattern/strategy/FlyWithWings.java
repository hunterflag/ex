package tw.idv.hunterchen.design_pattern.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		log.info("Fly with {}", "wings");
	}

}
