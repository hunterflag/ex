package tw.idv.hunterchen.design_pattern.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HasQuarterState implements State {
	Machine machine;	// 擁有此狀態的機器
	
	// 建立狀態時一定要指定機器
	public HasQuarterState(Machine machine) {
		super();
		this.machine = machine;
	}
	
	@Override
	public void insertQuarter() {
		log.info("已經投入硬幣, 不需再投");
	}

	@Override
	public void ejectQuarter() {
		log.info("退回硬幣");
		machine.setCurrentState(machine.getNoQuarterState());	// 狀態轉換
	}

	@Override
	public void turnCrank() {
		log.info("轉動旋鈕, 進入銷售程序...");
		machine.setCurrentState(machine.getSoldState());	// 狀態轉換
	}

	@Override
	public void dispense() {
		log.info("等一下, 掉出糖果");
	}

}
