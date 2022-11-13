package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.CampaignRepository;
import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import com.mailapp.mailapi.modules.campaigns.model.Campaign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public List<CampaignDTO> getAll() {
        return campaignRepository.findAll().stream().map(Campaign::buildDTOFromEntity)
                .collect(Collectors.toList());
    }
}
