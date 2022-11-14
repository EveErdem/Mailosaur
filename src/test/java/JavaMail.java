import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;

public class JavaMail {
    public static void main(String[] args) throws MessagingException {
        JavaMailUtil.sendmail("la.crymosa321@gmail.com");
    }
    @Test
    void name() throws MessagingException {
        JavaMailUtil.sendmail("la.crymosa321@gmail.com");
    }
}
