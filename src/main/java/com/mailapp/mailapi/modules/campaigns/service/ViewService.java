package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.ClickRepository;
import com.mailapp.mailapi.modules.campaigns.dao.SentCampaignRepository;
import com.mailapp.mailapi.modules.campaigns.dao.ViewRepository;
import com.mailapp.mailapi.modules.campaigns.dto.ClickAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.StatsDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewDTO;
import com.mailapp.mailapi.modules.campaigns.model.Click;
import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import com.mailapp.mailapi.modules.campaigns.model.View;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ViewService {

    private final ViewRepository viewRepository;
    private final ClickRepository clickRepository;
    private final SentCampaignRepository sentCampaignRepository;

    public List<ViewDTO> getAll() {
        return viewRepository.findAllViews().stream().map(View::buildDTOFromEntity)
                .collect(Collectors.toList());
    }

    public ViewAddDTO add(ViewAddDTO dto) {
        SentCampaign sentCampaign = sentCampaignRepository.findById(dto.getParentId()).orElse(null);
        viewRepository.saveAndFlush(dto.buildEntityFromDTO(sentCampaign));

        return dto;
    }

    public ClickAddDTO addClick(ClickAddDTO dto) {
        SentCampaign sentCampaign = sentCampaignRepository.findById(dto.getParentId()).orElse(null);
        clickRepository.save(dto.buildEntityFromDTO(sentCampaign));

        return dto;
    }

    public StatsDTO getStats(UUID uuid) {
        return StatsDTO.builder()
                .views(viewRepository.findAllByCampaignId(uuid).stream().map(View::buildDTOFromEntity).collect(Collectors.toList()))
                .clicks(clickRepository.findAllByCampaignId(uuid).stream().map(Click::buildDTOFromEntity).collect(Collectors.toList()))
                .build();
    }
}
