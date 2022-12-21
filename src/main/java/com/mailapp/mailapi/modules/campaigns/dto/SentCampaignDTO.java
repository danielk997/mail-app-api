package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.Campaign;
import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import com.mailapp.mailapi.modules.campaigns.model.View;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class SentCampaignDTO {

    private UUID id;
    private Date date;
    private Campaign parent;
    private String status;

    public SentCampaign buildEntityFromDTO() {
        return Optional.of(this)
                .map(it -> SentCampaign.builder()
                        .id(getId())
                        .date(getDate())
                        .parent(getParent())
                        .build()
                ).orElse(null);
    }
}
