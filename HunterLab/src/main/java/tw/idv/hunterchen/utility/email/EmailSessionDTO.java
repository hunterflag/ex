package tw.idv.hunterchen.utility.email;

import lombok.Data;

@Data
public class EmailSessionDTO {
	private String host;
	private String port;
	private String username;
	private String password;	
}
