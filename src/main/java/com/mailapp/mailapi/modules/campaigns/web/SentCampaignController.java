package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import com.mailapp.mailapi.modules.campaigns.service.SentCampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sent-campaigns")
public class SentCampaignController {

    private final SentCampaignService sentCampaignService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/{id}")
    public List<SentCampaignDTO> getById(@PathVariable Long id) {
        return sentCampaignService.getAllByCampaignId(id);
    }

    @PostMapping
    public SentCampaignAddDTO addSentCampaign
            (@RequestBody SentCampaignAddDTO dto) {
        return sentCampaignService.add(dto);
    }
}
