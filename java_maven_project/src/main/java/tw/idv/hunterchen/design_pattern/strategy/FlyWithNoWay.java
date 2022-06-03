package tw.idv.hunterchen.design_pattern.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyWithNoWay implements FlyBehavior {

	@Override
	public void fly() {
		log.info("Fly with {}", "NoWay");
	}

}
