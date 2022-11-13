package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewDTO;
import com.mailapp.mailapi.modules.campaigns.service.ViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("views")
public class ViewController {

    private final ViewService viewService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public List<ViewDTO> getTest() {
        return viewService.getAll();
    }
}
