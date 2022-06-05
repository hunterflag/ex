package tw.idv.hunterchen.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TopicSubject implements Subject {
	// 用來存放 觀察者清單
	private List<Observer> observers = new ArrayList<Observer>();
	// 初始化記得都要實例化，使用建構式也行
	
	private String data;	// 實作類需要的 資料
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	// 設計時, 由上到下
	// 發生時, 由下到上
	@Override
	public void notifyObservers() {
		log.info("...");
		for(Observer observer : observers) {
			observer.update(data);	// 3.逐一通知、並傳遞資料 給 訂閱者
		}
	}
	
	public void dataChanged() {
		log.info("...");
		notifyObservers();		// 2.觸發通知
	}
		
	public void setDatas(String data) {
		log.info("new data is ", data);
		this.data = data;
		dataChanged();		// 1.資料變更
	}

}
