package com.mailapp.mailapi.modules.campaigns.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class TemplateDTO {

    private UUID id;
    private String name;
    private String content;
}
