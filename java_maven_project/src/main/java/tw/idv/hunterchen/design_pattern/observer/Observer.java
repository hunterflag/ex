package tw.idv.hunterchen.design_pattern.observer;

public interface Observer{
	// 收到發布者的異動更新，要做的行為...
	public void update(String data);	
}
