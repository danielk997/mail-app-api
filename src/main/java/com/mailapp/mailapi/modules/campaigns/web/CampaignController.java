package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.modules.campaigns.dto.CampaignAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import com.mailapp.mailapi.modules.campaigns.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping
    public List<CampaignDTO> getAll() {
        return campaignService.getAll();
    }

    @PostMapping
    public CampaignAddDTO addCampaign(@RequestBody CampaignAddDTO dto) {
        return campaignService.add(dto);
    }

    @PutMapping
    public CampaignDTO updateCampaign(@RequestBody CampaignDTO dto) {
        return campaignService.update(dto);
    }
}
