package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import lombok.Getter;
import lombok.Setter;

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
@Table(name = "CAMPAIGNS")
public class Campaign {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    @NotNull
    private String name;

    public CampaignDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> CampaignDTO.builder()
                        .id(getId())
                        .name(getName())
                        .build()
                ).orElse(null);
    }
}
