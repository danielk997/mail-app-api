package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.ClickDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CLICKS")
public class Click {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "CHANGEDATE")
    private Date date;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "URL")
    private String url;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SENTCAMPAIGNID")
    SentCampaign parent;

    public ClickDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> ClickDTO.builder()
                        .id(getId())
                        .date(Optional.of(getDate()).orElse(new Date()))
                        .url(getUrl())
                        .email(getEmail())
                        .parent(getParent())
                        .build()
                ).orElse(null);
    }
}
