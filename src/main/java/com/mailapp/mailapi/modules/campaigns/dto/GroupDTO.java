package com.mailapp.mailapi.modules.campaigns.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupDTO {

    private Long id;
    private String name;

    private List<PersonDTO> receivers;
}
