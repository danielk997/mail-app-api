package com.mailapp.mailapi.modules.campaigns.model;

import com.mailapp.mailapi.modules.campaigns.dto.TemplateDTO;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TEMPLATES")
public class Template {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "CONTENT")
    @NotNull
    private String content;

    public TemplateDTO buildDTOFromEntity() {
        return Optional.of(this)
                .map(it -> TemplateDTO.builder()
                        .id(getId())
                        .name(getName())
                        .content(getContent())
                        .build()
                ).orElse(null);
    }
}
