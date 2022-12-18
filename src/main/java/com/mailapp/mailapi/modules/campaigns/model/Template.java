package com.mailapp.mailapi.modules.campaigns.model;

import com.mailapp.mailapi.modules.campaigns.dto.TemplateDTO;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

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
