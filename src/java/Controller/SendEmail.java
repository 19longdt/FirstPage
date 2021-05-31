/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author hp
 */
import Entity.User;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    //generate vrification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendEmail(User user) {
        boolean test = false;

        String toEmail = user.getMail();
        String fromEmail = "yeuemtoichet@gmail.com";
        String password = "longdtfptu198";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
//            pr.put("mail.smtp.socketFactory.port", "587");
//            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            try {
                //set email message details
                Message mess = new MimeMessage(session);

                //set from email address
                mess.setFrom(new InternetAddress(fromEmail));
                //set to email address or destination email address
                mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
                //set email subject
                mess.setSubject("Order Confirmation");

                //set message text
                mess.setText("Hi " + user.getName() +"! Ordered successfully. Please Confirm your Order using this code: " + user.getCode());
                //send the message
                Transport.send(mess);

                test = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
}
