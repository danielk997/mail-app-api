package com.mailapp.mailapi.mail;

import com.mailapp.mailapi.modules.campaigns.dto.PersonDTO;
import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import com.mailapp.mailapi.modules.campaigns.service.PersonService;
import com.mailapp.mailapi.modules.campaigns.service.SentCampaignService;
import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationDTO;
import com.mailapp.mailapi.modules.configuration.service.SmtpConfigurationService;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Service
public class MailService {

    private final SmtpConfigurationService smtpConfigurationService;
    private final SentCampaignService sentCampaignService;
    private final PersonService personService;

    private final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


    @Scheduled(fixedRate = 1000 * 30)
    private void checkForScheduledCampaigns() {
        List<SentCampaignDTO> campaigns = sentCampaignService.getAll();
        List<SentCampaignDTO> scheduled = getScheduledCampaigns(campaigns);
        List<SentCampaignDTO> pending = getPendingCampaigns(campaigns);


        if (scheduled.size() > 0 && pending.size() == 0) {
            MimeMessage message = getMailSender().createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            SentCampaignDTO toSend = scheduled.get(0);
            sentCampaignService.setAsPending(toSend.getId());
            Long groupId = toSend.getGroup().getId();
            UUID id = toSend.getId();
            List<PersonDTO> receiversList = personService.getByGroupId(groupId);
            String content = toSend.getTemplate().getContent();

            receiversList.forEach(it -> {
                Document doc = Jsoup.parse(content);
                Element pixel = doc.createElement("img");
                pixel.attr("src", String.format("http://localhost:8080/views/add?mail=%s&uuid=%s", it.getEmail(), id.toString()));
                doc.appendChild(pixel);
                doc.getElementsByTag("a").forEach(link ->
                        link.attr("href", link.attr("href").replace(
                                link.attr("href"), String.format("http://localhost:8080/views/click?mail=%s&uuid=%s&redirectURL=%s", it.getEmail(), id.toString(), link.attr("href")))
                        ));

                try {
                    helper.setFrom("mailapp@x.com", toSend.getSender());
                    helper.setTo(it.getEmail());
                    helper.setSubject(toSend.getTitle());
                    helper.setText(doc.html(), true);
                } catch (MessagingException | UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }

                getMailSender().send(message);
            });

            sentCampaignService.setAsFinished(toSend.getId());
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

    private List<SentCampaignDTO> getPendingCampaigns(List<SentCampaignDTO> campaigns) {
        return campaigns.stream().filter(it -> it.getStatus().equals("PENDING")).collect(Collectors.toList());
    }
}
