package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.Campaign;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class CampaignDTO {

    private Long id;
    private String name;

    public Campaign buildEntityFromDTO() {
        return Optional.of(this)
                .map(it -> Campaign.builder()
                        .id(getId())
                        .name(getName())
                        .build()
                ).orElse(null);
    }
}
