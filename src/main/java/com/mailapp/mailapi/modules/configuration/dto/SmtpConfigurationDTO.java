package com.mailapp.mailapi.modules.configuration.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SmtpConfigurationDTO {


    private UUID id;
    private String host;
    private String userName;
    private String password;
    private Integer port;
    private Boolean active;
}
