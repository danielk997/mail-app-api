package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.Campaign;
import com.mailapp.mailapi.modules.campaigns.model.SentCampaign;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class SentCampaignAddDTO {

    private Long campaignId;
    private Long templateId;
    private Long receiversGroupId;
}
