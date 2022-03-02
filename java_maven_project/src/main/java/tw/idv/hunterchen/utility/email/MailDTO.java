package tw.idv.hunterchen.utility.email;

import lombok.Data;

@Data
public class MailDTO {
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String content;	
}
