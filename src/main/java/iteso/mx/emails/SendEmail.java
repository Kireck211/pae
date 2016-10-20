package iteso.mx.emails;

// File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
    private String to;
    private String from;
    private String host;
    private Properties properties;
    private Session session;

    public SendEmail() {
        // Recipient's email ID needs to be mentioned.
        to = "aldomoypb@gmail.com";

        // Sender's email ID needs to be mentioned
        from = "ti679308@iteso.mx";

        // Assuming you are sending email from localhost
        host = "localhost";

        // Get system properties
        properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        session = Session.getDefaultInstance(properties);
    }

    public void sendMessage() {
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Test sending emails with JAVA!");

            // Now set the actual message
            message.setText("Sending email");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
