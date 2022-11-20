package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewDTO;
import com.mailapp.mailapi.modules.campaigns.model.View;
import com.mailapp.mailapi.modules.campaigns.service.ViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("views")
public class ViewController {

    private final ViewService viewService;

    @CrossOrigin
    @GetMapping
    public List<ViewDTO> getTest() {
        return viewService.getAll();
    }

    @CrossOrigin
    @GetMapping(value = "/add", params = {"mail", "uuid"})
    public ViewAddDTO addView(HttpServletRequest http, @RequestParam("mail") String email, @RequestParam("uuid") UUID parentId) {
        System.out.println(http);

        ViewAddDTO dto = ViewAddDTO.builder()
                .id(UUID.randomUUID())
                .email(email)
                .parentId(parentId)
                .date(new Date())
                .build();

        return viewService.add(dto);
    }
}
