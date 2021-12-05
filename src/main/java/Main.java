/**
 * An implementation of Main
 * in CW_SendMail
 *
 * @author chris
 * @version 1.0
 * @since 2021-Dez-05
 */

import org.apache.commons.configuration2.interpol.ExprLookup;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    public static void main(String[] args) {

        try {

            //create config file and read properties
            System.out.println("APP: Read Config");
            Configuration config = Configuration.getInstance();
            config.readConfiguration();
            System.out.println("APP: Reading Config successful"+"\n");

            System.out.println("APP: Found User: " + config.getUser());
            System.out.println("APP: Found Password: " + config.getPassword());
            System.out.println("APP: Found Content: " + config.getContent());
            System.out.println("APP: Found RecipientMail: " + config.getRecipientMail());
            System.out.println("APP: Found SenderMail: " + config.getSenderMail());
            System.out.println("APP: Found System: " + config.getSystem());

            //set values from config and/or create necessary objects
            final String curUser = config.getUser();
            final String curPassword = config.getPassword();
            InternetAddress addressFrom = new InternetAddress(config.getSenderMail());
            InternetAddress addressTo = new InternetAddress(config.getRecipientMail());

            // Get system properties
            Properties properties = System.getProperties();
            // Setup mail server data
            properties.setProperty("mail.smtp.host", config.getSystem());
            properties.put("mail.smtp.auth","true");
            properties.put("mail.smtp.port","587");//587 for gmail
            properties.put("mail.debug","true");
            properties.put("mail.smtp.ssl.trust",config.getSystem());
            properties.setProperty("mail.smtp.starttls.enable", "true");

            //create authentication object
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(curUser,curPassword);
                }
            };

            // Get the default Session object.
            Session session = Session.getDefaultInstance(properties, auth);

            //debug
            //Transport transport = session.getTransport(); //debug1/3


            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            //set header fields
            message.setSender(addressFrom);
            message.addRecipient(Message.RecipientType.TO, addressTo);
            message.setSubject("This is the Subject Line!");
            // Now set the actual message
            message.setContent("This is actual message", "text/plain");

            // Send message
            //transport.connect(); //debug2/3
            Transport.send(message);
            //transport.close(); //debug3/3
            System.out.println("APP: Sent message successfully....");

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
