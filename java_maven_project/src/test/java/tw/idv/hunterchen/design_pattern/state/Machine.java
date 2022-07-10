package tw.idv.hunterchen.design_pattern.state;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Machine {
	// 1.建立機器需要的所有狀態物件(均繼承自同一State介面的所有狀態類別)
	// 2.建立機器需要的屬性
	// 3.初始化機器狀態與所有屬性
	// 4.建立機器所需的行為 (與狀態的行為不是同一種)
	State soldOutState;		// 銷售一空
	State noQuarterState;	// 未投入硬幣、待機
	State hasQuarterState;	// 已投入硬幣
	State soldState;		// 待售出
	
	State currentState;
	int counter=0;
	
	public Machine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		soldState = new SoldState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		
		this.counter = numberGumballs;
		if (counter > 0) {
			currentState = noQuarterState; 
		}else {
			currentState = soldOutState; 
		}
	}
	
	public void insertQuarter() {
		log.info("在機器上投入硬幣");
		currentState.insertQuarter();
	}
	
	public void ejectQuarter() {
		currentState.ejectQuarter();
	}
	
	public void releaseBall() {
		
	}
	
	
	
	public void setCurrentState(State state) {
		this.currentState = state;
	}
	
}
