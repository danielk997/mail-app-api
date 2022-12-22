package com.mailapp.mailapi.modules.campaigns.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDTO {

    private Long id;
    private String name;
    private String email;
}
