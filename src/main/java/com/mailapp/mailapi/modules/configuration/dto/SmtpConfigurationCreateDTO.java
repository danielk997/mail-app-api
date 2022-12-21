package com.mailapp.mailapi.modules.configuration.dto;

import com.mailapp.mailapi.modules.configuration.model.SmtpConfiguration;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class SmtpConfigurationCreateDTO {


    private String host;
    private String userName;
    private String password;
    private Integer port;

    public SmtpConfiguration buildEntityFromDTO() {
        return Optional.of(this)
                .map(it -> SmtpConfiguration.builder()
                        .host(getHost())
                        .userName(getUserName())
                        .password(getPassword())
                        .port(getPort())
                        .active(false)
                        .build()
                ).orElse(null);
    }
}
