package com.mailapp.mailapi.modules.campaigns.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SentCampaignAddDTO {

    private String sender;
    private String title;
    private Long campaignId;
    private Long templateId;
    private Long receiversGroupId;
}
