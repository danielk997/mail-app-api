package com.mailapp.mailapi.modules.campaigns.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignDTO {

    private Long id;
    private String name;
}

