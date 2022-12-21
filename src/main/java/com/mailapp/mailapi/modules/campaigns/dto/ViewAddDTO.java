package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import com.mailapp.mailapi.modules.campaigns.model.View;
import com.mailapp.mailapi.modules.campaigns.service.SentCampaignService;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class ViewAddDTO {

    private Long id;
    private Date date;
    private String email;
    private UUID parentId;

    public View buildEntityFromDTO(SentCampaign sentCampaign) {
        return Optional.of(this)
                .map(it -> View.builder()
                        .id(getId())
                        .date(getDate())
                        .email(getEmail())
                        .parent(sentCampaign)
                        .build()
                ).orElse(null);
    }
}
