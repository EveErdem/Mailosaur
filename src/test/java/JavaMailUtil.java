import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMailUtil {
public static void sendmail(String recepient) throws MessagingException {
    System.out.println("preparing send to email");
    Properties properties=new Properties();
    properties.put("mail.smptp.auth","true");
    properties.put("mail.smptp.starttls.enable","true");
    properties.put("mail.smptp.host","smtp.gmail.com");
    properties.put("mail.smptp.port","587");

    String myaccountmail="la.crymosa321@gmail.com";
    String password="rycza6-cynhic-tokRaz";
    Session session=Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myaccountmail,password);
        }
    });
    Message message=prepareMessage(session,myaccountmail,recepient);
    Transport.send(message);
    System.out.println("message send succesfully");

}

    private static Message prepareMessage(Session session, String myaccountmail, String recepient)  {
    try{
        Message message= new MimeMessage(session);
        message.setFrom(new InternetAddress(myaccountmail));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
        message.setSubject("my first email java app");
        message.setText("hey there, \n look my email");
        return message;
    }catch (Exception ex){
        Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,ex);
    }
    return null;

    }
}
