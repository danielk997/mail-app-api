package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.Group;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Builder
public class GroupAddDTO {

    private String name;

    private List<PersonDTO> receivers;

    public Group generateEntityFromDTO() {
        return Optional.of(this).map(it ->
                Group.builder()
                        .name(getName())
                        .build()
        ).orElse(null);
    }
}
