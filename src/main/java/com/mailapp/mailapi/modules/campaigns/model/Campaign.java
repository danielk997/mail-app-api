package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Campaigns")
public class Campaign {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public CampaignDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> CampaignDTO.builder()
                        .id(id)
                        .name(name)
                        .build()
                ).orElse(null);
    }
}
