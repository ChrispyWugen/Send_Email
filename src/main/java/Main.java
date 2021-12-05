/**
 * An implementation of Main
 * in CW_SendMail
 *
 * @author chris
 * @version 1.0
 * @since 2021-Dez-05
 */

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    public static void main(String[] args) {

        try {

            //create config file and read properties
            System.out.println("Read Config");
            Configuration config = Configuration.getInstance();
            config.readConfiguration();
            System.out.println("Reading Config successful"+"\n");

            System.out.println("Found User: " + config.getUser());
            System.out.println("Found Password: " + config.getPassword());
            System.out.println("Found Content: " + config.getContent());
            System.out.println("Found RecipientMail: " + config.getRecipientMail());
            System.out.println("Found SenderMail: " + config.getSenderMail());
            System.out.println("Found System: " + config.getSystem());


            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", config.getSystem());
            properties.setProperty("mail.user", config.getUser());
            properties.setProperty("mail.password", config.getPassword());
            //properties.setProperty("mail.smtp.socketFactory.port","25"); TODO
            //properties.setProperty("mail.smtp.port","465"); TODO

            // Get the default Session object.
            Session session = Session.getDefaultInstance(properties);

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(config.getSenderMail()));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(config.getRecipientMail()));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */



    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */



    /* ---------------------------------------- toString ----------------------------------------------------------- */

}
