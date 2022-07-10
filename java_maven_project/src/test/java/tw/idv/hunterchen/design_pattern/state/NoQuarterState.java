package tw.idv.hunterchen.design_pattern.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoQuarterState implements State {
	Machine machine;	// 擁有此狀態的機器
	
	// 建立狀態時一定要指定機器
	public NoQuarterState(Machine machine) {
		super();
		this.machine = machine;
	}
	
	@Override
	public void insertQuarter() {
		log.info("投入硬幣");
		machine.setCurrentState(machine.getHasQuarterState());	// 狀態轉換
	}

	@Override
	public void ejectQuarter() {
		log.info("無硬幣可退回, 別再按了");
	}

	@Override
	public void turnCrank() {
		log.info("請先投幣, 才可轉動旋鈕");
	}

	@Override
	public void dispense() {
		log.info("別傻了！沒有投幣, 怎麼會掉出糖果？");
	}

}
