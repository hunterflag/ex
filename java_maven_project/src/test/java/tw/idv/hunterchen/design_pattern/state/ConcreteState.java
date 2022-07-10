package tw.idv.hunterchen.design_pattern.state;

import lombok.extern.slf4j.Slf4j;

// 每個實作類別都是１種狀態
// 方法的內容就是：該狀態, 對各種(相同)行為的不同反應。原則上每種狀態對相同行為應該是不一樣的反應。
// 
@Slf4j
public class ConcreteState implements State {
	// 1.擁有此狀態的機器
	Machine machine;	
	
	// 2.建立狀態時一定要指定機器(將機器與狀態綁定在一起)
	public ConcreteState(Machine machine) {
		super();
		this.machine = machine;
	}
	// 3.實作本狀態下, 對所有行為的反應 
	// 3.1.調用機器的狀態設定, 以轉換狀態
	// 3.2.委託當前狀態、對應行為的方法, 以做出正確反應(該狀態對操作的反應)
	@Override
	public void insertQuarter() {
		log.info("投入硬幣");
	}

	@Override
	public void ejectQuarter() {
		log.info("退回硬幣");
	}

	@Override
	public void turnCrank() {
		log.info("轉動旋鈕");
	}

	@Override
	public void dispense() {
		log.info("掉出糖果");
	}

}
