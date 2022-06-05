package tw.idv.hunterchen.design_pattern.observer;

public interface Subject {
	// 此介面只有定義行為，並未定義資料 (實作時再補充)
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();	// 資料異動時, 要給觀察者的通知...
}
