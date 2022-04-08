package tw.idv.hunterchen.lab.model;

import lombok.Data;

@Data
public class AppConfigModel extends AbstractModel{
	private String keyName;
	private String keyValue;
}
