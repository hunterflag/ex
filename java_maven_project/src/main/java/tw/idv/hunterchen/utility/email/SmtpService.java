package tw.idv.hunterchen.utility.email;

public interface SmtpService {
	SmtpService connect(String host, String port, String username, String password);
	boolean sendMessage(String toEmail, String subject, String content);
	boolean disconnect(SmtpService smtpInstance);
}
