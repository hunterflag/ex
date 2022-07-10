package tw.idv.hunterchen.design_pattern.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldState implements State {
	Machine machine;	// 擁有此狀態的機器
	
	// 建立狀態時一定要指定機器
	public SoldState(Machine machine) {
		super();
		this.machine = machine;
	}
	
	@Override
	public void insertQuarter() {
		log.info("稍待再投入硬幣, 目前正在處理前一筆訂單");
	}

	@Override
	public void ejectQuarter() {
		log.info("不行哦！轉動旋鈕之後, 處理訂單的期間不能退回硬幣了");
	}

	@Override
	public void turnCrank() {
		log.info("不行哦！1個硬幣只能轉動旋鈕1次,請等訂單處理完畢！");
	}

	@Override
	public void dispense() {
		log.info("掉出糖果");
		// 1.先掉顆糖果來完成交貨
		machine.releaseBall();	
		// 2.再依剩餘數量決定下一個狀態
		if(machine.getCounter() > 0){	
			machine.setCurrentState(machine.getNoQuarterState());
		}else {
			machine.setCurrentState(machine.getSoldOutState());
		}
	}

}
