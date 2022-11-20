package com.mailapp.mailapi.mail;

import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationDTO;
import com.mailapp.mailapi.modules.configuration.service.SmtpConfigurationService;
import lombok.Data;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Data
@Service
public class MailService {

    private final SmtpConfigurationService smtpConfigurationService;

    public JavaMailSenderImpl getSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        SmtpConfigurationDTO config = smtpConfigurationService.getActiveConfiguration();

        mailSender.setHost(config.getHost());
        mailSender.setPort(config.getPort());
        mailSender.setUsername(config.getUserName());
        mailSender.setPassword(config.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
