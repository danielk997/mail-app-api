package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.Click;
import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import com.mailapp.mailapi.modules.campaigns.model.View;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class ClickAddDTO {

    private String email;
    private String redirectURL;
    private UUID parentId;

    public Click buildEntityFromDTO(SentCampaign sentCampaign) {
        return Optional.of(this)
                .map(it -> Click.builder()
                        .email(getEmail())
                        .url(redirectURL)
                        .date(new Date())
                        .parent(sentCampaign)
                        .build()
                ).orElse(null);
    }
}
