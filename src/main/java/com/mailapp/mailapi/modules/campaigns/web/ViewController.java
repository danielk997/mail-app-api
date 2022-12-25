package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.mail.MailService;
import com.mailapp.mailapi.modules.campaigns.dto.ClickAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewDTO;
import com.mailapp.mailapi.modules.campaigns.service.ViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("views")
public class ViewController {

    private final ViewService viewService;
    private final MailService mailSender;

    @CrossOrigin
    @GetMapping
    public List<ViewDTO> getAll() {
        return viewService.getAll();
    }

    @CrossOrigin
    @GetMapping(value = "/add", params = {"mail", "uuid"})
    public ViewAddDTO add(HttpServletRequest http, @RequestParam("mail") String email, @RequestParam("uuid") UUID parentId) {
        System.out.println(http);

        sendMessage();

        ViewAddDTO dto = ViewAddDTO.builder()
                .email(email)
                .parentId(parentId)
                .date(new Date())
                .build();

        return viewService.add(dto);
    }

    @GetMapping(value = "/click", params = {"mail", "uuid"})
    public RedirectView addClick(
            HttpServletRequest http,
            @RequestParam("mail") String email,
            @RequestParam("uuid") UUID parentId,
            @RequestParam("redirectURL") String redirectURL
    ) {
        //http://localhost:8080/views/click?mail=x@vp.pl&uuid=3B0BC000-05D5-4207-9E5C-1F18C7E13B0D&redirectURL=https://onet.pl
        System.out.println(http);

        ClickAddDTO dto = ClickAddDTO.builder()
                .email(email)
                .parentId(parentId)
                .redirectURL(redirectURL)
                .build();

        viewService.addClick(dto);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectURL);
        return redirectView;
    }

    private void sendMessage() {
//        JavaMailSenderImpl emailSender = mailSender.getSender();
//        MimeMessage message = emailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        String content = "<h2 style=\"color: blue\">Test 123</h2>";
//
//        try {
//            helper.setFrom("test@vp.pl");
//            helper.setTo("danielkociolek@vp.pl");
//            helper.setSubject("Wiadomość test 1");
//            helper.setText(content, true);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//
//        emailSender.send(message);
    }
}
//a0c8c5508ca627c2e6eab5b10d2ff336-2de3d545-59e55d55