package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.Click;
import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

@Data
@Builder
public class ClickDTO {

    private Long id;
    private Date date;
    private String email;
    private SentCampaign parent;
    private String url;

    public Click buildEntityFromDTO() {
        return Optional.of(this)
                .map(it -> Click.builder()
                        .id(getId())
                        .date(getDate())
                        .url(getUrl())
                        .parent(getParent())
                        .build()
                ).orElse(null);
    }
}
