package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.GroupDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RECEIVERGROUP")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    public GroupDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> GroupDTO.builder()
                        .id(getId())
                        .name(getName())
                        .build()
                ).orElse(null);
    }
}
