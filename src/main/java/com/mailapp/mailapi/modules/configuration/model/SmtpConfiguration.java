package com.mailapp.mailapi.modules.configuration.model;

import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationDTO;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "SMTPCONFIGURATIONS")
public class SmtpConfiguration {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @Column(name = "HOST")
    @NotNull
    private String host;

    @Column(name = "USERNAME")
    @NotNull
    private String userName;

    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @Column(name = "PORT")
    @NotNull
    private Integer port;

    @Column(name = "ACTIVE")
    @NotNull
    private Boolean active;

    public SmtpConfigurationDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> SmtpConfigurationDTO.builder()
                        .id(getId())
                        .host(getHost())
                        .userName(getUserName())
                        .password(getPassword())
                        .port(getPort())
                        .active(getActive())
                        .build()
                ).orElse(null);
    }
}
