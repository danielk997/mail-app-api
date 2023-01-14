package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
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
    private CampaignDTO parent;
    private TemplateDTO template;
    private GroupDTO group;
    private String status;
    private String sender;
    private String title;
}


