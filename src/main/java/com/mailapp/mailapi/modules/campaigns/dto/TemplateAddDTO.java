package com.mailapp.mailapi.modules.campaigns.dto;

import com.mailapp.mailapi.modules.campaigns.model.Template;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;


@Data
@Builder
public class TemplateAddDTO {
    private String name;
    private String content;

    public Template generateEntityFromDTO() {
        return Optional.of(this).map(it ->
                Template.builder()
                        .name(getName())
                        .content(getContent()).build()
        ).orElse(null);
    }
}
