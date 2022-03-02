package tw.idv.hunterchen.utility.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class SmtpClient {
	private String host;
	private String port;
	private String username;
	private String password;

	public boolean connect() {
		log.trace(null);
		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean sendMail(MailDTO mail) {
		log.info(null);
		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
}
