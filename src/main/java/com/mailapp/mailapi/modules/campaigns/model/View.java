package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import com.mailapp.mailapi.modules.campaigns.dto.SentCampaignDTO;
import com.mailapp.mailapi.modules.campaigns.dto.ViewDTO;
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
@Table(name = "VIEWS")
public class View {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "VIEWDATE")
    private Date date;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
