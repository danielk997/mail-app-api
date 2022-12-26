package com.mailapp.mailapi.modules.campaigns.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Column(name = "STARTDATE")
    private Date date;

    @NotNull
    @Column(name = "STATUS")
    private String status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CAMPAIGNID")
    Campaign parent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "TEMPLATEID")
    Template template;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECEIVERSGROUPID")
    Group group;

    public SentCampaignDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> SentCampaignDTO.builder()
                        .id(getId())
                        .date(getDate())
                        .status(getStatus())
                        .parent(getParent().buildDTOFromEntity())
                        .template(getTemplate().buildDTOFromEntity())
                        .group(getGroup().buildDTOFromEntity())
                        .build()
                ).orElse(null);
    }
}
