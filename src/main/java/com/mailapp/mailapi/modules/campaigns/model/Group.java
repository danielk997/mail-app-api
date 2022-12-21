package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.GroupDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Entity
@Getter
@Setter
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
