package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import com.mailapp.mailapi.modules.campaigns.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("campaigns")
public class CampaignController {

    private final CampaignService campaignService;
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public List<CampaignDTO> getAll() {
        return campaignService.getAll();
    }
}
