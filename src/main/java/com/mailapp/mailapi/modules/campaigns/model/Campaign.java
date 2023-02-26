package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "CAMPAIGNS")
public class Campaign {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

