package tw.idv.hunterchen.design_pattern.state;

public interface State {
	
	// 此狀態會發生的所有行為清單 (包括IPO等3階段)
	// 每個行為都是１個(即將實作的)方法 
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
