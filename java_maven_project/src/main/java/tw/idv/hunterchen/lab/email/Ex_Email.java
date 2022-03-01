package tw.idv.hunterchen.lab.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.utility.DevTool;
/*
 * http://tw.gitbook.net/javamail_api/javamail_api_sending_simple_email.html
 * 主機資訊:
 * host
 * port
 * 連線:
 * username
 * password
 * ...
 * 信件:
 * from
 * to, cc, bcc
 * subject
 * content
 * MIME
 * 
 */

@Slf4j
public class Ex_Email {
	public static void main(String[] args) {
		log.info("<=MBH=> start...");
		// 收信人Recipient's email ID needs to be mentioned.
		String to = "developer@127.0.0.1";

		// 發信人Sender's email ID needs to be mentioned
		String from = "developer@127.0.0.1";
		final String username = "developer";// change accordingly
		final String password = "developer";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "127.0.0.1";
		
		Properties props = System.getProperties();
//		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");
		
		DevTool.showSystem();
		
		
		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Testing Subject");

			// Now set the actual message
			message.setText("Hello, this is sample for to check send " + "email using JavaMailAPI ");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
