package tw.idv.hunterchen.design_pattern.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaipeiObserver implements Observer, Display {
	private TopicSubject topicSubject;	// 觀察者 要訂閱的主題 (發佈者)
	private String data;
	
	// 1.建立 觀察者 時，必須指定 發佈者
	// 2.建立 觀察者 時，要像 發佈者 登記 (訂閱)
	public TaipeiObserver(TopicSubject topicSubject) {
		this.topicSubject=topicSubject;
		topicSubject.registerObserver(this);
	}
	// 收到發布者的異動更新，要做的行為...
	@Override
	public void update(String data) {
		log.info("old data is {}, \nand new data is {}", this.data, data);
		this.data = data;
		display();
	}

	@Override
	public void display() {
		log.info("modified data is {}", data);
	}


}
