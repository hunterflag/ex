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
import tw.idv.hunterchen.utility.properties.PropertiesUtility;
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
		
		// 準備連線主機、相關設定、登入帳密等
		String host = "127.0.0.1";
		String port = "587";
		String username = "developer";
		String password = "developer";

		// SMTP 設定, 詳見 Package com.sun.mail.smtp 說明
		// https://javaee.github.io/javamail/docs/api/index.html?com/sun/mail/smtp/package-summary.html
//		Properties props = System.getProperties();
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.transport.protocol", "smtp");		// 使用協議
//		props.put("mail.smtp.auth", "true");				// 需要驗證機制: 預設不需要, 只用帳密驗證	 
//		props.put("mail.smtp.starttls.enable", "true");		// 啟用starttls加密
		props.put("mail.smtp.auth.login.disable", "true");		// 啟用starttls加密
//		props.put("mail.smtp.auth.login.disable", "true");		// 啟用starttls加密
		props.put("mail.debug", "true");					// 啟用除錯
		PropertiesUtility.showAllProperties(props);
		 
		
		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		// 發信人Sender's email ID needs to be mentioned
		String from = "developer@127.0.0.21";
		// 收信人Recipient's email ID needs to be mentioned.
		String to = "tester@127.0.0.1";
		// 準備發信內容
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
