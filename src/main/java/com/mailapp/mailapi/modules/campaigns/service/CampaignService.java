package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.CampaignRepository;
import com.mailapp.mailapi.modules.campaigns.dto.CampaignAddDTO;
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

    public CampaignAddDTO add(CampaignAddDTO dto) {
        Campaign campaignToAdd = new Campaign();
        campaignToAdd.setName(dto.getName());

        campaignRepository.saveAndFlush(campaignToAdd);
        return dto;
    }

    public CampaignDTO update(CampaignDTO dto) {
        Campaign campaignToUpdate = campaignRepository.findById(dto.getId()).orElse(null);

        if (campaignToUpdate == null) {
            return null;
        }

        campaignToUpdate.setName(dto.getName());

        campaignRepository.saveAndFlush(campaignToUpdate);
        return dto;
    }
}