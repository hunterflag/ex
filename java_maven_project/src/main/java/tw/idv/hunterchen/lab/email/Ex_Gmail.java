package tw.idv.hunterchen.lab.email;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Ex_Gmail {
   public static void main(String[] args) {
      // Recipient's email ID needs to be mentioned.
      String to = "flaghuntertester@gmail.com";//change accordingly

      // Sender's email ID needs to be mentioned
      String from = "flaghuntertester@gmail.com";//change accordingly
      final String username = "flaghuntertester";//change accordingly
      final String password = "bduycoxrocmjlexw";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props;
      props = new Properties();
//      props = System.getProperties();

      props.put("mail.debug", "true");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
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
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         Date now = new Date(); 
         String subject = "Testing Subject: "
//        		 + "[" + now.toGMTString() + "]"
//        		 + "[" + now.toLocaleString() + "]"
        		 + new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss]").format(now)
        		 ; 
         message.setSubject(subject);

         // Now set the actual message
         message.setText("Hello, this is sample for to check send "
            + "email using JavaMailAPI ");

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }
}