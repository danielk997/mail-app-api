package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "SENTCAMPAIGNS")
public class SentCampaign {

    @Id
    @Type(type="uuid-char")
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Column(name = "STARTDATE")
    private Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CAMPAIGNID")
    Campaign parent;

    public SentCampaignDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> SentCampaignDTO.builder()
                        .id(getId())
                        .date(getDate())
                        .parent(getParent())
                        .build()
                ).orElse(null);
    }
}
