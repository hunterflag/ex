package tw.idv.hunterchen.design_pattern.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldOutState implements State {
	Machine machine;	// 擁有此狀態的機器
	
	// 建立狀態時一定要指定機器
	public SoldOutState(Machine machine) {
		super();
		this.machine = machine;
	}
	
	@Override
	public void insertQuarter() {
		log.info("已銷售一空, 勿再投入硬幣");
	}

	@Override
	public void ejectQuarter() {
		log.info("已銷售一空, 哪來退回硬幣");
	}

	@Override
	public void turnCrank() {
		log.info("已銷售一空, 再轉動旋鈕也是沒有");
	}

	@Override
	public void dispense() {
		log.info("已銷售一空, 無法掉出糖果");
	}

}
