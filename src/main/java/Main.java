/**
 * An implementation of Main
 * in CW_SendMail
 *
 * @author chris
 * @version 1.0
 * @since 2021-Dez-05
 */

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
