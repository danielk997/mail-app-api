package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "VIEWS")
public class View {

    @Id
    @Column(name = "ID")
    private UUID id;

    @NotNull
    @Column(name = "VIEWDATE")
    private Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SENTCAMPAIGNID")
    SentCampaign parent;

    public ViewDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> ViewDTO.builder()
                        .id(getId())
                        .date(getDate())
                        .parent(getParent())
                        .build()
                ).orElse(null);
    }
}
