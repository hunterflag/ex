package tw.idv.hunterchen.lab.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
		
		try {
						
			String fileName = "d:/temp/files/sample.json";
			DataSource dataSource = new FileDataSource(fileName);
			MimeBodyPart messageMimeBodyPart = new MimeBodyPart();
			messageMimeBodyPart.setText("FFFFFF"); // 此時無效?
			
			// 信件內容可有多個 part部分: 內容部分、附件部分
			MimeBodyPart attachMimeBodyPart = new MimeBodyPart();
			attachMimeBodyPart.setDataHandler(new DataHandler(dataSource));
			attachMimeBodyPart.setFileName(fileName);
			

			// 要加入的附件檔
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(attachMimeBodyPart);
			mimeMultipart.addBodyPart(messageMimeBodyPart);
			
			// 準備郵件.預設MIME 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Testing Subject");
			message.setText("<H1>Hello, this is sample</H1> for to check send " + "email using JavaMailAPI ");
			message.setContent(mimeMultipart);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
