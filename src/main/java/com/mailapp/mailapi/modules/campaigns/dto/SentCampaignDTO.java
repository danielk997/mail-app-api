package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.Campaign;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class SentCampaignDTO {

    private UUID id;
    private Date date;
    private Campaign parent;
}
