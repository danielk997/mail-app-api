package com.mailapp.mailapi.mail;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailSender {

    public static JavaMailSenderImpl getSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.mailgun.org");
        mailSender.setPort(587);
        mailSender.setUsername("postmaster@sandbox3eab8b11f70c4d949b53995817d7e3ec.mailgun.org");
        mailSender.setPassword("a0c8c5508ca627c2e6eab5b10d2ff336-2de3d545-59e55d55");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
