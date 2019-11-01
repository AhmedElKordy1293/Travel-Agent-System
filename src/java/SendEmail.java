/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 *
 * @author Hazem
 */


 

/**
 *
 * @author abdel
 */
public class SendEmail {
 
    /**
     * @param args the command line arguments
     */
    public static void send(String mail, String msg){
        String to = "xxx@gmail.com" ;// valid gmail address. 
        to = mail;
 
        String from = "xx@gmail.com"; // valid gmail address
        from = "zoma9525@gmail.com"; // email ely ento 3amleno
 
        String host = "smtp.gmail.com";
        String password = "01226729951zooma"; // password of the gmaill acc used in from
 
        int port = 587;
 
 
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host",host );
        properties.setProperty("mail.smtp.user", from);
        properties.setProperty("mail.smtp.password", password);
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(properties,null);
 
        try {
 
            MimeMessage message = new MimeMessage(session);
 
            message.setFrom(new InternetAddress(from));
 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
 
            message.setSubject("Test Mail");
 
            message.setText(msg);
 
           Transport transport = session.getTransport("smtp");
           transport.connect(host,from,password);
           InternetAddress[] addresses = new InternetAddress[1];
           addresses[0] = new InternetAddress(to);
           transport.sendMessage(message,addresses);
 
 
        System.out.println("Message Sent Successfully");
    }catch(MessagingException excp){
        System.out.println(excp);
        }
    }
}


    

