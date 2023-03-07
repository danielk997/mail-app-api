package com.mailapp.mailapi.modules.campaigns.model;


import com.mailapp.mailapi.modules.campaigns.dto.PersonDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RECEIVERS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "EMAIL")
    @NotNull
    private String email;

    public PersonDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> PersonDTO.builder()
                        .id(getId())
                        .name(getName())
                        .email(getEmail())
                        .build()
                ).orElse(null);
    }
}
