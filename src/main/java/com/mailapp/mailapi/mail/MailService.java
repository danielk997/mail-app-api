package com.mailapp.mailapi.mail;

import com.mailapp.mailapi.modules.campaigns.dao.PersonRepository;
import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import com.mailapp.mailapi.modules.campaigns.model.Person;
import com.mailapp.mailapi.modules.campaigns.service.SentCampaignService;
import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationDTO;
import com.mailapp.mailapi.modules.configuration.service.SmtpConfigurationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Data
@Service
public class MailService {

    private final SmtpConfigurationService smtpConfigurationService;
    private final SentCampaignService sentCampaignService;
    private final PersonRepository personRepository;

    private final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


    @Scheduled(fixedRate = 1000 * 30)
    private void checkForScheduledCampaigns() {
        List<SentCampaignDTO> campaigns = sentCampaignService.getAll();
        List<SentCampaignDTO> scheduled = getScheduledCampaigns(campaigns);

        if (scheduled.size() > 0) {
            Long groupId = scheduled.get(0).getGroup().getId();


        }
    }

    @PostConstruct
    private void setSenderConfig() {
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
    }

    private List<SentCampaignDTO> getScheduledCampaigns(List<SentCampaignDTO> campaigns) {
        return campaigns.stream().filter(it -> it.getStatus().equals("SCHEDULED")).collect(Collectors.toList());
    }
}
