package com.mailapp.mailapi.modules.campaigns.dto;


import com.mailapp.mailapi.modules.campaigns.model.Person;
import com.mailapp.mailapi.modules.campaigns.model.Template;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class PersonAddDTO {

    private String name;
    private String email;

    public Person generateEntityFromDTO() {
        return Optional.of(this).map(it ->
                Person.builder()
                        .name(getName())
                        .email(getEmail()).build()
        ).orElse(null);
    }
}
