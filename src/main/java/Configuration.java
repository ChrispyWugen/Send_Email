/**
 * An implementation of Configuration
 * in CW_SendMail
 *
 * @author chris
 * @version 1.0
 * @since 2021-Dez-05
 */


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    private String user = "";
    private String password = "";
    private String content = "";
    private String recipientMail = "";
    private String senderMail = "";
    private String system = "";
    private static Configuration config = null; //singleton

    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */
    /**
     * Class holds the application configuration from properties file
     */
    private Configuration() {
    }

    public static synchronized Configuration getInstance() {
        if (config == null) {
            config = new Configuration();
        }
        return config;
    }


    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    /**
     * Reads a PROPERTIES file and stores the data in a new instance of this class
     *
     * @throws IOException - if no PROPERTIES file can be read
     */
    public void readConfiguration(){
        Properties properties = new Properties();
        BufferedInputStream stream;
        try{
            stream = new BufferedInputStream(new FileInputStream("config.properties"));
            properties.load(stream);
            stream.close();
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("password");
            this.content = properties.getProperty("content");
            this.recipientMail = properties.getProperty("recipientMail");
            this.senderMail = properties.getProperty("senderMail");
            this.system = properties.getProperty("system");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

    public java.lang.String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getContent() {
        return content;
    }

    public String getRecipientMail() {
        return recipientMail;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public String getSystem() {
        return system;
    }

    /* ---------------------------------------- toString ----------------------------------------------------------- */

}
