package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import com.mailapp.mailapi.modules.campaigns.model.View;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class ViewDTO {

    private Long id;
    private Date date;
    private String email;
    private SentCampaign parent;

    public View buildEntityFromDTO() {
        return Optional.of(this)
                .map(it -> View.builder()
                        .id(getId())
                        .date(getDate())
                        .parent(getParent())
                        .build()
                ).orElse(null);
    }
}
