package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.mail.MailService;
import com.mailapp.mailapi.modules.campaigns.dto.ClickAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewDTO;
import com.mailapp.mailapi.modules.campaigns.service.ViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("views")
public class ViewController {

    private final ViewService viewService;
    private final MailService mailSender;
    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    @CrossOrigin
    @GetMapping
    public List<ViewDTO> getAll() {
        return viewService.getAll();
    }

    @CrossOrigin
    @GetMapping(value = "/add", params = {"mail", "uuid"}, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] add(HttpServletRequest http, @RequestParam("mail") String email, @RequestParam("uuid") UUID parentId) {
        ViewAddDTO dto = ViewAddDTO.builder()
                .email(email)
                .parentId(parentId)
                .date(new Date())
                .build();

        viewService.add(dto);
        Resource pixel = resourceLoader.getResource("classpath:images/pixel.png");

        try {
            return Files.readAllBytes(pixel.getFile().toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/click", params = {"mail", "uuid"})
    public RedirectView addClick(
            HttpServletRequest http,
            @RequestParam("mail") String email,
            @RequestParam("uuid") UUID parentId,
            @RequestParam("redirectURL") String redirectURL
    ) {
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
}
