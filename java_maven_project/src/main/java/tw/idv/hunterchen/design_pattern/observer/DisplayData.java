package tw.idv.hunterchen.design_pattern.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisplayData implements Display {
	private String data;
	private TopicSubject topicSubject;
	
	@Override
	public void display() {
		log.info("data is {}", data);
	}

}
