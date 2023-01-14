package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.SentCampaignRepository;
import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class SentCampaignService {

    private final SentCampaignRepository sentCampaignRepository;

    public List<SentCampaignDTO> getAllByCampaignId(Long parentId) {
        return sentCampaignRepository.findAllSentCampaignsByParentId(parentId).stream().map(SentCampaign::buildDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<SentCampaignDTO> getAll() {
        return sentCampaignRepository.findAll().stream().map(SentCampaign::buildDTOFromEntity)
                .collect(Collectors.toList());
    }

    public void setAsPending(UUID id) {
        sentCampaignRepository.updateStatus(id.toString(), "PENDING");
    }

    public void setAsFinished(UUID id) {
        sentCampaignRepository.updateStatus(id.toString(), "FINISHED");
    }

    public SentCampaignAddDTO add(SentCampaignAddDTO dto) {
        sentCampaignRepository.insert(dto.getCampaignId(), dto.getTemplateId(), dto.getSender(), dto.getTitle(), dto.getReceiversGroupId());

        return dto;
    }
}
