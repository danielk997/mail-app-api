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

}
